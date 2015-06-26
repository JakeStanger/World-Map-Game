package gui.components;

import gui.components.button.game.toolbar.ButtonBoat;
import gui.components.button.game.toolbar.ButtonBus;
import gui.components.button.game.toolbar.ButtonPlane;
import gui.components.panel.toolbar.PanelToolbar;
import util.CoordinateManager;

public class Toolbar
{
	private PanelToolbar pnlToolbar; //Master bar
	
	//Buttons
	private ButtonPlane btnPlane;
	private ButtonBoat btnBoat;
	private ButtonBus btnBus;
	
	public Toolbar()
	{
		this.pnlToolbar = new PanelToolbar();
		
		this.btnPlane = new ButtonPlane();
		this.btnBoat = new ButtonBoat();
		this.btnBus = new ButtonBus();
	}
	
	public void draw()
	{
		pnlToolbar.draw();
		
		btnPlane.draw(20, CoordinateManager.MAX_Y-64, 64, 64);
		btnBoat.draw(100, CoordinateManager.MAX_Y-64, 64, 64);
		btnBus.draw(180, CoordinateManager.MAX_Y-64, 64, 64);
	}
}
