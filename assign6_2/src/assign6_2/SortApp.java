package assign6_2;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

import assign6_2.SortPanel.SortAnimationPanel;

public class SortApp extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SortPanel panel1 = new SortPanel();
    SortPanel panel2 = new SortPanel();
	
	public static void main(String[] args)
	{
		SortApp sortly = new SortApp();
		sortly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sortly.setSize(1250,750);
		sortly.setLayout(new GridLayout(1,2));
		//sortly.setLayout(new GridBagLayout());
		sortly.setTitle("Sorting Animation");
		sortly.setVisible(true);
		sortly.setResizable(true);
	}

	public SortApp()
    {
        //Add the sort panels
        this.add(panel1);
        this.add(panel2);
    }
}
