import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.GridLayout;
public class SetThresholdPanel extends JPanel {
	//create components
	private Choice myChoice;
	private JPanel threshold;
	/**
	 * Create the panel.
	 */
	public SetThresholdPanel() {
		this.setLayout(new GridLayout(3,1)); //set layout for contructor
		threshold = new JPanel(); //create JPanel for Choice
		myChoice  = new Choice(); // Create Choice
		//add choices
		myChoice.add("Highest Priority");
		myChoice.add("High Priority");
		myChoice.add("Medium Priority");
		myChoice.add("Low Priority");
		myChoice.add("Lowest Priority");
		
		threshold.add(myChoice); //add to JPanel
		this.add(threshold, BorderLayout.CENTER);//put threshold in center
	}

}
