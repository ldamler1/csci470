package assign3;

/**********************************************************
 *                                                        *
 *  CSCI 470/680-E       Assignment 3A        Summer 2018 *
 *                                                        *
 *  Developer(s):  Damler, Lucas                          *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  JUL 03 2018							  *
 *                                                        *
 *  Purpose:  Demos use of the USMoney class              *
 *                                                        *
 **********************************************************/


import java.util.Scanner;

public class USMoneyDemo
{	
	public static void main(String [] args)
	{
		int dollars,
		    cents;
		
		Scanner keyScan = new Scanner(System.in);
		
		System.out.print("Enter dollars for money1: ");		//enter dollars for first money object
		dollars = keyScan.nextInt();
		
		System.out.print("Enter cents for money1: ");			//enter cents for first money object
		cents = keyScan.nextInt();
		
		USMoney money1 = new USMoney(dollars, cents);
		
		System.out.print("Enter dollars for money2: ");		//enter dollars for second money object
		dollars = keyScan.nextInt();
		
		System.out.print("Enter cents for money2: ");			//enter cents for second money object
		cents = keyScan.nextInt();
		
		USMoney money2 = new USMoney(dollars, cents);
		
		System.out.println();
		
		money1.plus(money2);									//adds both money objects
	}
}
