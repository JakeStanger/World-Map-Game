package game;

import util.Generator;
import gui.components.label.LabelTime;

/**
 * Handles the in-game clock
 */
public class Clock //TODO Fix occasional dates
{
	public String month;
	public int day, hour, minute, second;
	private int ticks = 0;
	public int tickRate = 60;

	private LabelTime lblTime = new LabelTime();

	public Clock(Generator generator)
	{
		this.month = generator.generateRandomMonth();
		this.day = generator.generateRandomDayInMonth(month);
		this.hour = generator.generateRandomHour();
		this.minute = generator.generateRandomMinuteOrSecond();
		this.second = generator.generateRandomMinuteOrSecond();
	}
	
	/**
	 * Update the clock by 1 second
	 */
	public void updateClock()
	{
		if(this.ticks == 0) //Only update once per second
		{
			this.second++;
			
			//Update minute
			if(this.second == 60) 
			{
				this.second = 0;
				this.minute++;
			}
			//Update hour
			if(this.minute == 60) 
			{
				this.minute = 0;
				this.hour++;
			}
			//Update day
			if(this.hour == 24)
			{
				this.hour = 0;
				this.day++;
			}
			//Update month
			if(this.day == this.getDaysInMonth(this.month)) 
			{
				this.day = 0;
				this.month = this.getNextMonth(this.month);
			}
			this.ticks = this.tickRate;
		}
		//Count down 1 less frame until second update
		this.ticks--;
	}
	
	/**
	 * Draw the clock.
	 */
	public void drawClock()
	{
		this.lblTime.draw(month, day, hour, minute, second);
	}
	
	/**
	 * Get the amount of days in a month
	 * @param month the month
	 * @return the amount of days in the month
	 */
	private int getDaysInMonth(String month)
	{
		int days = 0;
		
		//Set days to 1 less than the correct amount because the random generator includes 0
		if (month == "January" || month == "March" || month == "May"|| month == "July" || month == "August" || month == "October"|| month == "December") days = 31;
		else if (month == "February") days = 28;
		else days = 30;
		
		return days; //Add 1 to compensate for 0
	}
	
	/**
	 * Get the month after the specified month
	 * @param month a month
	 * @return the next month
	 */
	private String getNextMonth(String month)
	{
		String nextMonth = "";
		
		switch (nextMonth)
		{
			case "January":
				month = "February";
			case "February":
				month = "March";
			case "March":
				month = "April";
			case "April":
				month = "May";
			case "May":
				month = "June";
			case "June":
				month = "July";
			case "July":
				month = "August";
			case "August":
				month = "September";
			case "September":
				month = "October";
			case "October":
				month = "November";
			case "November":
				month = "December";
			case "December":
				month = "January";
		}
		
		return nextMonth;
	}
}
