package gui.components.button.options;

import gui.components.button.Button;
import main.Main;
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
		if(Main.instanceManager.menuInstance == null)
		{
			Main.instanceManager.menuInstance = new Menu(); //Initialise the menu if it has not been already
			Main.instanceManager.menu = true; //Inform instance manager to update
		}
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.instanceManager.optionsInstance.draw = false;
		Main.instanceManager.menuInstance.draw = true;
		
		if(Main.instanceManager.optionsInstance != null)
		{
			Main.instanceManager.optionsInstance = null; //Remove the main menu from memory as you'll never need it on the options screen
			Main.instanceManager.options = false;
		}
	}
}
