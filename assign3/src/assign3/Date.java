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
 *  Purpose:  Creates a  date object and calculates days  *
 *  		  passed since January 1st                    *
 *                                                        *
 **********************************************************/

public class Date
{
	private int day;
	private int month;
	private int year;
	
	Date(int d, int m, int y)
	{
		day = d;
		month = m;
		year = y;
	}
	
	public int daysSinceJan1(Date date1)
	{	
		int daysPassed;
		
		daysPassed = date1.monthDays(date1) + date1.getDays();	//adds current day of month to days passed 
		System.out.print("Days Passed: " + daysPassed);
		return daysPassed;
	}
	
	public int getDays()		//gets days
		{return day;}
	
	public int  getMonth()		//gets month
		{return month;}
	
	public int getYear()		//gets year
		{return year;}
	
	public int monthDays(Date date1)
	{
		int dayMonths = 0;
		int m = date1.getMonth()-1;		//used to return days accumulated minus one
		int y = date1.getYear();
		int d = date1.getDays();
		
		if(m == 0) {dayMonths = 0;}
		else if(m == 1) {dayMonths = 31;}
		else if(m == 2) {dayMonths = 59;}
		else if(m == 3) {dayMonths = 90;}
		else if(m == 4) {dayMonths = 120;}
		else if(m == 5) {dayMonths = 151;}
		else if(m == 6) {dayMonths = 181;}
		else if(m == 7) {dayMonths = 212;}
		else if(m == 8) {dayMonths = 243;}
		else if(m == 9) {dayMonths = 273;}
		else if(m == 10) {dayMonths = 304;}
		else if(m == 11) {dayMonths = 334;}
		else {dayMonths = 365;}
		
		if(m >= 2 || (m == 2 || d == 29))		//check if leap day is necessary
		{
			if(y%100 == 0)			//checks if year is century year
			{
				if(y%400 == 0)		//if it is a century year check if it is divisible by 400
					dayMonths++;	//add lead day to total
			}
			else if(m >= 2 && d >= 29 && y%4 == 0)		//else check if year is divisible by 4
				dayMonths++;		//add leap day to total
		}
		return dayMonths;		//returns sum of days to month-1
	}
}
