package menu;

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

/**
 * Handles keeping the background loaded where necessary
 * Reduces loading times
 * @author Jake
 *
 */
public class Background
{
	public Texture texture;
	public boolean draw = false;
	
	public void draw()
	{
		texture = Main.menuTexture;
		
		glPushMatrix();
			if(texture != null) texture.bind();
			Color.white.bind();
			texture.setTextureFilter(GL_LINEAR);
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex2f(0, 0);
				glTexCoord2f(1, 0);
				glVertex2f(texture.getTextureWidth(), 0);
				glTexCoord2f(1, 1);
				glVertex2f(texture.getTextureWidth(), texture.getTextureHeight());
				glTexCoord2f(0, 1);
				glVertex2f(0, texture.getTextureHeight());	
	        glEnd();
        glPopMatrix();
	}
}
