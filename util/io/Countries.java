package util.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "IO Error", "An error has occurred while loading the country list.", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public HashMap<String, String[]> getCountries()
	{
		return countries;
	}
}
