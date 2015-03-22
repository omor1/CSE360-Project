import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Project360 {

	private JFrame frame;
	private JPanel panel;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project360 window = new Project360();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Project360() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		initalizeLogin();
		
	}
	
	private void initalizeLogin(){
		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setBounds(115, 72, 75, 23);
		panel.add(rdbtnDoctor);
		
		JRadioButton rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setBounds(202, 72, 75, 23);
		panel.add(rdbtnPatient);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(134, 107, 134, 28);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		pwdPassword.setBounds(134, 147, 134, 28);
		panel.add(pwdPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPatient.isSelected() == true && rdbtnDoctor.isSelected() == false){
					panel.setVisible(false);
					//intializePatientMenu();
				}else{
					
				}
			}
		});
		btnLogin.setBounds(270, 148, 117, 29);
		panel.add(btnLogin);
		
		panel.repaint();
		
	}

}
