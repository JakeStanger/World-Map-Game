package gui.components.button;

import game.NewGame;
import main.Main;

public class ButtonNewGame extends Button
{
	public ButtonNewGame(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		if(Main.instanceManager.newGameInstance == null) 
		{
			Main.instanceManager.newGameInstance = new NewGame(); //Initialise the menu if it has not been already
			Main.instanceManager.newGame = true;
		}
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.instanceManager.menuInstance.draw = false;
		
		if(Main.instanceManager.menuInstance != null)
		{
			Main.instanceManager.menuInstance = null; //Remove the main menu from memory as you'll never need it in game
			Main.instanceManager.menu = false;
		}
	}
}
