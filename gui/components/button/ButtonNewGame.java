package gui.components.button;

import main.Main;
import game.Game;

public class ButtonNewGame extends Button
{
	public ButtonNewGame(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		if(Main.instanceManager.gameInstance == null) Main.instanceManager.gameInstance = new Game(); //Initialise the menu if it has not been already
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.instanceManager.menuInstance.draw = false;
		Main.instanceManager.gameInstance.draw = true; //TODO Draw intro at first, finish setup class
		
		if(Main.instanceManager.menuInstance != null) Main.instanceManager.menuInstance = null; //Remove the main menu from memory as you'll never need it on the options screen
	}
}
