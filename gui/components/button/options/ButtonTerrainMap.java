package gui.components.button.options;

import gui.components.button.Button;
import main.Main;

public class ButtonTerrainMap extends Button 
{
	public ButtonTerrainMap(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		Main.menuTexture = Main.instanceManager.resourceManagerInstance.TERRAIN_MAP;
	}
}
