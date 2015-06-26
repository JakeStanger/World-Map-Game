package gui.components.button;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glColor4d;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex2d;
import gui.Component;

import java.awt.Font;
import java.io.InputStream;

import main.Main;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

/**
 * A clickable menu button
 * @author Jake
 *
 */
public abstract class Button extends Component //TODO Fix strange render issues with new game and options back buttons
{
	private UnicodeFont font;
	private String text;
	/**
	 * True if user just clicked. Used to stop button spamming on toggle buttons.
	 */
	protected static boolean clicked;
	
	/**
	 * Create a new button
	 * @param height the text size
	 * @param text the text to display
	 */
	public Button(int height, String text)
	{
		createFont(height, true, false); //Create font to draw with
		this.text = text;
	}
	
	/**
	 * Render the button
	 * @param x start x position
	 * @param y start y position
	 * @param width the button width
	 * @param height the button height
	 */
	public void draw(double x, double y, double width, double height)
	{	
		Color.white.bind();
		glPushMatrix();
			glTranslated(x, y, 0);
			
			//Get mouse coordinates
			int mouseX = Mouse.getX();
			int mouseY = Main.WINDOW_HEIGHT-Mouse.getY(); //Compensates for mouse being calculated from bottom up
			
			//Check for mouse status and call correct draw method accordingly
			if((mouseX > x && mouseX < x + width) && (mouseY > y && mouseY < y + height))
			{
				if(Mouse.isButtonDown(0) && !clicked) //If the button has been clicked
				{
					drawClick(width, height); //This will very rarely, if at all, be seen.
					click(); //Actual click event
					clicked = true;
				}
				else drawHover(width, height); //When the mouse is within the button area
			}
			else drawNormal(width, height); //When the mouse is not within the button area
			
			if(!Mouse.isButtonDown(0)) clicked = false; //Only reset clicked once the mouse button is released
			
			drawFont(0, 0, this.text, Color.white); //Draw the button text
			
			//System.out.println(x + ", " + y);
		glPopMatrix();
	}
	
	/**
	 * Draw the button when nothing is happening to it
	 * @param x start x position
	 * @param y start y position
	 * @param width the width of the button
	 * @param height the height of the button
	 */
	protected void drawNormal(double width, double height)
	{
		glBegin(GL_QUADS);
			glColor4d(0.6, 0.6, 0.6, 0.8);
			glVertex2d(0, 0);
			glVertex2d(width, 0);
			glVertex2d(width, height);
			glVertex2d(0, height);
		glEnd();
	}
	
	/**
	 * Draw the button when the mouse is hovering over it
	 * @param x start x position
	 * @param y start y position
	 * @param width the width of the button
	 * @param height the height of the button
	 */
	protected void drawHover(double width, double height)
	{
		glBegin(GL_QUADS);
			glColor3d(0.7, 0.7, 0.7);
			glVertex2d(0, 0);
			glVertex2d(width, 0);
			glVertex2d(width, height);
			glVertex2d(0, height);
		glEnd();
	}
	
	/**
	 * Draw the button when the mouse is hovering over it and held down
	 * @param x start x position
	 * @param y start y position
	 * @param width the width of the button
	 * @param height the height of the button
	 */
	protected void drawClick(double width, double height)
	{
		glBegin(GL_QUADS);
			glColor3d(0.75, 0.75, 0.75);
			glVertex2d(0, 0);
			glVertex2d(width, 0);
			glVertex2d(width, height);
			glVertex2d(0, height);
		glEnd();
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
	 * Draws the pre-setup font
	 * @param x x-offset inside the button
	 * @param y y-offset inside the button
	 * @param text the text to render
	 * @param colour the text's colour
	 */
	private void drawFont(int x, int y, String text, Color colour)
	{
		glEnable(GL_TEXTURE_2D);
			font.drawString(x, y, text, colour);
		glDisable(GL_TEXTURE_2D);
	}
	
	protected abstract void click();
}
