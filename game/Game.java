package game;

import gui.components.panel.PanelToolbar;
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
	private PanelToolbar pnlToolbar;
	
	public static String START_COUNTRY, START_CITY, END_COUNTRY, END_CITY; //Blank to avoid null pointer exception
	
	public Game()
	{
		this.clock = new Clock(generator);
		this.pnlToolbar = new PanelToolbar();
	}
	
	public void tick()
	{	
		checkForPause();
		if(!paused) //Only tick game if not paused
		{
			drawGame();
			clock.updateClock();
			pnlToolbar.draw();
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
			options.draw = false;
			
			paused = false;
			pauseCount = 30; //Stop pause spamming
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !paused && pauseCount == 0) 
		{
			options.draw = true;
			
			paused = true;
			pauseCount = 30; //Stop pause spamming
		}
	}
}
