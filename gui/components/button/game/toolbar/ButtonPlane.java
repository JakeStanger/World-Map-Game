package gui.components.button.game.toolbar;

import gui.components.button.ButtonImage;
import gui.components.panel.toolbar.PanelPlane;
import main.Main;
import util.ResourceManager;

public class ButtonPlane extends ButtonImage
{	
	public ButtonPlane()
	{
		super(ResourceManager.BTN_PLANE);
	}

	@Override
	protected void click()
	{
		PanelPlane pnlPlane = Main.instanceManager.gameInstance.guiEngine.pnlPlane;
			
		if(pnlPlane.draw) pnlPlane.draw = false;
		else pnlPlane.draw = true;
	}
}