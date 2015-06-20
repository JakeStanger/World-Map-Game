package game;

import gui.components.label.LabelSlowWrite;
import main.Main;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import util.Generator;

/**
 * Handles the introduction upon starting a new game
 * @author Jake
 *
 */
public class Intro
{
	public boolean draw = false;
	
	private LabelSlowWrite lblIntro = new LabelSlowWrite(30, 5);
	
	private LabelSlowWrite lblStartCountry = new LabelSlowWrite(50, 5);
	private LabelSlowWrite lblStartCity = new LabelSlowWrite(50, 5);
	
	private LabelSlowWrite lblEndCountry = new LabelSlowWrite(50, 5);
	private LabelSlowWrite lblEndCity = new LabelSlowWrite(50, 5);
	
	private LabelSlowWrite lblClickToStart = new LabelSlowWrite(40, 10);
	
	public static String intro;
	
	public Intro(Setup setup, Generator generator)
	{
		intro = intro.replace("$STARTCITY$", Game.START_CITY);
		intro = intro.replace("$STARTCOUNTRTY$", Game.START_COUNTRY);
		intro = intro.replace("$ENDCITY$", Game.END_CITY);
		intro = intro.replace("$ENDCOUNTRY$", Game.END_COUNTRY);
		
		lblIntro.setText(intro);
		System.out.println(lblIntro.getText());
		 
		lblStartCountry.setText("Start country: " + Game.START_COUNTRY);
		lblStartCity.setText("Start city: " + Game.START_CITY);
		
		lblEndCountry.setText("Destination country: " + Game.END_COUNTRY);
		lblEndCity.setText("Destination city: " + Game.END_CITY);
		
		lblClickToStart.setText("Click to start.");
	}
	
	/**
	 * Draw the intro screen
	 */
	public void draw()
	{
		lblIntro.draw(10, 10, Color.green);
		
		if(lblIntro.hasFinished)
		{
			lblStartCountry.draw(10, 100, Color.green);
			lblStartCity.draw(10, 160, Color.green);
			
			lblEndCountry.draw(10, 220, Color.green);
			lblEndCity.draw(10, 280, Color.green);
		}
		
		if(lblEndCity.hasFinished) lblClickToStart.draw((Main.WINDOW_WIDTH/2)-(lblClickToStart.getText().length()*lblClickToStart.size)/2, Main.WINDOW_HEIGHT - 100, Color.green);
		if(lblClickToStart.hasFinished && Mouse.isButtonDown(0)) //When the player has seen the intro and clicked
		{
			this.draw = false;
			
			Main.instanceManager.gameInstance = new Game();
			Main.instanceManager.game = true;
			Main.instanceManager.gameInstance.draw = true;
			
			Main.instanceManager.intro = false;
		}
	}
}
