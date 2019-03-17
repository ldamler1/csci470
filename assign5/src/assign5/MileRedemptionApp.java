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
 *  Purpose:  Main driver class for app          		  *
 *                                                        *
 **********************************************************/

import java.io.IOException;
import javax.swing.JFrame;

public class MileRedemptionApp
{
	public static void main(String[] args) throws IOException
	{
		//Calls GUI class to create GUI
		MileRedemptionGUI gui = new MileRedemptionGUI(); 
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
}
