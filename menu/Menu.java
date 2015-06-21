package menu;

import gui.components.button.Button;
import gui.components.button.ButtonLoadGame;
import gui.components.button.ButtonNewGame;
import gui.components.button.ButtonOptions;
import gui.components.button.ButtonQuit;
import gui.components.label.Label;
import main.Main;

import org.newdawn.slick.Color;

import util.Metadata;


/**
 * The main menu
 * @author Jake
 *
 */
public class Menu 
{
	/**
	 * Determines the height of all buttons on the main menu and their font sizes
	 */
	private static final int BUTTON_HEIGHT = 50;
	/**
	 * Determines the length of all buttons on the main menu
	 */
	private static final int BUTTON_LENGTH = 350;
	
	/**
	 * True if the main menu should be drawn
	 */
	public boolean draw = true; //Used to decide whether or not to draw the menu
	
	//Create buttons
	private Button btnNewGame = new ButtonNewGame(BUTTON_HEIGHT, "New Game");
	private Button btnLoadGame = new ButtonLoadGame(BUTTON_HEIGHT, "Load Game");
	private Button btnOptions = new ButtonOptions(BUTTON_HEIGHT, "Options");
	private Button btnQuit = new ButtonQuit(BUTTON_HEIGHT, "Exit Game");
	
	//Create other things
	private Label lblVersion = new Label(20, Metadata.VERSION);
	
	
	public Menu()
	{
		Main.menuTexture = Main.instanceManager.resourceManager.TERRAIN_MAP;
	}
	
	public void draw()
	{	
		//Draw the menu buttons
		Color.white.bind();
		btnNewGame.draw(20, 20, BUTTON_LENGTH, BUTTON_HEIGHT);
		btnLoadGame.draw(20, BUTTON_HEIGHT + 40, BUTTON_LENGTH, BUTTON_HEIGHT);
		btnOptions.draw(20, BUTTON_HEIGHT*2 + 60, BUTTON_LENGTH, BUTTON_HEIGHT);
		btnQuit.draw(20, BUTTON_HEIGHT*3 + 80, BUTTON_LENGTH, BUTTON_HEIGHT);
		
		//Draw other things
		lblVersion.draw(10, Main.WINDOW_HEIGHT - 30, Color.black);
	}
}
