package gui.components.button;

import game.Game;
import launch.WorldMapGame;

public class ButtonNewGame extends Button
{
	public ButtonNewGame(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		if(WorldMapGame.game == null) WorldMapGame.game = new Game(); //Initialise the menu if it has not been already
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.WorldMapGame.draw = false;
		Main.WorldMapGame.draw = true; //TODO Draw intro at first, finish setup class
		
		if(WorldMapGame.menu != null) WorldMapGame.menu = null; //Remove the main menu from memory as you'll never need it on the options screen
	}
}
