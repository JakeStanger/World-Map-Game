package gui.components.button;

public class ButtonQuit extends Button 
{
	public ButtonQuit(int height, String text) 
	{
		super(height, text);
	}

	@Override
	protected void click() 
	{
		System.exit(0);
	}
}
