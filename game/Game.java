package game;

import main.Main;
import util.Generator;
import util.InstanceManager;


public class Game 
{	
	/**
	 * True if the game should be drawn
	 */
	public boolean draw = false;
	/**
	 * True if the game is paused
	 */
	public boolean paused = false;
	private Generator generator = new Generator();
	private Clock clock;
	private InstanceManager instanceManager = Main.instanceManager;
	
	public static String START_COUNTRY, START_CITY, END_COUNTRY, END_CITY; //Blank to avoid null pointer exception
	
	public Game()
	{
		this.clock = new Clock(generator);
		this.instanceManager.intro = true;
	}
	
	public void tick()
	{
		clock.updateClock();
		
		if(!paused)
		{
			if(instanceManager.introInstance.drawIntro == true) instanceManager.introInstance.drawIntro();
			if(drawGame == true) drawGame();
		}
	}
	
	/**
	 * True if the main game should be drawn
	 */
	public boolean drawGame = false;
	public int minute;
	/**
	 * Draw the main game
	 */
	private void drawGame()
	{
		//drawBackground();
	}
}
