import javax.swing.JApplet;
import javax.swing.JTabbedPane;
public class DoctorHomePage extends JApplet {
	private int APPLET_WIDTH = 1000, APPLET_HEIGHT = 500;
	DoctorHomePanel homepanel;
	SetThresholdPanel setthreshold;
	CheckPendingPanel checkpending;
	CheckCompletedPanel completed;
	private JTabbedPane hPane;

	
	public void init() {
		hPane = new JTabbedPane();	//Created the Tabbed Pane
		homepanel = new DoctorHomePanel();	//create HomePanel
		setthreshold = new SetThresholdPanel();	//create SetThreshold
		checkpending = new CheckPendingPanel();
		completed = new CheckCompletedPanel();
	
		// add components to JTabbed Pane
		hPane.addTab("Home Page", homepanel);
		hPane.addTab("Set Threshold", setthreshold);
		hPane.addTab("Pending", checkpending);
		hPane.addTab("Completed History", completed);
		getContentPane().add(hPane);
		setSize (APPLET_WIDTH, APPLET_HEIGHT);
		
	}

}
