import java.util.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResetPassword_Panel extends JPanel{
	private JTextField txtEmailAddress;
	
	public ResetPassword_Panel(){
		setLayout(null);
				
		// Add the Reset Password Title
		JLabel lblResetPasswordTitle = new JLabel("Reset Password");
		lblResetPasswordTitle.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		lblResetPasswordTitle.setBounds(6, 0, 250, 39);
		add(lblResetPasswordTitle);
		
		// Add the Email Label
		JLabel lblEmail = new JLabel("<html>Please enter your email address<br>and a new password will be sent to you.</html>");
		lblEmail.setBounds(6, 70, 300, 40);
		add(lblEmail);
		
		// Add the Email Textbox
		txtEmailAddress = new JTextField();
		txtEmailAddress.setBounds(6, 114, 200, 28);
		add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setText("javamd360@gmail.com"); // For testing purposes
		
		// Add the reset button
		JButton btnReset = new JButton("Reset Password");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				// Checks to see if the email address exists in the DB
				if(PatientExists(txtEmailAddress.getText())){ 
					SendNewPassword(txtEmailAddress.getText());
				}
				else{
					JOptionPane.showMessageDialog(null, "I'm sorry, but that email is not in our records.");
				}
			}
		});
		btnReset.setBounds(6, 143, 200, 29);
		add(btnReset);
	}
	
	private boolean PatientExists(String Email){
		// this will look in DB to see a patient exists with specified email
		try {
			Person temp = MDGui.db.searchEmail(Email);
			if (temp != null)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private void SendNewPassword(String email){
		
		String to = email;
		String from = "javamd360@gmail.com";
		String username = "javamd360";
		final String password = "javamdgroup7";
		
		// Set mail settings
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "587");
		
		try{
			
		// Initiate mail session
		Session session = Session.getInstance(properties,
				new javax.mail.Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication(){
						return new PasswordAuthentication(username, password);
					}
				});
			// Create new message
			MimeMessage message = new MimeMessage(session);
			// Set from
			message.setFrom(new InternetAddress(from));
			// Set to
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));
			// Set Subject
			message.setSubject("Your new JavaMD Password");
			// Set message
			String sBody = "Here is your new password: " + ResetPassword(txtEmailAddress.getText())
					+ "\nPlease login to javaMD with your new password.\n\n" 
					+ "Thanks,\nJavaMD Development Team";
			message.setText(sBody);
			// Send message
			Transport.send(message);
			
			JOptionPane.showMessageDialog(null, "Password sent!");
		
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	private String ResetPassword(String email){
		
		// Generate new password
		String sNewPassword;
		final SecureRandom random = new SecureRandom();
		sNewPassword = new BigInteger(60,random).toString(32);		
		try{
			Person t = MDGui.db.searchEmail(email);
			if(t != null)
			{				
				t.setPassword(sNewPassword);
				MDGui.db.updatePerson(t);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Email not in database");
			}
		}catch(Exception ex){
			sNewPassword = ex.toString();
		}
		return sNewPassword;
	}
}

	
