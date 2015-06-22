package gui.components.button.options;

import gui.components.button.Button;
import main.Main;
import util.ResourceManager;

public class ButtonTerrainMap extends Button 
{
	public ButtonTerrainMap(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		Main.menuTexture = ResourceManager.TERRAIN_MAP;
	}
}
