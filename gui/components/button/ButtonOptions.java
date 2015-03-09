package gui.components.button;

import launch.Main;
import menu.options.Options;

public class ButtonOptions extends Button 
{
	public ButtonOptions(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{	
		//Begin drawing the game instead of the main menu
		if(Main.options == null) Main.options = new Options(); //Initialise the menu if it has not been already
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.menu.draw = false;
		Main.options.draw = true;
		
		if(Main.menu != null) Main.menu = null; //Remove the main menu from memory as you'll never need it on the options screen
	}
}
