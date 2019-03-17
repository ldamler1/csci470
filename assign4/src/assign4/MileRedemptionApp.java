package assign4;

/**********************************************************
 *                                                        *
 *  CSCI 470/680-E       Assignment 4        Summer 2018 *
 *                                                        *
 *  Developer(s):  Damler, Lucas                          *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  16 JUL 2018                           *
 *                                                        *
 *  Purpose:  Main driver class for app          		  *
 *                                                        *
 **********************************************************/

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class MileRedemptionApp
{
	public static void main(String[] args) throws IOException
	{
		String answer = "y",
			   inputFile;
		int miles,
			month;
		
		MileRedeemer test = new MileRedeemer();
		Scanner keyScan = new Scanner(System.in);
		
		System.out.print("Please enter the name of the file:\t");
		inputFile = keyScan.next();
		
		File text = new File(inputFile);
		Scanner fileScan = new Scanner(text);
		
		test.readDestinations(fileScan);
		
		System.out.println("-------------------------------------------------");
		System.out.println("WELCOME TO THE JAVA AIRLINES MILES REDEMPTION APP");
		System.out.println("-------------------------------------------------\n");
		System.out.println("List of destination cities you can travel to:\n");
		
		String[] cities = test.getCityNames();
		for(String s : cities)
		{
		 System.out.println(s);
		}

		System.out.println("\n-------------------------------------------------\n");
		
		while(answer.toLowerCase().equals("y"))
		{
			System.out.print("Please enter your accumulated Frequent Flyer Miles:\t");
			miles = keyScan.nextInt();
			System.out.print("Please enter your month of departure (1-12):\t");
			month = keyScan.nextInt();
			System.out.println();
			
			String[] trips = test.redeemMiles(miles, month);
			for(String s : trips)
			{
			 System.out.println(s);
			}
			
			System.out.println("\nYour remaining Frequent Flyer Miles: " + test.getRemainingMiles());
			System.out.println();
			
			System.out.print("\nDo you want to continue (y/n)? ");
			answer = keyScan.next();
			System.out.println();
		}
		keyScan.close();
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("THANK YOU FOR USING THE JAVA AIRLINES MILES REDEMPTION APP!");
		System.out.println("-----------------------------------------------------------\n");
	}
}
