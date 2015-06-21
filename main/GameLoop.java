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
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
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
		this.setCamera(); //Update OpenGL settings
		
		//Update instance states
		instanceManager.updateInstances();
		this.menu = instanceManager.menuInstance;
		this.options = instanceManager.optionsInstance;
		this.background = instanceManager.backgroundInstance;
	
		this.game = instanceManager.gameInstance;
		this.intro = instanceManager.introInstance;
		
		//Check which game component should be drawn
		if((menu != null && menu.draw) || (options != null && options.draw)) //Draw background if menu or options loaded
		{
			instanceManager.updateBackground(true);
			this.background = instanceManager.backgroundInstance;
			this.background.draw();
		}
		else instanceManager.updateBackground(false);
		
		//Null check is to stop the game crashing once components are unloaded
		if(menu != null && menu.draw) 
		{
			if(background != null && background.draw) background.draw();
			menu.draw();
		}
		
		if(options != null && options.draw) 
		{
			if(background != null && background.draw) background.draw();
			options.draw(game != null && game.draw);
		}
		
		if(intro != null && intro.draw) intro.draw();
		
		if(game != null && game.draw)
		{
			if(background != null && background.draw) background.draw();
			game.tick();
		}
		
		//Frame update
		Display.update();
		Display.sync(60);
	}
	
	/**
	 * Initial game setup to make sure everything is drawn with the correct orientation
	 * Also enables necessary OpenGL functions
	 */
	private void setCamera()
	{
		glClear(GL_COLOR_BUFFER_BIT); //Clear screen
		
		//Modify projection matrix
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		
		//Enable transparency, so the text doesn't have a black background
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glEnable(GL_TEXTURE_2D); //For loading textures
		
		//Modify modelview matrix
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
}
