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
		PanelBoat pnlBoat = Main.instanceManager.gameInstance.guiEngine.pnlBoat;
			
		if(pnlBoat.draw) pnlBoat.draw = false;
		else
		{
			Main.instanceManager.gameInstance.guiEngine.hideAllToolbarPanels(pnlBoat);
			pnlBoat.draw = true;
		}
	}
}
