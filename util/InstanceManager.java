package util;

import game.Game;
import game.Intro;
import game.NewGame;
import game.Setup;
import menu.Background;
import menu.Menu;
import menu.options.Options;

/**
 * Handles taking instances in and out of existence.
 * Only handles top-level instances (e.g main, main menu, game)
 * @author Jake
 *
 */
public class InstanceManager //TODO Redesign to have separate method for each class
{
	public Game gameInstance;
	public boolean game;
	
	public Intro introInstance;
	public boolean intro;
	
	public NewGame newGameInstance;
	public boolean newGame;	
	
	public Menu menuInstance;
	public boolean menu;
	
	public Options optionsInstance;
	public boolean options;
	
	public Generator generatorInstance;
	public Setup setupInstance;
	
	public Background backgroundInstance;
	public boolean background;
	
	public InstanceManager()
	{
		//Instances constantly in existence
		generatorInstance = new Generator();
		setupInstance = new Setup(generatorInstance);
		
		this.menu = true; //Draw the menu on game startup
	}
	
	/**
	 * Called every game tick (60 times per second).
	 * Checks whether class instances are still needed and takes them in/out of existence accordingly
	 */
	public void updateInstances()
	{
		if(newGame && newGameInstance == null) newGameInstance = new NewGame();
		if(!newGame) newGameInstance = null;
		
		if(game && gameInstance == null) gameInstance = new Game();
		if(!game) gameInstance = null;
		
		if(intro && introInstance == null) introInstance = new Intro(setupInstance, generatorInstance);
		if (!intro) introInstance = null;
		
		if(menu && menuInstance == null) menuInstance = new Menu();
		if(!menu) menuInstance = null;
		
		if(options && optionsInstance == null) optionsInstance = new Options();
		if(!options) optionsInstance = null;
		
		if(background && backgroundInstance == null) backgroundInstance = new Background();
		if(!background) backgroundInstance = null;
	}
	
	/**
	 * Update the new game instance.
	 * If an instance does not exist one will be created, and vica versa.
	 * @param keepInstance whether or not to keep the instance
	 */
	public void updateNewGame(boolean keepInstance)
	{
		newGame = keepInstance;
		updateInstances();
	}
	
	/**
	 * Update the new game instance.
	 * If an instance does not exist one will be created, and vica versa.
	 * @param keepInstance whether or not to keep the instance
	 */
	public void updateGame(boolean keepInstance)
	{
		game = keepInstance;
		updateInstances();
	}
	
	/**
	 * Update the game instance.
	 * If an instance does not exist one will be created, and vica versa.
	 * @param keepInstance whether or not to keep the instance
	 */
	public void updateIntro(boolean keepInstance)
	{
		intro = keepInstance;
		updateInstances();
	}
	
	/**
	 * Update the menu instance.
	 * If an instance does not exist one will be created, and vica versa.
	 * @param keepInstance whether or not to keep the instance
	 */
	public void updateMenu(boolean keepInstance)
	{
		menu = keepInstance;
		updateInstances();
	}
	
	/**
	 * Update the options instance.
	 * If an instance does not exist one will be created, and vica versa.
	 * @param keepInstance whether or not to keep the instance
	 */
	public void updateOptions(boolean keepInstance)
	{
		options = keepInstance;
		updateInstances();
	}
	
	/**
	 * Update the background instance.
	 * If an instance does not exist one will be created, and vica versa.
	 * @param keepInstance whether or not to keep the instance
	 */
	public void updateBackground(boolean keepInstance)
	{
		background = keepInstance;
		updateInstances();
	}
}
