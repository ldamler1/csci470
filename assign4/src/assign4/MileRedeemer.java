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
 *  Purpose:  Mile redeemer and calculator class          *
 *                                                        *
 **********************************************************/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class MileRedeemer
{
	private Destination[] places;
	private int remainingMiles = 0;
	
	public void readDestinations(Scanner fileScanner) throws IOException
	{
		String dest,
			   temp,
			   startMonth,
			   endMonth;
		int normalMiles,
			cheapMiles,
			upgradeMiles;

		//ArrayList of destinations
		ArrayList<Destination> destList = new ArrayList<Destination>();
		
		//while there is something in the file continue
		while(fileScanner.hasNext())
		{
			//delimiter to separate fields
			fileScanner.useDelimiter(";|\\n");
			
			//following used to get each field stored in a variable
			dest = fileScanner.next();
			normalMiles = fileScanner.nextInt();
			cheapMiles = fileScanner.nextInt();
			upgradeMiles = fileScanner.nextInt();
			temp = fileScanner.next();
			temp = temp.trim();	
			
			//Splits last field into 2 strings for start and end month
			String[] tempString = temp.split("-");
			startMonth = tempString[0];
			endMonth = tempString[1];
			
			//adds fields to ArrayList of destination objects
			destList.add(new Destination(dest, normalMiles, cheapMiles, upgradeMiles, Integer.parseInt(startMonth), Integer.parseInt(endMonth)));
		}
		
		//converts destination ArrayList into destination array
		places = (Destination[]) destList.toArray(new Destination[destList.size()]);
	}
	
	public String[] getCityNames()
	{
		//prints city names from places array
		String[] cityArray = new String[places.length];
		for(int i = 0; i < places.length; i++)
		{
			cityArray[i] = places[i].getPlace();
		}
		return cityArray;
	}
	
	public String[] redeemMiles(int miles, int month)
	{
		String[] desc;
		String temp;
		int i = 0;
		StringBuilder tempBuffer = new StringBuilder ("* A trip to  in Economy Class");
		StringBuilder tempBuffer2 = new StringBuilder ("    * Upgrade to First Class Available for  Miles");
		ArrayList<String> trip = new ArrayList<String>();
		
		//sorts places array
		Arrays.sort(places, new MileageComparator());
		//set remaining miles to miles
		remainingMiles = miles;
		
		//while i < length of places continue
		while(i < places.length)
		{
			//Compare cheap miles to remaining miles and start/end month to month
			if(places[i].getCheapMiles() <= remainingMiles && (places[i].getStartMonth() <= month && places[i].getEndMonth() >= month))
			{
				//if true subtract from remaining miles
				remainingMiles = remainingMiles - places[i].getCheapMiles();
				tempBuffer.insert(12, places[i].getPlace());
				temp = tempBuffer.toString();
				//adds destination string to string ArrayList 
				trip.add(temp);
				//checks if upgrade available
				if(places[i].getUpgradeMiles() <= remainingMiles)
				{
					//adds upgrade to trip ArrayList
					tempBuffer2.insert(43, places[i].getUpgradeMiles());
					temp = tempBuffer2.toString();
					trip.add(temp);
				}
				//resets string builder
				tempBuffer2.setLength(0);
				tempBuffer2.replace(0, 49, "    * Upgrade to First Class Available for  Miles");
			}
			//compare miles and month to remaining miles and entered month
			else if(places[i].getNormalMiles() <= remainingMiles && !(places[i].getStartMonth() <= month && places[i].getEndMonth() >= month))
			{
				//if true subtract from remaining miles
				remainingMiles = remainingMiles - places[i].getNormalMiles();
				tempBuffer.insert(12, places[i].getPlace());
				temp = tempBuffer.toString();
				trip.add(temp);
				if(places[i].getUpgradeMiles() <= remainingMiles)
				{
					//adds upgrade to trip ArrayList
					tempBuffer2.insert(43, places[i].getUpgradeMiles());
					temp = tempBuffer2.toString();
					trip.add(temp);
				}
				//resets string builder
				tempBuffer2.setLength(0);
				tempBuffer2.replace(0, 49, "    * Upgrade to First Class Available for  Miles");
			}
			//if miles are too low no flights
			else if(i < 1 && remainingMiles < 5000)
			{
				trip.add("No Flights Available");
				break;
			}
			//resets string builder
			tempBuffer.setLength(0);
			tempBuffer.replace(0, 29, "* A trip to  in Economy Class");
			i++;
		}
		
		//convert ArrayList to String array for returning
		desc = (String[]) trip.toArray(new String[trip.size()]);
		return desc;
	}
	
	//returns remaining miles
	public int getRemainingMiles()
		{return remainingMiles;}
}
