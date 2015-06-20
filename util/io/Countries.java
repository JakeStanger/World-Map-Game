package util.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Handles reading countries list from the disk
 * @author Jake
 *
 */
public class Countries
{
	private String FILE_NAME = "countries.dat";
	private HashMap<String, String[]> countries;
	
	public Countries()
	{
		this.countries = new HashMap<String, String[]>();
		this.loadCountries();
	}
	
	private void loadCountries()
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
					String[] lineParts = line.split("=");
					String countryName = lineParts[0];
					
					String[] countryCities = lineParts[1].split(", ");
					
					countries.put(countryName, countryCities);
					line = br.readLine(); //Read the next line
				}
				br.close();
			}
			else downloadCountries();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An error has occurred while loading the country list.", "IO Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void downloadCountries()
	{
		try
		{
			System.out.println("Downloading country list...");
			
			System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36"); 
			
			URL website = new URL("http://roboguy99.co.uk/downloads/worldMap/countries.dat");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(FILE_NAME);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			loadCountries();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "An error has occurred while downloading the country list.", "IO Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public HashMap<String, String[]> getCountries()
	{
		return countries;
	}
}
