package menu.options;

import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import gui.components.button.Button;
import gui.components.button.options.ButtonMenuReturn;
import gui.components.button.options.ButtonTerrainMap;
import gui.components.button.options.ButtonWhiteMap;
import gui.components.label.Label;
import launch.Main;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;


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
	
	private Texture texture;
	
	public Options()
	{
		//Constructor code goes here
	}
	
	public void draw(boolean inGame)
	{
		drawBackground();
		
		Color.white.bind();
		
		btnTerrain.draw(20, 20, BUTTON_LENGTH, BUTTON_HEIGHT);
		btnWhite.draw(20, BUTTON_HEIGHT + 40, BUTTON_LENGTH, BUTTON_HEIGHT);
		if (!inGame) btnBack.draw(20, BUTTON_HEIGHT*2 + 60, BUTTON_LENGTH, BUTTON_HEIGHT);
		else lblPaused.draw(Main.WINDOW_WIDTH-lblPaused.getLength()*lblPaused.size-20, Main.WINDOW_HEIGHT-50, Color.darkGray);
	}
	
	private void drawBackground()
	{
		texture = Main.menuTexture;
		
		glPushMatrix();
			if(texture != null) texture.bind();
			Color.white.bind();
			texture.setTextureFilter(GL_LINEAR);
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex2f(0, 0);
				glTexCoord2f(1, 0);
				glVertex2f(texture.getTextureWidth(), 0);
				glTexCoord2f(1, 1);
				glVertex2f(texture.getTextureWidth(), texture.getTextureHeight());
				glTexCoord2f(0, 1);
				glVertex2f(0, texture.getTextureHeight());	
	        glEnd();
        glPopMatrix();
	}
}
