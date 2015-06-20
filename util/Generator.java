package util;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import util.io.Countries;

/**
 * Class for random generations and returning random values.
 * @author Jake
 *
 */
public class Generator
{
	private Random random;
	private HashMap<String, String[]> countryList;
	
	public Generator()
	{
		this.random = new Random();
		
		Countries countryIO = new Countries();
		this.countryList = countryIO.getCountries();
	}
	
	/**
	 * Get a element from a string list
	 * @param list a string list
	 * @return a random element of the list name
	 */
	public String getRandomFromStringList(List<String> list)
	{
		return list.get(random.nextInt(list.size()));
	}
	
	/**
	 * Get a random element of an array which is a value in a hashmap when given the key
	 * @param key a hashmap key
	 * @return a random element of one of the hashmap values
	 */
	public String getRandomStringFromArrayWithGivenHashMapKey(String key)
	{
		String[] cities = countryList.get(key);
		return cities[random.nextInt(cities.length)];
	}
	
	/**
	 * Returns a string from a string array
	 * @param array the array
	 * @return a random element from the array
	 */
	public String getRandomFromStringArray(String[] array)
	{
		 return array[this.random.nextInt(array.length)];
	}
	
	/**
	 * Generate a random month
	 * @return a random month
	 */
	public String generateRandomMonth()
	{
		int monthInt = random.nextInt(11);
		String month = "";
		
		switch (monthInt)
		{
			case 0:
				month = "January";
			case 1:
				month = "February";
			case 2:
				month = "March";
			case 3:
				month = "April";
			case 4:
				month = "May";
			case 5:
				month = "June";
			case 6:
				month = "July";
			case 7:
				month = "August";
			case 8:
				month = "September";
			case 9:
				month = "October";
			case 11:
				month = "November";
			case 12:
				month = "December";
		}
		
		return month;
	}
	
	/**
	 * Generate a random day in a given month
	 * @param month the month
	 * @return a day in the month
	 */
	public int generateRandomDayInMonth(String month)
	{
		int days = 0;
		
		//Set days to 1 less than the correct amount because the random generator includes 0
		if (month == "January" || month == "March" || month == "May"|| month == "July" || month == "August" || month == "October"|| month == "December") days = 30;
		else if (month == "February") days = 27;
		else days = 29;
		
		return random.nextInt(days)+1; //Add 1 to compensate for 0
	}
	
	/**
	 * Generates a random hour of the day
	 * @return a random number between 0-23
	 */
	public int generateRandomHour()
	{
		return random.nextInt(24);
	}
	
	/**
	 * Generate a random minute of the hour.
	 * Can also be used for seconds, due to the fact they are also base 60
	 * @return a random number between 0-59
	 */
	public int generateRandomMinuteOrSecond()
	{
		return random.nextInt(59);
	}
}
