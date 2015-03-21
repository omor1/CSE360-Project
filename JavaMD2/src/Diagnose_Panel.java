import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Diagnose_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Diagnose_Panel() {
		setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(19, 156, 230, 123);
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
					JOptionPane.showMessageDialog(null, "Diagnose submited correctly!");
					setVisible(false);
					MDGui.intializeDoctor();
				}
			}
		});
		btnSubmit.setBounds(281, 250, 117, 29);
		add(btnSubmit);

	}

}
