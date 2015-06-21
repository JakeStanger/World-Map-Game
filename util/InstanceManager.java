package util;

import game.Game;
import game.Intro;
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
public class InstanceManager
{
	public Game gameInstance;
	
	public Intro introInstance;
	
	public Menu menuInstance;
	
	public Options optionsInstance;
	
	public Background backgroundInstance;
	
	public Generator generatorInstance;
	public ResourceManager resourceManagerInstance;
	public Setup setupInstance;
	
	public InstanceManager()
	{	
		load();
	}
	
	private void load()
	{
		//Util instances
		generatorInstance = new Generator();
		resourceManagerInstance = new ResourceManager();
		setupInstance = new Setup(generatorInstance);
		
		//Main game instances
		backgroundInstance = new Background();
		gameInstance = new Game();
		introInstance = new Intro();
		menuInstance = new Menu(resourceManagerInstance);
		optionsInstance = new Options();
	}
}
