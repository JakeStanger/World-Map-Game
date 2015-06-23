package gui.components;

import gui.components.button.game.toolbar.ButtonBoat;
import gui.components.button.game.toolbar.ButtonPlane;
import gui.components.panel.toolbar.PanelToolbar;
import main.Main;

public class Toolbar
{
	private PanelToolbar pnlToolbar; //Master bar
	
	//Buttons
	private ButtonPlane btnPlane;
	private ButtonBoat btnBoat;
	
	public Toolbar()
	{
		this.pnlToolbar = new PanelToolbar();
		
		this.btnPlane = new ButtonPlane();
		this.btnBoat = new ButtonBoat();
	}
	
	public void draw()
	{
		pnlToolbar.draw();
		
		btnPlane.draw(20, Main.WINDOW_HEIGHT-50, 35, 35);
		btnBoat.draw(100, Main.WINDOW_HEIGHT-50, 35, 35);
	}
}
