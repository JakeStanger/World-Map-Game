package gui.components.label;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import gui.Component;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

/**
 * A simple text label with a transparent background
 * @author Jake
 *
 */
public class Label extends Component
{
	private UnicodeFont font;
	private String text;
	public double size;
	
	public Label(int size, String text) 
	{
		createFont(size, true, false); //Create font to draw with
		this.text = text;
		this.size = size;
	}
	
	public void draw(float x, float y, Color colour)
	{
		drawFont(x, y, this.text, colour);
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
	
	private void drawFont(float x, float y, String text, Color colour)
	{
		glEnable(GL_TEXTURE_2D);
			font.drawString(x, y, text, colour);
		glDisable(GL_TEXTURE_2D);
	}
	
	public int getLength()
	{
		return text.length();
	}
}
