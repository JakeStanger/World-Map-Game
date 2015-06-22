package gui.components;

import main.Main;
import gui.components.button.game.toolbar.ButtonPlane;
import gui.components.panel.PanelToolbar;

public class Toolbar
{
	private PanelToolbar pnlToolbar; //Master bar
	
	//Buttons
	private ButtonPlane btnPlane;
	
	public Toolbar()
	{
		this.pnlToolbar = new PanelToolbar();
		
		this.btnPlane = new ButtonPlane(35, "");
	}
	
	public void draw()
	{
		pnlToolbar.draw();
		
		btnPlane.draw(20, Main.WINDOW_HEIGHT-64, 35, 35);
	}
}
