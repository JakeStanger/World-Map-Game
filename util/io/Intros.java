package util.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Handles reading and writing intro screen list on disk and in memory
 * @author Jake
 *
 */
public class Intros
{
	private String FILE_NAME = "intros.dat";
	private ArrayList<String> intros;
	
	public Intros()
	{
		this.intros = new ArrayList<String>();
		this.loadIntros();
	}
	
	private void loadIntros()
	{
		try
		{
			File f = new File(FILE_NAME);
			if(f.exists() && !f.isDirectory()) //Check we're not reading a directory
			{
				//Open a new file reader
				FileReader fr = new FileReader(FILE_NAME);	
				BufferedReader br = new BufferedReader(fr);
				String line = br.readLine();
				
				while(line != null)
				{
					intros.add(line);
					line = br.readLine(); //Read the next line
				}
				br.close();
			}
			else downloadIntros();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An error has occurred while loading the intro list.", "IO Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void downloadIntros()
	{
		try
		{
			System.out.println("Downloading intro list...");
			
			System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36"); 
			
			URL website = new URL("http://roboguy99.co.uk/downloads/worldMap/intros.dat");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(FILE_NAME);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			loadIntros();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An error has occurred while downloading the country list.", "IO Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getIntros()
	{
		return intros;
	}
}
