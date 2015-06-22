package gui;

import gui.components.Toolbar;

public class GuiEngine
{
	private Toolbar toolbar;
	
	public GuiEngine()
	{
		this.toolbar = new Toolbar();
	}
	
	public void draw()
	{
		toolbar.draw();
	}
}
