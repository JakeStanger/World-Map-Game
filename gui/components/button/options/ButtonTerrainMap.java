package gui.components.button.options;

import gui.components.button.Button;

import java.io.IOException;

import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import util.Main;

public class ButtonTerrainMap extends Button 
{
	public ButtonTerrainMap(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		try 
		{
			Main.menuTexture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("assets/textures/terrain/Earth_Terrain_1080.jpg"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
