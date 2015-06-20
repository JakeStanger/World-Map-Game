package menu.options;

import gui.components.button.Button;
import gui.components.button.options.ButtonMenuReturn;
import gui.components.button.options.ButtonTerrainMap;
import gui.components.button.options.ButtonWhiteMap;
import gui.components.label.Label;
import main.Main;

import org.newdawn.slick.Color;


public class Options 
{
	/**
	 * Determines the height of all buttons on the main menu and their font sizes
	 */
	private static final int BUTTON_HEIGHT = 50;
	/**
	 * Determines the length of all buttons on the main menu
	 */
	private static final int BUTTON_LENGTH = 545;
	
	/**
	 * True if the options screen should be drawn
	 */
	public boolean draw = false;
	
	private Button btnTerrain = new ButtonTerrainMap(BUTTON_HEIGHT, "Use Terrain Map");
	private Button btnWhite = new ButtonWhiteMap(BUTTON_HEIGHT, "Use White Map");
	private Button btnBack = new ButtonMenuReturn(BUTTON_HEIGHT, "Back");
	
	private Label lblPaused = new Label(30, "Paused");
	
	public Options()
	{
		//Constructor code goes here
	}
	
	public void draw(boolean inGame)
	{	
		Color.white.bind();
		
		btnTerrain.draw(20, 20, BUTTON_LENGTH, BUTTON_HEIGHT);
		btnWhite.draw(20, BUTTON_HEIGHT + 40, BUTTON_LENGTH, BUTTON_HEIGHT);
		if (!inGame) btnBack.draw(20, BUTTON_HEIGHT*2 + 60, BUTTON_LENGTH, BUTTON_HEIGHT);
		else lblPaused.draw(Main.WINDOW_WIDTH-lblPaused.getLength()*lblPaused.size-20, Main.WINDOW_HEIGHT-50, Color.darkGray);
	}
}
