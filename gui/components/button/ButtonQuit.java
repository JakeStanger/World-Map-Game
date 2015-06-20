package gui.components.button;

import org.lwjgl.opengl.Display;

public class ButtonQuit extends Button 
{
	public ButtonQuit(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		Display.destroy();
		System.exit(0);
	}
}
