package util;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

/**
 * Initial setup for the program. 
 * NOTE: this creates the window and sets up openGL. It is not the game setup.
 * @author 11jstanger
 *
 */
public class Main 
{
	public static InstanceManager instanceManager;
	public static GameLoop gameLoop;
	
	public static int WINDOW_HEIGHT, WINDOW_WIDTH;
	
	public static Texture menuTexture;
	
	public Main() throws Exception
	{
		//Create the display window
		Display.setDisplayMode(Display.getDesktopDisplayMode());
		Display.setFullscreen(true);
		Display.setTitle("World Map Game");
		Display.create();
		
		//Get screen size
		Main.WINDOW_HEIGHT = Display.getHeight();
		Main.WINDOW_WIDTH = Display.getWidth();
		
		Main.instanceManager = new InstanceManager();
		Main.gameLoop = new GameLoop();
		
		//Close the program
		Display.destroy();
		System.exit(0);
	}
}
