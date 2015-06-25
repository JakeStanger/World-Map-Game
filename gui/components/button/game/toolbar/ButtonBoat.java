package gui.components.button.game.toolbar;

import gui.components.button.ButtonImage;
import gui.components.panel.toolbar.PanelBoat;
import main.Main;
import util.ResourceManager;

public class ButtonBoat extends ButtonImage
{
	public ButtonBoat()
	{
		super(ResourceManager.BTN_BOAT);
	}

	@Override
	protected void click()
	{
		PanelBoat pnl = Main.instanceManager.gameInstance.guiEngine.pnlBoat;
			
		if(pnl.draw) pnl.draw = false;
		else
		{
			Main.instanceManager.gameInstance.guiEngine.hideAllToolbarPanels(pnl);
			pnl.draw = true;
		}
	}
}
