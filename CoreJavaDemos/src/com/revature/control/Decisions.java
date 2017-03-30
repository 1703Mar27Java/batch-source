package com.revature.control;

public class Decisions {

	public static void main(String[] args) {
		// logical operators and comparators: < > <= >= != ==
		// or: || or |
		// and: && or &

		// ternary operator
		int value1 = 1;
		int value2 = 2;
		int result;
		boolean someCondition = true;
		result = someCondition ? value1 : value2;
		System.out.println(result);

		boolean someOtherCondition = false;

		// if-else
		if (someCondition) {
			// do thing
		} else if (someOtherCondition) {
			// do other
		} else {
			// if no other condition is true
		}

		// switch case
		// define a number of possible execution paths,
		// "switching" on a variable (can be integer numeric (primitive or
		// wrapper)
		// char, String, or enum)

		int month = 8;
		String monthString;
		switch (month) {
		case 1:
			monthString = "January";
			break;
		case 2:
			monthString = "February";
			break;
		case 3:
			monthString = "March";
			break;
		case 4:
			monthString = "April";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "June";
			break;
		case 7:
			monthString = "July";
			break;
		case 8:
			monthString = "August";
			break;
		case 9:
			monthString = "September";
			break;
		case 10:
			monthString = "October";
			break;
		case 11:
			monthString = "November";
			break;
		case 12:
			monthString = "December";
			break;
		default:
			monthString = "Invalid month";
			break;
		}
		System.out.println(monthString);

	}

}
