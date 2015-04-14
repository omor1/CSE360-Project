import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Doctor_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Doctor_Panel() {
		setLayout(null);
		
		JLabel lblDoctorMenu = new JLabel("Doctor Menu");
		lblDoctorMenu.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		lblDoctorMenu.setBounds(0, 0, 182, 39);
		add(lblDoctorMenu);
		
		JButton btnSetThreshold = new JButton("Set Threshold");
		btnSetThreshold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MDGui.intializeDoctorSetThreshold();
			}
		});
		btnSetThreshold.setBounds(6, 63, 129, 29);
		add(btnSetThreshold);
		
		JButton btnExistingForms = new JButton("Existing Forms");
		btnExistingForms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MDGui.intializeExistingFormDoctor();
			}
		});
		btnExistingForms.setBounds(6, 124, 129, 29);
		add(btnExistingForms);
		
		JButton btnNewButton = new JButton("Next Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MDGui.intializeDoctorDiagonse();
			}
		});
		btnNewButton.setBounds(6, 185, 129, 29);
		add(btnNewButton);

		 JButton btnLogout = new JButton("Logout");
	        btnLogout.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                setVisible(false);
	                MDGui.initializeLogin();
	            }
	        });
	        btnLogout.setBounds(6, 215, 150, 29);
	        add(btnLogout);
	}

}
