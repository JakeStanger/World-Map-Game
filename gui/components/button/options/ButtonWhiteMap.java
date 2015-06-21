package gui.components.button.options;

import gui.components.button.Button;
import main.Main;

public class ButtonWhiteMap extends Button 
{
	public ButtonWhiteMap(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		Main.menuTexture = Main.instanceManager.resourceManager.WHITE_MAP;
	}
}
