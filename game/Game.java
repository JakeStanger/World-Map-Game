package game;

import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import gui.components.label.LabelSlowWrite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import launch.Main;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import util.Generator;


public class Game 
{	
	/**
	 * True if the game should be drawn
	 */
	public boolean draw = false;
	/**
	 * True if the game is paused
	 */
	public boolean paused = false;
	private Generator generator = new Generator();
	private Clock clock;
	
	public static String START_COUNTRY, START_CITY, END_COUNTRY, END_CITY; //Blank to avoid null pointer exception
	
	//Countries with their cities
	public static final String[] UNITED_KINGDOM = 
	{
		"London",
		"Birmingham",
		"Dover",
		"Manchester",
		"Liverpool",
		"Cardiff"
	};
	public static final String[] FRANCE =
	{
		"Paris",
		"Marseille",
		"Lyon",
		"Lille",
	};
	public static final String[] USA = 
	{
		"New York City",
		"Washington DC",
		"San Francisco",
		"Chicago",
		"Los Angeles"
	};
	
	public static HashMap<String, String[]> COUNTRIES = new HashMap<String, String[]>();
	
	/**
	 * The map texture
	 */
	private Texture texture;
	
	public Game()
	{
		clock = new Clock(generator);
		
		//Setup country list
		COUNTRIES.put("The United Kingdom", UNITED_KINGDOM); //TODO update countries, cities and intros to be in files
		COUNTRIES.put("France", FRANCE);
		COUNTRIES.put("The USA", USA);
	}
	
	public void tick()
	{
		clock.updateClock();
		
		if(!paused)
		{
			if(intro.drawIntro == true) intro.drawIntro();
			if(drawGame == true) drawGame();
		}
	}
	
	/**
	 * True if the main game should be drawn
	 */
	public boolean drawGame = false;
	public int minute;
	/**
	 * Draw the main game
	 */
	private void drawGame()
	{
		drawBackground();
		
	}
	
	/**
	 * Draw the background as a static map
	 */
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
