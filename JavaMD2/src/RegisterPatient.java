import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;

public class PatientRegister extends JPanel implements ActionListener {

    String msg="";
    JButton btnNew,btnSubmit,btnView;
    JLabel lblRegister, lblFName,lblLName,lblGender,lblQua,lblMName,lblDOB,lblWeight,lblHeight,lblAllergy;
    JLabel lblUserID, lblPassword, lblEmail, lblPhone;
    JTextField txtFName, txtLName, txtMName, txtDOB, txtWeight, txtUser,txtPass,txtEmail,txtPhone;
	JTextArea txtAllergies, txtOutput;
    JPanel top;
    @SuppressWarnings("rawtypes")
	JComboBox comboFoot, comboInches, comboGender;
    protected String gender, weight, height, feet, inches, DOB, FName, LName, MName, phone,password, email, allergies;
    String[] heightFoot = {"Feet","4","5","6","7"};
    String[] heightInches = {"Inches","1","2","3","4","5","6","7","8","9","10","11"};
    String[] genders = {"Male","Female","Other"};
	/**
	 * Create the panel.
	 */
	public PatientRegister() {
		
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		lblRegister = new JLabel("Registration Form");
		lblRegister.setBounds(825,0,500, 50);
		lblRegister.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		add(lblRegister);
		
		lblFName = new JLabel("First Name: ");
		lblFName.setBounds(655, 100, 100, 25);
		add(lblFName);
		
		txtFName = new JTextField(25);
		txtFName.setBounds(730, 100, 150, 25);
		add( txtFName);
	    
		lblLName = new JLabel("Last Name: ");
		lblLName.setBounds(885,100,150,25);
		add(lblLName);
		
		txtLName = new JTextField(25);
		txtLName.setBounds(955, 100, 150, 25);
		add(txtLName);
	    
		lblMName = new JLabel("Middle Initial: ");
		lblMName.setBounds(1115,100,150,25);
		add(lblMName);
		
		txtMName = new JTextField(2);
		txtMName.setBounds(1200, 100, 25, 25);
		add(txtMName);
		
		lblGender = new JLabel("Gender: ");
		lblGender.setBounds(655, 150, 65, 25);
		add(lblGender);
        
        comboGender = new JComboBox(genders);
		comboGender.setBounds(725, 150, 100, 25);
		add(comboGender);
		
		lblDOB = new JLabel("Date of Birth:   MM/DD/YYYY ");
		lblDOB.setBounds(875, 150, 200, 25);
		add(lblDOB);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(1040, 150, 75, 25);
		add(txtDOB);
		
		lblWeight = new JLabel("Weight (lbs): ");
		lblWeight.setBounds(655, 200, 150, 25);
		add(lblWeight);
		
		txtWeight = new JTextField();
		txtWeight.setBounds(730, 200, 25, 25);
		add(txtWeight);
		
		lblHeight = new JLabel("Height (ft): ");
		lblHeight.setBounds(775, 200, 150, 25);
		add(lblHeight);
		
		comboFoot = new JComboBox(heightFoot);
		comboFoot.setBounds(850, 200, 50, 25);
		add(comboFoot);
		
		comboInches = new JComboBox(heightInches);
		comboInches.setBounds(900, 200, 75, 25);
		add(comboInches);
		
        
		lblPassword = new JLabel("Password: (At least 8 Characters): ");
		lblPassword.setBounds(655, 250, 200, 25);
		add(lblPassword);
		
		txtPass = new JTextField();
		txtPass.setBounds(875, 250, 75, 25);
		add(txtPass);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(655, 300, 150, 25);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(725, 300, 200, 25);
		add(txtEmail);
		
		lblPhone = new JLabel("Phone: ");
		lblPhone.setBounds(655, 350, 150, 25);
		add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(725, 350, 200, 25);
		add(txtPhone);
		
		lblAllergy = new JLabel("Known Allergies seperated by Commas");
		lblAllergy.setBounds(655,400,225,25);
		add(lblAllergy);
		
		txtAllergies = new JTextArea();
		txtAllergies.setBounds(655,435,500,200);
		txtAllergies.setBorder(border);
		add(txtAllergies);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(655,675, 100, 50);
		add(btnSubmit);
		
		btnNew = new JButton("Reset");
		btnNew.setBounds(1055,675,100, 50);
		add(btnNew);
		
		txtOutput = new JTextArea("Strings Dislayed here");
		txtOutput.setBounds(655,750,500,200);
		txtOutput.setBorder(border);
		add(txtOutput);
	    btnSubmit.addActionListener(this);
	    btnNew.addActionListener(this);
	  }
	  public void actionPerformed(ActionEvent event) {
		    Object source = event.getSource();
		    if (source == btnSubmit && filledOut()){
		       String initial = txtMName.getText();
		       if (initial != null){
		    	   MName += " ";
		       }
		      //All Values in Text Fields placed into Strings
		       feet = String.valueOf(comboFoot.getSelectedItem());
		       inches = String.valueOf(comboInches.getSelectedItem());
		       gender = String.valueOf(comboGender.getSelectedItem());
		       height = feet.concat("'" + inches + '"');
		       weight = txtWeight.getText();
		       DOB = txtDOB.getText();
		       MName = txtMName.getText();
		       FName = txtFName.getText();
		       LName = txtLName.getText();
		       phone = txtPhone.getText();
		       email = txtEmail.getText();
		       allergies = txtAllergies.getText();
		       password = txtPass.getText();
		       
		       //For the output Text Area for testing purposes
		       /*
		       txtOutput.setText(FName + ' ' + MName + LName);
		       txtOutput.append('\n' + height);
		       txtOutput.append('\n' + DOB);
		       txtOutput.append('\n' + gender);
		       txtOutput.append('\n' + weight);
		       txtOutput.append('\n' + phone);
		       txtOutput.append('\n' + password);
		       txtOutput.append('\n' + email);
		       */
		       
		    }
		    else if (source == btnNew) {
		       //Reset All Values
		       txtOutput.setText("");
		       txtFName.setText("");
		       txtMName.setText("");
		       txtLName.setText("");
		       txtDOB.setText("");
		       txtWeight.setText("");
		       MName = "";
		       FName = "";
		       LName = "";
		       gender = "";
		       height = "";
		       weight = "";
		       phone = "";
		       password = "";
		       email = "";
		       DOB = "";  
		    }
		  }
	  
	  	
			private boolean filledOut(){
	  			if(comboFoot.getSelectedItem() == "Feet" || comboInches.getSelectedItem() == "Inches")
				{
				return false;
				}
				if(txtMName.getText() == "" || txtFName.getText() =="" || txtLName.getText() == "" ||
				   txtPhone.getText() == "" || txtEmail.getText() == "" || txtWeight.getText() == "" ||
			       txtDOB.getText() == "" || txtEmail.getText() == "" || txtUser.getText() == "" ||
			       txtPass.getText() == "" || gender == "")
				{
					return false;
				}
				else{
					return true;
				}
		      
		}
	}
