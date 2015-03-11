package gui.components.button.options;

import gui.components.button.Button;

import java.io.IOException;

import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import util.Main;

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
			Main.menuTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/textures/white/Earth_White_1080.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
