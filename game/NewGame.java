package game;

import main.Main;


/**
 * Handles starting a new game
 * @author Jake
 *
 */
public class NewGame
{	
	public NewGame()
	{
		intro();
	}
	
	private void intro()
	{
		Main.instanceManager.intro = true;
		Main.instanceManager.forceUpdate();
		Main.instanceManager.introInstance.draw = true;
	}
}
