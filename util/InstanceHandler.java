package util;

import game.Game;
import game.Intro;
import game.Setup;
import menu.Menu;
import menu.options.Options;

/**
 * Handles taking instances in and out of existence
 * @author Jake
 *
 */
public class InstanceHandler
{
	public Game game;
	public boolean gameInstance;
	
	public Intro intro;
	public boolean introInstance;
	
	public Menu menu;
	public boolean menuInstance;
	
	public Options options;
	public boolean OptionsInstance;
	
	public Generator generator;
	public Setup setup;
	
	public InstanceHandler()
	{
		if(gameInstance && game == null) game = new Game();
		if(!gameInstance) game = null;
		
		if(introInstance && intro == null) intro = new Intro(game, setup, generator);
	}
}
