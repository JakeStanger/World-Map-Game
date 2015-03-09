package game;

import gui.components.label.LabelTime;
import load.Generator;

/**
 * Handles the in-game clock
 */
public class Clock
{
	public String month;
	public int day, hour, minute, second;

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
		this.second++;
		
		if(this.second == 60) 
		{
			this.second = 0;
			this.minute++;
		}
		if(this.minute == 60) 
		{
			this.minute = 0;
			this.hour++;
		}
		if(this.hour == 24)
		{
			this.hour = 0;
			this.day++;
		}
		if(this.day == this.getDaysInMonth(this.month)) 
		{
			this.day = 0;
			this.month = this.getNextMonth(this.month);
		}
		
		this.lblTime.draw(month, day, hour, minute, second);
	}
	
	private int getDaysInMonth(String month)
	{
		int days = 0;
		
		//Set days to 1 less than the correct amount because the random generator includes 0
		if (month == "January" || month == "March" || month == "May"|| month == "July" || month == "August" || month == "October"|| month == "December") days = 31;
		else if (month == "February") days = 28;
		else days = 30;
		
		return days; //Add 1 to compensate for 0
	}
	
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
