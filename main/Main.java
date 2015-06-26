package main;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import util.InstanceManager;

/**
 * Initial setup for the program. 
 * NOTE: this creates the window and sets up openGL. It is not the game setup.
 * Also handles creation of some non-window instances
 * @author 11jstanger
 *
 */
public class Main 
{
	public static InstanceManager instanceManager;
	public static GameLoop gameLoop;
	
	public static int WINDOW_WIDTH, WINDOW_HEIGHT;
	
	//Set virtual resolution for scaling up/down on different resolutions
	public static final int VIRTUAL_WINDOW_WIDTH = 1920;
	public static final int VIRTUAL_WINDOW_HEIGHT = 1080;
	
	public static Texture menuTexture;
	
	public Main() throws Exception
	{
		//Create the display window
		Display.setDisplayMode(Display.getDesktopDisplayMode());
		Display.setFullscreen(false);
		//System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		Display.setTitle("World Map Game");
		Display.setResizable(true);
		Display.create();
		
		//Get screen size
		Main.WINDOW_HEIGHT = Display.getHeight();
		Main.WINDOW_WIDTH = Display.getWidth();
		
		//Create non-window related setup instances
		Main.instanceManager = new InstanceManager();
		Main.gameLoop = new GameLoop(); //End of setup
	}
}
