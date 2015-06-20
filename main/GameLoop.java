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
import menu.Background;
import menu.Menu;
import menu.options.Options;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import util.InstanceManager;

public class GameLoop 
{
	private Menu menu;
	private Game game;
	private Options options;
	
	private Background background;
	
	private int pauseCount;
	
	private InstanceManager instanceHandler;
	
	public GameLoop()
	{
		this.instanceHandler = Main.instanceManager;
		
		while(!Display.isCloseRequested()) //Run the game loop
		{
			tick();
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
		instanceHandler.updateInstances();
		this.menu = instanceHandler.menuInstance;
		this.game = instanceHandler.gameInstance;
		this.options = instanceHandler.optionsInstance;
		this.background = instanceHandler.backgroundInstance;
		
		//Check which game component should be drawn
		if((menu != null && menu.draw) || (options != null && options.draw)) //Draw background if menu or options loaded
		{
			this.background = new Background(); //Initialise the menu if it has not been already
			Main.instanceManager.background = true; //Inform instance manager to update
			this.background.draw();
		}
		else
		{
			Main.instanceManager.backgroundInstance = null; //Initialise the menu if it has not been already
			Main.instanceManager.background = false; //Inform instance manager to update
		}
		
		//Null check is to stop the game crashing once components are unloaded
		if(menu != null && menu.draw) 
		{
			menu.draw();
			if(background != null && background.draw) background.draw();
		}
		
		if(options != null && options.draw) 
		{
			options.draw(game != null && game.draw);
			if(background != null && background.draw) background.draw();
		}
		
		if(game != null && game.draw)
		{
			game.tick();
		
			checkForPause();
			if (pauseCount > 0) pauseCount--;
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
	
	/**
	 * Check if the player has requested to pause the game, and if they have pause it.
	 * Also handles unpausing the game again
	 */
	private void checkForPause()
	{
		//Check for game pause
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && game.paused && pauseCount == 0)
		{
			if(options != null) options.draw = false;
			options = null;
			game.paused = false;
			pauseCount = 10;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !game.paused && pauseCount == 0) 
		{
			if(options == null) options = new Options();
			options.draw = true;
			game.paused = true;
			pauseCount = 10;
		}
	}
}
