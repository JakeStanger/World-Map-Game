package game;

import java.util.List;
import java.util.Random;

public class Generator
{
	Random random;
	
	public Generator()
	{
		this.random = new Random();
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
		String[] cities = Game.COUNTRIES.get(key);
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
				month = "September";
			case 8:
				month = "October";
			case 9:
				month = "November";
			case 11:
				month = "December";
		}
		
		return month;
	}
}
