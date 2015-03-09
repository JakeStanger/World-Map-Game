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
	
	public static String START_COUNTRY, START_CITY, END_COUNTRY, END_CITY; //Blank to avoid null pointer exception
	public String[] INTROS = new String[2]; //TODO update this to not have to be manually updated
	
	public int month, day, hour, minute, second;
	
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
	
	//GUI Components TODO Move things into their own classes
	private LabelSlowWrite lblIntro = new LabelSlowWrite(30, 5);
	
	private LabelSlowWrite lblStartCountry = new LabelSlowWrite(50, 5);
	private LabelSlowWrite lblStartCity = new LabelSlowWrite(50, 5);
	
	private LabelSlowWrite lblEndCountry = new LabelSlowWrite(50, 5);
	private LabelSlowWrite lblEndCity = new LabelSlowWrite(50, 5);
	
	private LabelSlowWrite lblClickToStart = new LabelSlowWrite(40, 10);
	
	/**
	 * The map texture
	 */
	private Texture texture;
	
	public Game()
	{
		//Setup country list
		COUNTRIES.put("The United Kingdom", UNITED_KINGDOM); //TODO update countries, cities and intros to be in files
		COUNTRIES.put("France", FRANCE);
		COUNTRIES.put("The USA", USA);
		
		setStartAndDestination(); //Set player start location and destination
		populateIntroList();
		
		String intro = generator.getRandomFromStringArray(INTROS);
		lblIntro.setText(intro);
		
		lblStartCountry.setText("Start country: " + Game.START_COUNTRY);
		lblStartCity.setText("Start city: " + Game.START_CITY);
		
		lblEndCountry.setText("Destination country: " + Game.END_COUNTRY);
		lblEndCity.setText("Destination city: " + Game.END_CITY);
		
		lblClickToStart.setText("Click to start.");
	}
	
	public void draw()
	{
		if(!paused)
		{
			if(drawIntro == true) drawIntro();
			if(drawGame == true) drawGame();
		}
	}
	
	/**
	 * True if the intro screen should be drawn
	 */
	public boolean drawIntro = true;
	/**
	 * Draw the game intro screen TODO move the intro to another class
	 */
	private void drawIntro()
	{
		lblIntro.draw(10, 10, Color.green);
		
		if(lblIntro.hasFinished)
		{
			lblStartCountry.draw(10, 100, Color.green);
			lblStartCity.draw(10, 160, Color.green);
			
			lblEndCountry.draw(10, 220, Color.green);
			lblEndCity.draw(10, 280, Color.green);
		}
		
		//TODO update lblEndCity to new isReady
		if(lblEndCity.hasFinished) lblClickToStart.draw((Main.WINDOW_WIDTH/2)-(lblClickToStart.getText().length()*lblClickToStart.size)/2, Main.WINDOW_HEIGHT - 100, Color.green);
		if(lblClickToStart.hasFinished && Mouse.isButtonDown(0)) //When the player has seen the intro
		{
			drawIntro = false;
			drawGame = true;
		}
	}
	
	/**
	 * True if the main game should be drawn
	 */
	public boolean drawGame = false;
	/**
	 * Draw the main game
	 */
	private void drawGame()
	{
		drawBackground();
	}
	
	/**
	 * Set the player's starting location and destination
	 */
	private void setStartAndDestination()
	{
		List<String>countries = new ArrayList<String>(Game.COUNTRIES.keySet());
		
		//Set start location
		Game.START_COUNTRY = generator.getRandomFromStringList(countries);
		Game.START_CITY = generator.getRandomStringFromArrayWithGivenHashMapKey(Game.START_COUNTRY);
		
		countries.remove(Game.START_COUNTRY); //This is to make sure you always have to go to a different country
		
		//Set destination
		Game.END_COUNTRY = generator.getRandomFromStringList(countries);
		Game.END_CITY = generator.getRandomStringFromArrayWithGivenHashMapKey( Game.END_COUNTRY);
		
		countries.add(Game.START_COUNTRY); //Add the country back in so the game is aware of it again
	}
	
	private void populateIntroList()
	{
		this.INTROS[0] = "Well that was a fun holiday in ".concat(START_CITY).concat(". I can't wait to go back to my house in ".concat(END_CITY).concat(" though."));
		this.INTROS[1] = "This is no good at all! I can't stand ".concat(START_COUNTRY).concat(" any longer. Time to go back to ".concat(END_COUNTRY).concat("."));
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
