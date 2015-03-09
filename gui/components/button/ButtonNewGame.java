package gui.components.button;

import game.Game;
import launch.Main;

public class ButtonNewGame extends Button
{
	public ButtonNewGame(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		if(Main.game == null) Main.game = new Game(); //Initialise the menu if it has not been already
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.menu.draw = false;
		Main.game.draw = true;
		
		if(Main.menu != null) Main.menu = null; //Remove the main menu from memory as you'll never need it on the options screen
	}
}
