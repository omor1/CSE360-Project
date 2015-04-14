import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JTextPane;


public class Diagnose_Panel extends JPanel {
	private Form f;
	/**
	 * Create the panel.
	 */
	public Diagnose_Panel() {
		setLayout(null);
		try {
			f = MDGui.db.retrieveNextPatient(MDGui.user);
		} catch (SQLException e1) {
			//e1.printStackTrace();
		}
		if(f == null){
			JLabel lblNausea = new JLabel("Nausea: ");
			lblNausea.setBounds(19, 29, 79, 16);
			add(lblNausea);
		
			JLabel lblPain = new JLabel("Pain:");
			lblPain.setBounds(19, 46, 61, 16);
			add(lblPain);
		
			JLabel lblFatigue = new JLabel("Fatigue:");
			lblFatigue.setBounds(19, 64, 61, 16);
			add(lblFatigue);
			
			JLabel lblAnxiety = new JLabel("Anxiety:");
			lblAnxiety.setBounds(19, 82, 61, 16);
			add(lblAnxiety);
			
			JLabel lblShortnessofbreadth = new JLabel("Shortness of Breadth:");
			lblShortnessofbreadth.setBounds(19, 101, 165, 16);
			add(lblShortnessofbreadth);
			
			JTextPane txtpnHello = new JTextPane();
			txtpnHello.setText("No Patients right now");
			txtpnHello.setBounds(245, 34, 187, 130);
			add(txtpnHello);
		}else{
			JLabel lblNausea = new JLabel("Nausea: " + f.getNausea());
			lblNausea.setBounds(19, 29, 79, 16);
			add(lblNausea);
		
			JLabel lblPain = new JLabel("Pain:" + f.getPain());
			lblPain.setBounds(19, 46, 61, 16);
			add(lblPain);
		
			JLabel lblFatigue = new JLabel("Fatigue:" + f.getFatigue());
			lblFatigue.setBounds(19, 64, 61, 16);
			add(lblFatigue);
			
			JLabel lblAnxiety = new JLabel("Anxiety:" + f.getAnxiety());
			lblAnxiety.setBounds(19, 82, 61, 16);
			add(lblAnxiety);
			
			JLabel lblShortnessofbreadth = new JLabel("Shortness of Breadth:" + f.getShortnessOfBreath());
			lblShortnessofbreadth.setBounds(19, 101, 165, 16);
			add(lblShortnessofbreadth);
			
			JTextPane txtpnHello = new JTextPane();
			txtpnHello.setText("Name: " + f.getPatient() + "\n"
					+ "Comments: " + f.getComments() + "\n"
					+"Priority: " + f.getPriority() + "\n"
					+ "Status: " + f.getStatus() + "\n");
			txtpnHello.setBounds(245, 34, 187, 130);
			add(txtpnHello);
		}
			
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(19, 184, 230, 95);
		add(editorPane);
		
		JLabel lblDiagnosePage = new JLabel("Diagnose Page");
		lblDiagnosePage.setBounds(176, 6, 92, 16);
		add(lblDiagnosePage);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(editorPane.getText() == null){
					JOptionPane.showMessageDialog(null, "Did not fill out form correctly\nPlease double" 
							+ " check your answers and resubmit");
				}else{
					if(f != null){
						JOptionPane.showMessageDialog(null, "Diagnose submited correctly!");
						f.setDiagnosis(editorPane.getText());
						try {
							MDGui.db.updateForm(f);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						setVisible(false);
						MDGui.intializeDoctor();
					}else{
						JOptionPane.showMessageDialog(null, "No diagnose to submited\nGoing back to main page");
						setVisible(false);
						MDGui.intializeDoctor();
					}
				}
			}
		});
		btnSubmit.setBounds(281, 250, 117, 29);
		add(btnSubmit);
		
		JButton btnHomepage = new JButton("Homepage");
		btnHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MDGui.intializeDoctor();
			}
		});
		btnHomepage.setBounds(281, 210, 117, 29);
		add(btnHomepage);
		
	}
}
