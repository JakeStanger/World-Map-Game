package gui.components.label;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;

import java.awt.Font;
import java.io.InputStream;

import launch.Main;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

public class LabelTime
{
	private UnicodeFont font;
	
	public LabelTime() 
	{
		createFont(30, true, false); //Create font to draw with
	}
	
	public void draw(String month, int day, int hour, int minute, int second)
	{
		drawFont(month, day, hour, minute, second);
	}
	
	/**
	 * Font setup
	 * @return UnicodeFont for drawing
	 */
	@SuppressWarnings("unchecked")
	private UnicodeFont createFont(int size, boolean isBold, boolean isItalic)
	{
		//Try to load the font from file
		try
		{
	        InputStream inputStream = ResourceLoader.getResourceAsStream("assets/fonts/handwriting_draft.ttf");
	         
	        Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
	        font = new UnicodeFont(awtFont, size, isBold, isItalic);
	             
	    }
		catch (Exception e) 
		{
	        e.printStackTrace();
	    } 
		
		//Load the font effects and set to white as backup
		font.addAsciiGlyphs();
		ColorEffect colour = new ColorEffect();
		colour.setColor(java.awt.Color.white);
		font.getEffects().add(colour);
		try 
		{
		    font.loadGlyphs();
		} 
		catch (SlickException e1)
		{
		    e1.printStackTrace();
		}
		return font;
	}
	
	private void drawFont(String month, int day, int hour, int minute, int second)
	{
		String dayEnd = (day == 1) ? "st" : (day == 2) ? "nd" : (day == 3) ? "rd" : "th";
		
		String minuteStr = (minute < 10) ? "0" + Integer.toString(minute) : Integer.toString(minute);
		String secondStr = (second < 10) ? "0" + Integer.toString(second) : Integer.toString(second);
		
		String text = month + ", " + day + dayEnd + " " + hour + ":" + minuteStr + ":" + secondStr;
		
		glEnable(GL_TEXTURE_2D);
			font.drawString(Main.WINDOW_WIDTH - 450, 10, text, Color.green);
		glDisable(GL_TEXTURE_2D);
	}
}
