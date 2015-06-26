package main;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glViewport;
import game.Game;
import game.Intro;
import menu.Background;
import menu.Menu;
import menu.options.Options;

import org.lwjgl.opengl.Display;

import util.InstanceManager;

public class GameLoop 
{
	private Menu menu;
	private Options options;
	
	private Game game;
	private Intro intro;
	
	private Background background;
	
	private InstanceManager instanceManager;
	
	public GameLoop()
	{
		this.instanceManager = Main.instanceManager;
		
		//Update instance states
		this.menu = instanceManager.menuInstance;
		this.options = instanceManager.optionsInstance;
		this.background = instanceManager.backgroundInstance;
	
		this.game = instanceManager.gameInstance;
		this.intro = instanceManager.introInstance;
		
		try
		{
			while(!Display.isCloseRequested()) //Run the game loop
			{
				tick();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//Close the program
		Display.destroy();
		System.exit(0);
	}
	
	/**
	 * Main game loop
	 * @param main an instance of the main class
	 */
	public void tick()
	{
		this.setupOpenGL(); //Update OpenGL settings
		
		if(!intro.draw) background.draw(); //Check not on screen which does not require background
		if(menu.draw) menu.draw();
		if(options.draw) options.draw(game.draw);
		if(intro.draw) intro.draw();
		if(game.draw) game.tick();
		
		this.clearOpenGL(); //Close previous frame
		
		//Frame update
		Display.update();
		Display.sync(60);
	}
	
	/**
	 * Initial game setup to make sure everything is drawn with the correct orientation
	 * Also enables necessary OpenGL functions
	 */
	private void setupOpenGL()
	{
		//Clear the previous frame
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f); 
		glClear(GL_COLOR_BUFFER_BIT);
		
		//Calculate scaling values
		int width = Main.WINDOW_WIDTH;
		int height = (int)(width / Main.TARGET_ASPECT_RATIO + 0.5f);
		
		if (height > Main.WINDOW_HEIGHT) //If the target height does not fit
		{
		    height = Main.WINDOW_HEIGHT;
		    width = (int)(height * Main.TARGET_ASPECT_RATIO + 0.5f);
		}
		 
		//Set up the new viewport centred in the backbuffer
		int vp_x = (Main.WINDOW_WIDTH  / 2) - (width / 2);
		int vp_y = (Main.WINDOW_HEIGHT / 2) - (height/ 2);
		 
		//glViewport(vp_x,vp_y,width,height);
		
		//Modify projection matrix
		glMatrixMode(GL_PROJECTION);
		glPushMatrix();
		glLoadIdentity();
		glOrtho(0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT, 0, 1, -1);
		
		//Enable transparency, so the text doesn't have a black background
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glEnable(GL_TEXTURE_2D); //For loading textures
		
		//Modify modelview matrix
		glMatrixMode(GL_MODELVIEW);
		glPushMatrix();
		glLoadIdentity();
		
		// Push in scale transformations
		glMatrixMode(GL_MODELVIEW);
		glPushMatrix();
		 
		//Calculate the scale considering the screen size and virtual size
		float scale_x = (float)((float)(Main.WINDOW_WIDTH) / (float)Main.VIRTUAL_WINDOW_WIDTH);
		float scale_y = (float)((float)(Main.WINDOW_HEIGHT) / (float)Main.VIRTUAL_WINDOW_HEIGHT);
		glScalef(scale_x, scale_y, 1.0f);
	}
	
	/**
	 * Tidy up after rendering frame
	 */
	private void clearOpenGL()
	{
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glPopMatrix();
		
		glMatrixMode(GL_PROJECTION);
		glPopMatrix();   
		glMatrixMode(GL_MODELVIEW);
		glPopMatrix();
	}
}
