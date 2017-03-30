package com.revature.enums;

public class EnumTest {

	Day day;
	
	public EnumTest (Day day){
		this.day = day;
	}
	
	public void tellItLikeItIs(){
		switch(day){
		case MONDAY:
			System.out.println("Worst day ever");
			break;
		case FRIDAY:
			System.out.println("GOTTA GET DOWN ON FRIDAY");
			break;
		case SATURDAY: case SUNDAY:
			System.out.println("studying for my interview on Monday");
			break;
		default:
			System.out.println("still studying");
			break;
		}
	}
	public static void main(String[] args) {
		EnumTest firstDay = new EnumTest(Day.THURSDAY);
		firstDay.tellItLikeItIs();
		EnumTest tomorrow = new EnumTest(Day.FRIDAY);
		tomorrow.tellItLikeItIs();

	}

}

enum OtherEnum {
	//this also works 
}
