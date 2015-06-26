package menu.options;

import gui.components.button.Button;
import gui.components.button.ButtonQuit;
import gui.components.button.options.ButtonTerrainMap;
import gui.components.button.options.ButtonWhiteMap;
import gui.components.button.options.game.ButtonQuitToMenu;
import gui.components.button.options.menu.ButtonMenuReturn;
import gui.components.label.Label;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import util.CoordinateManager;


public class Options 
{
	/**
	 * Determines the height of all buttons on the main menu and their font sizes
	 */
	private static final int BUTTON_HEIGHT = 50;
	/**
	 * Determines the length of all buttons on the main menu
	 */
	private static final int BUTTON_LENGTH = 600;
	
	/**
	 * True if the options screen should be drawn
	 */
	public boolean draw = false;
	
	private Button btnTerrain = new ButtonTerrainMap(BUTTON_HEIGHT, "Use Terrain Map");
	private Button btnWhite = new ButtonWhiteMap(BUTTON_HEIGHT, "Use White Map");
	private Button btnBack = new ButtonMenuReturn(BUTTON_HEIGHT, "Back");
	
	private Button btnQuitToMenu = new ButtonQuitToMenu(BUTTON_HEIGHT, "Quit to main menu");
	private Button btnQuit = new ButtonQuit(BUTTON_HEIGHT, "Quit to desktop");
	
	private Label lblPaused = new Label(30, "Paused");
	
	/**
	 * Draw the options screen
	 * @param inGame whether or not the game is loaded
	 */
	public void draw(boolean inGame)
	{	
		Color.white.bind();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		//Draw in-game or in-menu specific things
		if (inGame) drawInGame();
		else drawMenu();
		
		btnTerrain.draw(20, 20, BUTTON_LENGTH, BUTTON_HEIGHT);
		btnWhite.draw(20, BUTTON_HEIGHT + 40, BUTTON_LENGTH, BUTTON_HEIGHT);
	}
	
	/**
	 * Draw main menu specific options content.
	 */
	private void drawMenu()
	{
		btnBack.draw(20, BUTTON_HEIGHT*2 + 60, BUTTON_LENGTH, BUTTON_HEIGHT);
	}
	
	/**
	 * Draw in-game specific options content
	 */
	private void drawInGame()
	{
		//Draw the black background overlay
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor4f(0, 0, 0, 0.7F);
			GL11.glVertex2f(0,0);
		    GL11.glVertex2f(CoordinateManager.MAX_X,0);
		    GL11.glVertex2f(CoordinateManager.MAX_X,CoordinateManager.MAX_Y);
		    GL11.glVertex2f(0,CoordinateManager.MAX_Y);
	    GL11.glEnd();
	
	    Color.white.bind(); //Reset colour settings (may not be needed)
	    lblPaused.draw((CoordinateManager.MAX_X-lblPaused.getLength()*lblPaused.size)-10, CoordinateManager.MAX_Y-50, Color.white);
	    
	    btnQuitToMenu.draw(20, CoordinateManager.MAX_Y-(BUTTON_HEIGHT*2)-70, BUTTON_LENGTH, BUTTON_HEIGHT);
	    btnQuit.draw(20, CoordinateManager.MAX_Y-(BUTTON_HEIGHT)-50, BUTTON_LENGTH, BUTTON_HEIGHT);
	    
	}
}
