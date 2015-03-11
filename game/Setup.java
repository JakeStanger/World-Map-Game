package game;

import java.util.ArrayList;
import java.util.List;

import util.Generator;

/**
 * Load and generate game data.
 * Called while showing the intro screen
 * @author Jake
 *
 */
public class Setup
{
	private Generator generator;
	
	public Setup(Generator generator)
	{
		this.generator = generator;
		this.setStartAndDestination();
	}
	
	/**
	 * Set the player's starting location and destination
	 */
	private void setStartAndDestination()
	{
		List<String>countries = new ArrayList<String>(Game.COUNTRIES.keySet());
		
		//Set start location
		Game.START_COUNTRY = generator.getRandomFromStringList(countries);
		Game.START_CITY = generator.getRandomStringFromArrayWithGivenHashMapKey(Game.START_COUNTRY);
		
		countries.remove(Game.START_COUNTRY); //This is to make sure you always have to go to a different country
		
		//Set destination
		Game.END_COUNTRY = generator.getRandomFromStringList(countries);
		Game.END_CITY = generator.getRandomStringFromArrayWithGivenHashMapKey( Game.END_COUNTRY);
		
		countries.add(Game.START_COUNTRY); //Add the country back in so the game is aware of it again
	}
}
