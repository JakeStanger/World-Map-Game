package gui.components.button;

import menu.options.Options;
import util.Main;

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
		if(Main.instanceManager.optionsInstance == null) Main.instanceManager.optionsInstance = new Options(); //Initialise the menu if it has not been already
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.instanceManager.menuInstance.draw = false;
		Main.instanceManager.optionsInstance.draw = true;
		
		if(Main.instanceManager.menuInstance != null) Main.instanceManager.menuInstance = null; //Remove the main menu from memory as you'll never need it on the options screen
	}
}
