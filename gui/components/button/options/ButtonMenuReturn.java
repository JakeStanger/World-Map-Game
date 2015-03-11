package gui.components.button.options;

import gui.components.button.Button;
import menu.Menu;
import util.Main;

public class ButtonMenuReturn extends Button 
{
	public ButtonMenuReturn(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		if(Main.instanceManager.menuInstance == null) Main.instanceManager.menuInstance = new Menu(); //Initialise the menu if it has not been already
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.instanceManager.optionsInstance.draw = false;
		Main.instanceManager.menuInstance.draw = true;
		
		if(Main.instanceManager.optionsInstance != null) Main.instanceManager.optionsInstance = null; //Remove the main menu from memory as you'll never need it on the options screen
	}
}
