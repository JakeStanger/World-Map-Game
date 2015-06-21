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
		Main.instanceManager.updateIntro(false);
		Main.instanceManager.introInstance.draw = true;
	}
}
