package gui.components.panel;

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

public class PanelToolbar
{
	public Texture texture;
	
	public void draw()
	{
		texture = Main.instanceManager.resourceManagerInstance.TOOLBAR;
		
		glPushMatrix();
			if(texture != null) texture.bind();
			Color.white.bind();
			texture.setTextureFilter(GL_LINEAR);
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex2f(0, Main.WINDOW_HEIGHT-texture.getTextureHeight()+5);
				glTexCoord2f(1, 0);
				glVertex2f(texture.getTextureWidth(), Main.WINDOW_HEIGHT-texture.getTextureHeight()+5);
				glTexCoord2f(1, 1);
				glVertex2f(texture.getTextureWidth(), Main.WINDOW_HEIGHT+5);
				glTexCoord2f(0, 1);
				glVertex2f(0, Main.WINDOW_HEIGHT+5);	
	        glEnd();
        glPopMatrix();
	}
}
