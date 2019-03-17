package inclass3;

/************************************************************
 *                                                          *
 *  CSCI 470/680     In-Class Exercise 3A      Summer 2018  *                       
 *                                                          *
 *  Programmer:  Damler, Lucas				                *   
 *                                                          *
 *  Date Due:    JUL 05 2018				                *                         
 *                                                          *
 ************************************************************/ 

import java.util.Scanner;
import java.text.DecimalFormat;

public class ParkingCharge
{
	public static void main(String [] args)
	{
		Scanner keyScan = new Scanner(System.in);
		Scanner keyScan2 = new Scanner(System.in);
		DecimalFormat aFormat = new DecimalFormat("$##0.00");
		
		int hours,
		    count = 0,
		    customers;
		
		double total;
		
		String answer;
		String [] arg = {};
		
		System.out.print("How many customers? ");		//how many customers to enter
		customers = keyScan.nextInt();
		
		while(count < customers)		//enter values based customer amount
		{
			count ++;
			System.out.printf("Enter hours parked for customer %d: ", count);
			hours = keyScan.nextInt();
			
			total = calculateCharges(hours);		//calculates charge based on hours entered
			
			System.out.printf("Customer %d charge: %s\n", count, aFormat.format(total));
			System.out.println();
		}
		System.out.print("Go again? ");			//decide to go again
		answer = keyScan2.nextLine();
		
		if((answer.toLowerCase()).equals("yes"))		//if yes go to top of program
			main(arg);
		else				//otherwise end program, print message
			System.out.println("Have a nice day!");
	}
	
	public static double calculateCharges(int n)	//calculates charge based on hours passed in
	{
		int hours = n,
			temp;
		double total;
		
		if(hours > 3)
		{
			if(hours >= 24)
				total = 10;
			else
			{
				temp = hours - 3;
				total = (temp*0.50) + 2;
			}
		}
		else
			total = 2;
		
		return total;			//returns charge value
	}
}
