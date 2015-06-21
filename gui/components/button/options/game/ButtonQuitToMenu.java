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
		if(Main.instanceManager.menuInstance == null)
		{
			Main.instanceManager.updateMenu(true);
		}
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.instanceManager.gameInstance.draw = false;
		Main.instanceManager.optionsInstance.draw = false;
		
		Main.instanceManager.menuInstance.draw = true;
		
		if(Main.instanceManager.gameInstance != null)
		{
			Main.instanceManager.updateGame(false);
		}
		if(Main.instanceManager.optionsInstance != null)
		{
			Main.instanceManager.updateOptions(false);
		}
	}
}
