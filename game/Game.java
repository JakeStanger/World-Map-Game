package game;

import gui.components.panel.Panel;
import main.Main;
import menu.options.Options;

import org.lwjgl.input.Keyboard;

import util.Generator;


public class Game
{	
	/**
	 * True if any game content should be drawn
	 */
	public boolean draw = false;
	/**
	 * True if the game is paused
	 */
	private boolean paused = false;
	private int pauseCount;
	
	private Generator generator = new Generator();
	private Clock clock;
	
	private Panel panel;
	
	public static String START_COUNTRY, START_CITY, END_COUNTRY, END_CITY; //Blank to avoid null pointer exception
	
	public Game()
	{
		this.clock = new Clock(generator);
		this.panel = new Panel();
	}
	
	public void tick()
	{	
		checkForPause();
		if(!paused) //Only tick game if not paused
		{
			drawGame();
			clock.updateClock();
		}
		if (pauseCount > 0) pauseCount--;
		if(paused) clock.drawClock(); //Display the clock even paused
	}
	
	public int minute;
	/**
	 * Draw the main game
	 */
	private void drawGame()
	{
		clock.drawClock();
		panel.draw(0, Main.WINDOW_HEIGHT-100, Main.WINDOW_WIDTH, 100);
	}
	
	/**
	 * Check if the player has requested to pause the game, and if they have pause it.
	 * Also handles unpausing the game again
	 */
	private void checkForPause()
	{
		Options options = Main.instanceManager.optionsInstance;
		
		//Check for game pause
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && paused && pauseCount == 0)
		{
			if(options != null) options.draw = false;
			Main.instanceManager.updateOptions(false);
			
			paused = false;
			pauseCount = 30; //Stop pause spamming
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !paused && pauseCount == 0) 
		{
			System.out.println("Game paused");
			
			Main.instanceManager.updateOptions(true);
			options = Main.instanceManager.optionsInstance;
			
			if(options != null)options.draw = true;
			
			paused = true;
			pauseCount = 30; //Stop pause spamming
		}
	}
}
