package gui.components.panel;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex2d;

/**
 * A GUI panel
 * @author Jake
 *
 */
public class Panel
{
	/**
	 * Draw the panel
	 * @param x the start x
	 * @param y the start y
	 * @param width the panel width
	 * @param height the panel height
	 */
	public void draw(int x, int y, int width, int height, float[] colour)
	{
		glPushMatrix();
			glTranslated(x, y, 0);
			
			glBegin(GL_QUADS);
			glColor4d(colour[0], colour[1], colour[2], colour[3]);
			glVertex2d(0, 0);
			glVertex2d(width, 0);
			glVertex2d(width, height);
			glVertex2d(0, height);
		glEnd();
		glPopMatrix();
	}
}
