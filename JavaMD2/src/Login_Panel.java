import javax.mail.internet.AddressException;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JList;


public class Login_Panel extends JPanel {
	private JPasswordField pwdPassword;
	private JTextField txtUsername;

	/**
	 * Create the panel.
	 */
	public Login_Panel() {
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.RED);
		lblLogin.setFont(new Font("Papyrus", Font.BOLD, 30));
		lblLogin.setBackground(new Color(238, 238, 238));
		lblLogin.setBounds(6, 6, 115, 43);
		add(lblLogin);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(112,112,40,28);
		add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(90,144,150,28);
		add(lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pwdPassword.setText(null);
			}
		});
		pwdPassword.setText("Password");
		pwdPassword.setBounds(157, 144, 134, 28);
		add(pwdPassword);
		
		txtUsername = new JTextField();
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUsername.setText(null);
			}
		});
		txtUsername.setText("UserName");
		txtUsername.setBounds(157, 112, 134, 28);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		JRadioButton rdbtnPatient = new JRadioButton("Patient");
		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		
		//Doctor radioButton
		rdbtnDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnPatient.isSelected() == true){
					rdbtnPatient.setSelected(false);
				}
			}
		});
		rdbtnDoctor.setBounds(157, 77, 75, 23);
		add(rdbtnDoctor);
		
		//Patient radioButton
		rdbtnPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnDoctor.isSelected() == true){
					rdbtnDoctor.setSelected(false);
				}
			}
		});
		rdbtnPatient.setBounds(244, 77, 75, 23);
		add(rdbtnPatient);
		
		// Reset password button
		JButton btnReset = new JButton("Reset Password");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MDGui.initializePassResetForm();
			}
		});
		btnReset.setBounds(300, 144, 134, 29);
		add(btnReset);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person temp;
				String table;
				String username = txtUsername.getText();
				String password = pwdPassword.getText();
				if(rdbtnDoctor.isSelected() == true){
					table = "Doctors";
				}else{
					table = "Patients";
				}
				try {
					
					temp = MDGui.db.retrievePerson(table,username, password);
					if(temp == null){
						JOptionPane.showMessageDialog(null, "Invalid Username or Password\nPlease try again");
					}else if(rdbtnDoctor.isSelected() == true){
						MDGui.user = temp;
						setVisible(false);
						MDGui.intializeDoctor();
					}else{
						MDGui.user = temp;
						setVisible(false);
						MDGui.intializePatient();
					}
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEnter.setBounds(300, 115, 134, 29);
		add(btnEnter);
		
		JLabel lblNewPatientRegister = new JLabel("New patient? Register here");
		lblNewPatientRegister.setForeground(Color.blue);
		lblNewPatientRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				MDGui.initializeRegisterForm();
			}
		});
		lblNewPatientRegister.setBounds(135, 174, 173, 16);
		add(lblNewPatientRegister);

	}
}
