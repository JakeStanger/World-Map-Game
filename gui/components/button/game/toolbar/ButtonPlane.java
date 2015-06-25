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
		PanelPlane pnl = Main.instanceManager.gameInstance.guiEngine.pnlPlane;
			
		if(pnl.draw) pnl.draw = false;
		else
		{
			Main.instanceManager.gameInstance.guiEngine.hideAllToolbarPanels(pnl);
			pnl.draw = true;
		}
	}
}