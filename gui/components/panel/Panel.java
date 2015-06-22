package gui.components.panel;

import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

/**
 * A pop-out panel, normally created on button click
 * @author Jake
 *
 */
public class Panel
{
	private Texture texture;
	public boolean draw;
	
	public Panel(Texture texture)
	{
		this.texture = texture;
	}
	
	/**
	 * Draw the toolbar at the bottom of the screen.
	 */
	public void draw(float x, float y)
	{
		glPushMatrix();
			glTranslatef(x, y, 0);
			
			if(texture != null) texture.bind();
			Color.lightGray.bind();
			texture.setTextureFilter(GL_LINEAR);
			glBegin(GL_QUADS);
			    glTexCoord2f(0, 0);  //top left
			    glVertex2f(0, 0);
	
			    glTexCoord2f(texture.getWidth(),0);    //Top right
			    glVertex2f(texture.getTextureWidth(), 0);
	
			    glTexCoord2f(texture.getWidth(), texture.getHeight()); //Bottom right
			    glVertex2f(texture.getTextureWidth(), texture.getTextureHeight());
	
			    glTexCoord2f(0, texture.getHeight()); //bottom left
			    glVertex2f(0, texture.getTextureHeight());
		    glEnd();
        glPopMatrix();
	}
}
