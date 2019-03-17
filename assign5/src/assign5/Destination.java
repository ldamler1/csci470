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
 *  Purpose:  Used to construct Destination object        *
 *                                                        *
 **********************************************************/

public class Destination
{
	private String place;
	private int normalMiles,
				cheapMiles,
				upgradeMiles,
				startMonth,
				endMonth;
	
	//Default constructor
	public Destination()
	{}
	
	//Alternative constructor
	public Destination(String p, int nM, int cM, int uM, int sM, int eM)
	{
		place = p;
		normalMiles = nM;
		cheapMiles = cM;
		upgradeMiles = uM;
		startMonth = sM;
		endMonth = eM;
	}
	
	//gets place value
	public String getPlace()
		{return place;}
	
	//gets normal miles
	public int getNormalMiles()
		{return normalMiles;}
	
	//gets cheap miles
	public int getCheapMiles()
		{return cheapMiles;}
	
	//gets upgrade miles
	public int getUpgradeMiles()
		{return upgradeMiles;}
	
	//gets start month
	public int getStartMonth()
		{return startMonth;}
	
	//gets end month
	public int getEndMonth()
		{return endMonth;}
}
