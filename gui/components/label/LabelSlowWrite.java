package gui.components.label;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

import util.Main;

/**
 * A text label which writes to the screen at a controlled speed
 * @author Jake
 *
 */
public class LabelSlowWrite
{	
	/**
	 * The font
	 */
	private UnicodeFont font;
	/**
	 * The text to draw.
	 * Is a char[] for easy of slow-writing
	 */
	private char[] text;
	/**
	 * Used in slow-writing
	 */
	private int framesRemaining, frameGap, framesUntilDrawing, framesToDraw;
	/**
	 * The text size
	 */
	public int size;
	
	/**
	 * True if the label has written all the text
	 */
	public boolean hasFinished = false;
	
	/**
	 * Create a slow-writing label.
	 * You must use setText to display anything.
	 * @param size the text size
	 * @param frameGap the amount of frames to wait before writing the next character
	 */
	public LabelSlowWrite(int size, int frameGap)
	{
		createFont(size, false, false);
		this.size = size;
		this.text = "".toCharArray();
		this.frameGap = frameGap;
		this.framesRemaining = this.text.length*frameGap;
		this.framesToDraw = 0;
		this.framesUntilDrawing = frameGap;
	}
	
	/**
	 * Draw the slow-writing label
	 * @param x start x position
	 * @param y start y position
	 * @param colour the text colour
	 */
	public void draw(int x, int y, Color colour)
	{
		if(this.framesRemaining > 0)
		{
			drawFont(x, y, colour);
			this.framesUntilDrawing--;
		}
		if (this.framesUntilDrawing == 0)
		{
			this.framesUntilDrawing = this.frameGap;
			this.framesToDraw++;
		}
	}
	
	/**
	 * Actually draw the label text
	 * @param x start x position
	 * @param y start y position
	 * @param colour the text colour
	 */
	private void drawFont(int x, int y, Color colour)
	{
		glEnable(GL_TEXTURE_2D);
			int count = 0;
			for(int i = 0; i < framesToDraw; i++)
			{
				if(i < text.length) //Check we're still within bounds
				{
					int cursorPosX = x+(i*this.size);
					
					//Text wrapping
					if(cursorPosX >= Main.WINDOW_WIDTH - 100 && String.valueOf(text[i]) != " ")
						{
							if(count == 0)y += (this.size*1.2);
							cursorPosX = x+count;
							count += this.size;
						}
					
					font.drawString(cursorPosX, y, String.valueOf(text[i]), colour); //All is good, draw
				}
				else this.hasFinished = true;
			}
		glDisable(GL_TEXTURE_2D);
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
	
	/**
	 * Set the text to draw
	 * @param text the text
	 */
	public void setText(String text)
	{
		this.text = text.toCharArray();
		this.framesRemaining = this.text.length*frameGap; //Update how many frames are left before the end of the string
	}
	public String getText()
	{
		return String.copyValueOf(this.text);
	}
}
