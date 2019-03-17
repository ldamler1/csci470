package assign5;

/**********************************************************
 *                                                        *
 *  CSCI 470/680-E       Assignment 5        Summer 2018  *
 *                                                        *
 *  Developer(s):  Damler, Lucas                          *
 *                                                        *
 *  Section:  1                                           *
 *                                                        *
 *  Due Date/Time:  30 JUL 2018                           *
 *                                                        *
 *  Purpose:  Overrides comparator in sort class          *
 *                                                        *
 **********************************************************/

import java.util.Comparator;

//used to override comparator to sort destinations object array
public class MileageComparator implements Comparator<Destination>
{
	@Override
	public int compare(Destination d1, Destination d2)
	{
		return (d2.getNormalMiles() - d1.getNormalMiles());
	}
}
