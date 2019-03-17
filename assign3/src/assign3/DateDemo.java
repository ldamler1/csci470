package assign3;

/**********************************************************
 *                                                        *
 *  CSCI 470/680-E       Assignment 3B        Summer 2018 *
 *                                                        *
 *  Developer(s):  Damler, Lucas                          *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  JUL 03 2018                           *
 *                                                        *
 *  Purpose:  Tests Date class					          *
 *                                                        *
 **********************************************************/

import java.util.Scanner;

public class DateDemo
{
	public static void main(String [] args)
	{
		int day,
			month,
			year;
		
		Scanner keyScan = new Scanner(System.in);
		
		System.out.print("Enter Days: ");		//enter days
		day = keyScan.nextInt();
		
		System.out.print("\nEnter Month: ");	//enter month
		month = keyScan.nextInt();
		
		System.out.print("\nEnter Year: ");		//enter year
		year = keyScan.nextInt();
		
		Date date1 = new Date(day, month, year);	//creates date object
		
		date1.daysSinceJan1(date1);				//calculates days passed since jan 1
	}
}
