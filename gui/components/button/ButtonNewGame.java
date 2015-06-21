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
		if(Main.instanceManager.newGameInstance == null) 
		{
			Main.instanceManager.updateNewGame(true);
		}
		
		//Begin drawing the correct components and stop the unneeded ones
		Main.instanceManager.menuInstance.draw = false;
		
		if(Main.instanceManager.menuInstance != null)
		{
			Main.instanceManager.updateMenu(false);
		}
	}
}
