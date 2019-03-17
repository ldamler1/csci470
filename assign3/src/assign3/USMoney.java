package assign3;

/**********************************************************
 *                                                        *
 *  CSCI 470/680-E       Assignment 3A        Summer 2018 *
 *                                                        *
 *  Developer(s):  Damler, Lucas                          *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  JUL 03 2018                           *
 *                                                        *
 *  Purpose:  Create, get, and add USMoney objects        *
 *                                                        *
 **********************************************************/


public class USMoney
{	
	private int dollars;
	private int cents;
	
	USMoney(int d, int c)
	{
		int temp;
		dollars = d;
		cents = c;
	
		if(cents > 99)				//Makes cents between 0 and 99. adds extra cents to dollars
		{
			temp = cents/99;
			cents = cents - temp*99;		//removes extra cents
			dollars = dollars + temp;		//adds extra cents to dollars
		}
		System.out.printf("Dollars: %d, Cents: %d\n", dollars, cents);
	}
	
	USMoney plus(USMoney test)
	{
		int tempD,
		    tempC;
		
		tempD = this.dollars + test.getDollars();		//adds dollars of USMoney object caller and called
		tempC = this.cents + test.getCents();			//adds cents of USMoney object caller and called
		
		USMoney newVal = new USMoney(tempD, tempC);
		return newVal;				//returns new values of added USMoney objects
	}
	
	public int getDollars()		//used to get dollars of USMoney
	{
		return dollars;
	}
	
	public int getCents()		//used to get cents of USMoney
	{
		return cents;
	}
}
