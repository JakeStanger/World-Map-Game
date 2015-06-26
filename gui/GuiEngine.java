package gui;

import gui.components.Toolbar;
import gui.components.panel.Panel;
import gui.components.panel.toolbar.PanelBoat;
import gui.components.panel.toolbar.PanelBus;
import gui.components.panel.toolbar.PanelPlane;

import java.util.ArrayList;
import java.util.List;

import main.Main;

public class GuiEngine
{
	private Toolbar toolbar;
	
	public PanelPlane pnlPlane;
	public PanelBoat pnlBoat;
	public PanelBus pnlBus;
	
	private List<Panel> toolbarPanels;
	
	public GuiEngine()
	{
		this.toolbar = new Toolbar();
		
		this.pnlPlane = new PanelPlane();
		this.pnlBoat = new PanelBoat();
		this.pnlBus = new PanelBus();
		
		this.toolbarPanels = new ArrayList<Panel>();
	}
	
	public void draw()
	{
		toolbar.draw();
		
		if(pnlPlane.draw) pnlPlane.draw(20, Main.WINDOW_HEIGHT-64-512);
		if(pnlBoat.draw) pnlBoat.draw(100, Main.WINDOW_HEIGHT-64-512);
		if(pnlBus.draw) pnlBus.draw(180, Main.WINDOW_HEIGHT-64-512);
		
		toolbarPanels.add(pnlPlane);
		toolbarPanels.add(pnlBoat);
		toolbarPanels.add(pnlBus);
	}
	
	/**
	 * Hide all the panels on the toolbar, except the one specified. Used when clicking a toolbar button.
	 * @param except the panel not to hide.
	 */
	public void hideAllToolbarPanels(Panel except)
	{
		Panel[] arrayToolbarPanels = new Panel[toolbarPanels.size()];
		arrayToolbarPanels = toolbarPanels.toArray(arrayToolbarPanels);
		
		for(int i = 0; i < toolbarPanels.size(); i++)
		{
			if(arrayToolbarPanels[i] != except) arrayToolbarPanels[i].draw = false;
		}
	}
}
