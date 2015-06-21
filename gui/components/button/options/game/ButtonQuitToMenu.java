package gui.components.button.options.game;

import gui.components.button.Button;
import main.Main;

public class ButtonQuitToMenu extends Button 
{
	public ButtonQuitToMenu(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		//Begin drawing the correct components and stop the unneeded ones
		Main.instanceManager.gameInstance.draw = false;
		Main.instanceManager.optionsInstance.draw = false;
		
		Main.instanceManager.menuInstance.draw = true;
	}
}
