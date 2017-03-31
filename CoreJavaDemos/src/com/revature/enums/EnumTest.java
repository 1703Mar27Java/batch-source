package com.revature.enums;

public class EnumTest 
{
	Day day;
	
	public EnumTest (Day day)
	{
		this.day = day;
	}
	
	public void tellItLikeItIs()
	{
		switch(day)
		{
			case MONDAY: System.out.println("Worst day."); break;
			case FRIDAY: System.out.println("TGIF!"); break;
			case SATURDAY: case SUNDAY: System.out.println("Studying..."); break;
			case TUESDAY: break;
			case WEDNESDAY: break;
			case THURSDAY: break;
			default: break;
		}
	}
	
	public static void main(String[] args)
	{
		EnumTest firstDay = new EnumTest(Day.THURSDAY);
		firstDay.tellItLikeItIs();
		EnumTest tomorrow = new EnumTest(Day.FRIDAY);
		tomorrow.tellItLikeItIs();
	}
}
