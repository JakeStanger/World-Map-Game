package gui.components.button.options;

import gui.components.button.Button;

import java.io.IOException;

import launch.WorldMapGame;

import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class ButtonWhiteMap extends Button 
{
	public ButtonWhiteMap(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		try 
		{
			WorldMapGame.menuTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/textures/white/Earth_White_1080.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
