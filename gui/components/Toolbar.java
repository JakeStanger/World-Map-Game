package gui.components;

import main.Main;
import gui.components.button.game.toolbar.ButtonPlane;
import gui.components.panel.toolbar.PanelToolbar;

public class Toolbar
{
	private PanelToolbar pnlToolbar; //Master bar
	
	//Buttons
	private ButtonPlane btnPlane;
	
	public Toolbar()
	{
		this.pnlToolbar = new PanelToolbar();
		
		this.btnPlane = new ButtonPlane();
	}
	
	public void draw()
	{
		pnlToolbar.draw();
		
		btnPlane.draw(20, Main.WINDOW_HEIGHT-50, 35, 35);
	}
}
