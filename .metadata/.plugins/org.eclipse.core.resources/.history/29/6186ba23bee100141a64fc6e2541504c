import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DoctorHomePanel extends JPanel {

	//Instance variables used in this panel
	private JLabel mainPA, welcomeLabel;
	private JPanel top, bottom;
	/**
	 * Create the panel.
	 */
	
	public DoctorHomePanel() {
		top = new JPanel();	//create top JPanel
		bottom = new JPanel();//creat bottom Jpanel
		this.setLayout(new GridLayout(2,1));	// Set the Layout to a grid with 2 rows, 1 column
		welcomeLabel = new JLabel("Welcome Doctor");	//Create welcomeLabel, with text in string.
		welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(64.0f)); //make font bigger
		mainPA = new JLabel("Put something interesting here, possibly amount of pedning forms, some sort of status update?");	//Create mainPA, will write polite and informative PA
		top.add(welcomeLabel); //add component welcomeLabel to the top
		bottom.add(mainPA);	//add component mainPA to the bottom		
		
		//add to constructor
		this.add(top, BorderLayout.NORTH); 
		this.add(bottom, BorderLayout.SOUTH);
		setVisible(true);
	}

}
