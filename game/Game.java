package game;

import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import main.Main;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import util.Generator;
import util.InstanceManager;


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
	private InstanceManager instanceManager = Main.instanceManager;
	
	public static String START_COUNTRY, START_CITY, END_COUNTRY, END_CITY; //Blank to avoid null pointer exception
	
	/**
	 * The map texture
	 */
	private Texture texture;
	
	public Game()
	{
		this.clock = new Clock(generator);
	}
	
	public void tick()
	{
		clock.updateClock();
		
		if(!paused)
		{
			if(instanceManager.introInstance.drawIntro == true) instanceManager.introInstance.drawIntro();
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
