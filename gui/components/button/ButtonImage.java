package gui.components.button;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public abstract class ButtonImage extends Button
{
	private Texture texture;
	
	private Color hover = new Color(0.9f,0.9f,0.9f,1.0f);
	private Color clicked = new Color(0.8f,0.8f,0.8f,1.0f);
	
	public ButtonImage(Texture texture)
	{
		super(0, ""); //Values make no difference, so might as well be nothing
		this.texture = texture;
	}

	@Override
	protected abstract void click();
	
	@Override
	protected void drawNormal(double x, double y, int width, int height)
	{	
		texture.bind();
		Color.white.bind();
		
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
	}
	
	protected void drawHover(double x, double y, int width, int height)
	{
		texture.bind();
		hover.bind();
		
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
	}
	
	protected void drawClick(double x, double y, int width, int height)
	{
		texture.bind();
		clicked.bind();
		
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
	}
}
