package gui.components.button.options;

import gui.components.button.Button;
import launch.WorldMapGame;
import menu.Menu;

public class ButtonMenuReturn extends Button 
{
	public ButtonMenuReturn(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		if(WorldMapGame.menu == null) WorldMapGame.menu = new Menu(); //Initialise the menu if it has not been already
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.WorldMapGame.draw = false;
		Main.WorldMapGame.draw = true;
		
		if(WorldMapGame.options != null) WorldMapGame.options = null; //Remove the main menu from memory as you'll never need it on the options screen
	}
}
