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
		System.out.println("Starting new game");
		intro();
	}
	
	private void intro()
	{
		Main.instanceManager.introInstance = new Intro(Main.instanceManager.setupInstance, Main.instanceManager.generatorInstance);
		Main.instanceManager.intro = true;
		Main.instanceManager.introInstance.draw = true;
	}
	
	public void game()
	{
		Main.instanceManager.introInstance = null;
	}
}
