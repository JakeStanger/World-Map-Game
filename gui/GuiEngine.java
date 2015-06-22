package gui;

import gui.components.Toolbar;
import gui.components.panel.toolbar.PanelPlane;

public class GuiEngine
{
	private Toolbar toolbar;
	
	public PanelPlane pnlPlane;
	
	public GuiEngine()
	{
		this.toolbar = new Toolbar();
		
		this.pnlPlane = new PanelPlane();
	}
	
	public void draw()
	{
		toolbar.draw();
		if(pnlPlane.draw) pnlPlane.draw(100, 100);
	}
}
