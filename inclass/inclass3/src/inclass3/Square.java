package inclass3;

/************************************************************
 *                                                          *
 *  CSCI 470/680     In-Class Exercise 3B      Summer 2018  *                       
 *                                                          *
 *  Programmer:  Damler, Lucas				                *   
 *                                                          *
 *  Date Due:    JUL 05 2018				                *                         
 *                                                          *
 ************************************************************/ 

import java.util.Scanner;

public class Square
{
	public static void main(String [] args)
	{
		int n;
		String answer = "yes";
		String [] arg = {};
		
		Scanner keyScan = new Scanner(System.in);
		Scanner keyScan2 = new Scanner(System.in);
		
		System.out.print("Enter side: ");		//get size of square to print
		n = keyScan.nextInt();
		
		squareOfAsterisks(n);			//call method to print square

		System.out.print("Enter 'yes' to go again: ");		//decide to go again
		answer = keyScan2.nextLine();
		
		if((answer.toLowerCase()).equals("yes"))		//if yes go back to beginning of method nad start again
			main(arg);
		else				//end program
			System.out.println("Have a nice day!");
	}
	
	
	public static void squareOfAsterisks(int n)
	{
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print("*");			//prints square of asterisks based on number entered n
			}
			System.out.println();
		}
	}
}
