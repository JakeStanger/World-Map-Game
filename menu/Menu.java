package menu;

import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import gui.components.button.Button;
import gui.components.button.ButtonLoadGame;
import gui.components.button.ButtonNewGame;
import gui.components.button.ButtonOptions;
import gui.components.button.ButtonQuit;
import gui.components.label.Label;

import java.io.IOException;

import main.Main;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

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
	
	private Texture texture; //Background texture
	
	
	public Menu()
	{
		try //Attempt to load the background texture
		{
			Main.menuTexture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("assets/textures/terrain/Earth_Terrain_1080.jpg"));
			texture = Main.menuTexture; //Update the main texture
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void draw()
	{
		drawBackground(); //Draw the background
		
		//Draw the menu buttons
		Color.white.bind();
		btnNewGame.draw(20, 20, BUTTON_LENGTH, BUTTON_HEIGHT);
		btnLoadGame.draw(20, BUTTON_HEIGHT + 40, BUTTON_LENGTH, BUTTON_HEIGHT);
		btnOptions.draw(20, BUTTON_HEIGHT*2 + 60, BUTTON_LENGTH, BUTTON_HEIGHT);
		btnQuit.draw(20, BUTTON_HEIGHT*3 + 80, BUTTON_LENGTH, BUTTON_HEIGHT);
		
		//Draw other things
		lblVersion.draw(10, Main.WINDOW_HEIGHT - 30, Color.black);
	}
	
	private void drawBackground()
	{
		texture = Main.menuTexture;
		
		glPushMatrix();
			texture.bind();
			Color.white.bind();
			texture.setTextureFilter(GL_LINEAR);
			glBegin(GL_QUADS);
				glTexCoord2f(0,0);
				glVertex2f(0,0);
				glTexCoord2f(1,0);
				glVertex2f(texture.getTextureWidth(),0);
				glTexCoord2f(1,1);
				glVertex2f(texture.getTextureWidth(),texture.getTextureHeight());
				glTexCoord2f(0,1);
				glVertex2f(0,texture.getTextureHeight());	
	        glEnd();
        glPopMatrix();
	}
}
