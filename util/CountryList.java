package util;

import io.Countries;

import java.util.HashMap;

public class CountryList
{
	//Countries with their cities
	public static final String[] UNITED_KINGDOM = 
	{
		"London",
		"Birmingham",
		"Dover",
		"Manchester",
		"Liverpool",
		"Cardiff"
	};
	public static final String[] FRANCE =
	{
		"Paris",
		"Marseille",
		"Lyon",
		"Lille",
	};
	public static final String[] USA = 
	{
		"New York City",
		"Washington DC",
		"San Francisco",
		"Chicago",
		"Los Angeles"
	};
	
	public static HashMap<String, String[]> COUNTRIES = new HashMap<String, String[]>();
	
	public CountryList()
	{
		new Countries();
		
		//Setup country list
		COUNTRIES.put("The United Kingdom", UNITED_KINGDOM); //TODO update countries, cities and intros to be in files
		COUNTRIES.put("France", FRANCE);
		COUNTRIES.put("The USA", USA);
	}
}
