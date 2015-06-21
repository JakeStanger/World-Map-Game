package gui.components.button;

import main.Main;

public class ButtonNewGame extends Button
{
	public ButtonNewGame(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		//Begin drawing the game instead of the main menu
		if(Main.instanceManager.introInstance == null)
		{
			Main.instanceManager.updateIntro(true);
		}
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.instanceManager.menuInstance.draw = false;
		Main.instanceManager.introInstance.draw = true;
		
		if(Main.instanceManager.menuInstance != null) 
		{
			Main.instanceManager.updateMenu(false);
		}
	}
}
