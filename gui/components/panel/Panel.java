package gui.components.panel;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex2d;
import gui.Component;

import org.newdawn.slick.opengl.Texture;

/**
 * A GUI panel
 * @author Jake
 *
 */
public class Panel extends Component
{
	/**
	 * Draw the panel
	 * @param x the start x
	 * @param y the start y
	 * @param width the panel width
	 * @param height the panel height
	 */
	public void draw(int x, int y, int width, int height, Texture texture)
	{
		glPushMatrix();
			glTranslated(x, y, 0);
			
			glBegin(GL_QUADS);
				glColor4d(1, 1, 1, 1); //Texture fallback
				glVertex2d(0, 0);
				
				glVertex2d(width, 0);
				
				glVertex2d(width, height);
				
				glVertex2d(0, height);
			glEnd();
		glPopMatrix();
	}
}
