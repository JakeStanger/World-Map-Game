package gui.components.button.game.toolbar;

import gui.components.button.ButtonImage;
import gui.components.panel.toolbar.PanelBus;
import main.Main;
import util.ResourceManager;

public class ButtonBus extends ButtonImage
{
	
	public ButtonBus()
	{
		super(ResourceManager.BTN_BUS);
	}

	@Override
	protected void click()
	{
		PanelBus pnl = Main.instanceManager.gameInstance.guiEngine.pnlBus;
			
		if(pnl.draw) pnl.draw = false;
		else
		{
			Main.instanceManager.gameInstance.guiEngine.hideAllToolbarPanels(pnl);
			pnl.draw = true;
		}
	}
}
