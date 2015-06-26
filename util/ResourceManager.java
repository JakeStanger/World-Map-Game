package util;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class ResourceManager
{
	public static Texture TERRAIN_MAP;
	public static Texture WHITE_MAP;
	
	public static Texture TOOLBAR;
	public static Texture PANEL;
	
	public static Texture BTN_PLANE;
	public static Texture BTN_BOAT;
	public static Texture BTN_BUS;
	
	public ResourceManager()
	{
		try
		{
			GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
			GL11.glPixelStorei(GL11.GL_PACK_ALIGNMENT, 1);
			
			TERRAIN_MAP = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("assets/textures/terrain/Earth_Terrain_1080.jpg"));
			WHITE_MAP = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/textures/white/Earth_White_1080.png"));
			
			TOOLBAR = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/textures/gui/Toolbar.png"));
			PANEL = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/textures/gui/Panel.png"));
			
			BTN_PLANE = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/textures/gui/buttons/Plane.png"));
			BTN_BOAT = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/textures/gui/buttons/Ship.png"));
			BTN_BUS = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/textures/gui/buttons/Bus.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
