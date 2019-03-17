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
 *  Purpose:  Mile redemption app GUI			          *
 *                                                        *
 **********************************************************/

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MileRedemptionGUI extends JFrame 
{
	/**
	 * 
	 */
	//IDK why this is here. Eclipse wanted it to be so here it will stay
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;		//main frame
	private Destination dest;
	private JPanel placesPanel, redeemPanel;
	private String[] trips;
	private MileRedeemer redeem = new MileRedeemer();
	//GUI constructor class
	public MileRedemptionGUI() throws IOException
	{
		//Get file name from user
		String fileName = JOptionPane.showInputDialog("Enter file name");
		//If file name not found try again
		File text = new File(fileName);
		while(!text.exists())
		{
			JOptionPane.showMessageDialog(null, "File not found");
			fileName = JOptionPane.showInputDialog("Enter file name");
			text = new File(fileName);
		}
		
		Scanner fileScan = new Scanner(text);
		//Pass filename to redeem
		redeem.readDestinations(fileScan);
		
		//Create main frame
		mainFrame = new JFrame("Mile Redemption App");
		mainFrame.setSize(1000, 350);
		mainFrame.setLayout(new GridBagLayout());
		//Set close operation
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create gridbag constraints
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.BOTH;
		
		//Create panel for places JLIST
		placesPanel = new JPanel(new GridBagLayout());
		con.gridx = 0;
		con.gridy = 0;
		con.weightx = .3;
		con.weighty = 1;
		con.gridwidth = 2;
		//Add panel to main frame
		mainFrame.add(placesPanel, con);
		
		//Create panel for redeem miles output
		redeemPanel = new JPanel(new GridBagLayout());
		con.gridx = 2;
		con.gridy = 0;
		con.weightx = .7;
		con.weighty = 1;
		con.gridwidth = 2;
		mainFrame.add(redeemPanel, con);
		
		//JLIST with place names
		String[] places = redeem.getCityNames();
		JList<String> placeList = new JList<String>(places);
		placeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		placeList.setSelectedIndex(0);
		con.gridx = 0;
		con.gridy = 0;
		//Add list to places panel with scroll option
		placesPanel.add(new JScrollPane(placeList), con);
		
		//NORMAL MILES text field
		JTextField nMiles, cMiles, uMiles, dates;
		nMiles = new JTextField("");
		nMiles.setEditable(false);
		con.gridx = 1;
		con.gridy = 2;
		con.gridwidth = 1;
		con.weighty = .01;
		nMiles.setBackground(Color.white);
		//Add normal miles to panel with constraints
		placesPanel.add(nMiles, con);
		
		//Create JLabel for normal miles
		JLabel nMilesLabel = new JLabel("Normal Miles");
		nMilesLabel.setLabelFor(nMiles);
		nMilesLabel.setHorizontalTextPosition(JLabel.LEFT);
		con.gridx = 0;
		con.gridy = 2;
		con.weightx = 0.05;
		//Add normal miles label to panel with constraints
		placesPanel.add(nMilesLabel, con);
		
		//CHEAP MILES text field
		cMiles = new JTextField("");
		cMiles.setEditable(false);
		con.gridx = 1;
		con.gridy = 3;
		cMiles.setBackground(Color.white);
		//Add cheap miles to panel with constraints
		placesPanel.add(cMiles, con);
		
		//Create JLabel for cheap miles
		JLabel cMilesLabel = new JLabel("Supersaver Miles");
		cMilesLabel.setLabelFor(cMiles);
		cMilesLabel.setHorizontalTextPosition(JLabel.LEFT);
		con.gridx = 0;
		con.gridy = 3;
		//Add cheap miles label to panel with constraints
		placesPanel.add(cMilesLabel, con);
		
		//UPGRADE MILES text field
		uMiles = new JTextField("");
		uMiles.setEditable(false);
		con.gridx = 1;
		con.gridy = 4;
		uMiles.setBackground(Color.white);
		//Add upgrade miles to panel with constraints
		placesPanel.add(uMiles, con);
		
		//Create JLabel for upgrade miles
		JLabel uMilesLabel = new JLabel("Upgrade Miles");
		uMilesLabel.setLabelFor(uMiles);
		uMilesLabel.setHorizontalTextPosition(JLabel.LEFT);
		con.gridx = 0;
		con.gridy = 4;
		//Add upgrade miles label to panel with constraints
		placesPanel.add(uMilesLabel, con);
		
		//DATES text field
		dates = new JTextField("");
		dates.setEditable(false);
		con.gridx = 1;
		con.gridy = 5;
		dates.setBackground(Color.white);
		//Add dates to panel with constraints
		placesPanel.add(dates, con);
		
		//Create JLabel for dates
		JLabel datesLabel = new JLabel("Supersaver Dates");
		datesLabel.setLabelFor(dates);
		datesLabel.setHorizontalTextPosition(JLabel.LEFT);
		con.gridx = 0;
		con.gridy = 5;
		//Add dates label to panel with constraints
		placesPanel.add(datesLabel, con);
		
		//String array for month names
		String[] months = getMonthStrings();
		
		//Add listener for JList to set text fields on click
		placeList.addListSelectionListener(
				new ListSelectionListener()
				{
					@Override
					public void valueChanged(ListSelectionEvent e)
					{
						dest = redeem.findDestination(places[placeList.getSelectedIndex()]);
						int t1 = dest.getNormalMiles(); nMiles.setText(String.valueOf(t1));
						int t2 = dest.getCheapMiles(); cMiles.setText(String.valueOf(t2));
						int t3 = dest.getUpgradeMiles(); uMiles.setText(String.valueOf(t3));
						String t4 = months[dest.getStartMonth()-1] + " - " + months[dest.getEndMonth()-1];
						dates.setText(t4);
					}
				});
		//TEXTAREA for redeem miles trips available
		JButton redeemButton = new JButton("Redeem Miles");
		con.gridx = 0;
		con.gridy = 3;
		con.gridwidth = 2;
		con.weighty = .01;
		//Add to redeem panel
		redeemPanel.add(redeemButton, con);
		
		//Set text area constraints
		JTextArea tripTextArea = new JTextArea(10,10);
		tripTextArea.setText("");
		con.gridx = 0;
		con.gridy = 4;
		con.weighty = 1;
		redeemPanel.add(new JScrollPane(tripTextArea), con);
		
		//ENTER MILES text field
		JTextField enterMiles = new JTextField("");
		con.gridx = 1;
		con.gridy = 0;
		con.gridwidth = 1;
		con.weightx = 0.75;
		con.weighty = .01;
		//Add text field to panel
		redeemPanel.add(enterMiles, con);	
		
		//Create label to enter miles text field
		JLabel eMilesLabel = new JLabel("Enter miles");
		eMilesLabel.setLabelFor(dates);
		eMilesLabel.setHorizontalTextPosition(JLabel.LEFT);
		con.gridx = 0;
		con.gridy = 0;
		con.weightx = 0.25;
		//Add label to panel
		redeemPanel.add(eMilesLabel, con);
		
		//ENTER MONTHS spinner
		SpinnerListModel monthList = new SpinnerListModel(months);
		JSpinner monthSpinner = new JSpinner(monthList);
		((DefaultEditor) monthSpinner.getEditor()).getTextField().setEditable(false);
	    monthSpinner.setBackground(Color.white);
		
		con.gridx = 1;
		con.gridy = 1;
		//Add spinner to panel
		redeemPanel.add(monthSpinner, con);
		
		//Create label for month spinner
		JLabel eMonthLabel = new JLabel("Select month of departure");
		eMonthLabel.setLabelFor(monthSpinner);
		eMonthLabel.setHorizontalTextPosition(JLabel.LEFT);
		con.gridx = 0;
		con.gridy = 1;
		//Add label to panel
		redeemPanel.add(eMonthLabel, con);
		
		//REMAINING MILES text field
		JTextField remainingMiles = new JTextField("");
		remainingMiles.setEditable(false);
		con.gridx = 1;
		con.gridy = 5;
		remainingMiles.setBackground(Color.white);
		//Add text field to panel
		redeemPanel.add(remainingMiles, con);
		
		//Create label to for remaining miles
		JLabel rMilesLabel = new JLabel("Remaining miles");
		rMilesLabel.setLabelFor(remainingMiles);
		rMilesLabel.setHorizontalTextPosition(JLabel.LEFT);
		con.gridx = 0;
		con.gridy = 5;
		//Add label to panel
		redeemPanel.add(rMilesLabel, con);
		
		//Listen for button click
		redeemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Reset text area
				tripTextArea.setText("");
				//Get values from text area and spinner
				int textValue = Integer.parseInt(enterMiles.getText());
				int monthValue = getMonthIndex(monthSpinner, months);
				
				//Call redeem miles method and display on text area
				trips = redeem.redeemMiles(textValue, monthValue);
				for(String s : trips)
				{
				tripTextArea.append("\n");
				tripTextArea.append(s);
				}
				remainingMiles.setText(String.valueOf(redeem.getRemainingMiles()));
			}
		});
		
		//Set and color border around places panel
		placesPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),
				"Destinations"));
		placesPanel.setBackground(new Color(50, 150, 75));
		//Set and color border around redeem panel
		redeemPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),
				"Redeem Miles"));
		redeemPanel.setBackground(new Color(125, 125, 175));
		
		//Set main frame to visible
		mainFrame.setVisible(true);
	}
	
	//Class to return string of month names
	protected String[] getMonthStrings() 
	{
		String[] months = new java.text.DateFormatSymbols().getMonths();
	  
		int lastIndex = months.length - 1;
	  
		if (months[lastIndex] == null || months[lastIndex].length() <= 0)  
		{ 
			String[] monthStrings = new String[lastIndex];
			System.arraycopy(months, 0, monthStrings, 0, lastIndex);
			return monthStrings;
		}
		else 
		{
			return months;
		}
	}
	
	//Class for spinner to get index of month
	public int getMonthIndex(JSpinner spinner, String[] array)
	{
		int i = 0;
		for(String s : array)
		{
			if(s.equals(spinner.getValue()))
				return i+1;
		i++;
		}
		return -1;
	}
}
