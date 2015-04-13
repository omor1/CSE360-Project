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

public class RegisterPatient extends JPanel implements ActionListener {

    String msg="";
    JButton btnNew,btnSubmit,btnView;
    JLabel lblRegister, lblFName,lblLName,lblGender,lblQua,lblMName,lblDOB,lblWeight,lblHeight,lblAllergy;
    JLabel lblUserID, lblPassword, lblEmail, lblPhone;
    JTextField txtFName, txtLName, txtMName, txtDOB, txtWeight, txtUser,txtPass,txtEmail,txtPhone;
	JTextArea txtAllergies, txtOutput;
    CheckboxGroup ChkGrp;
    Checkbox chkMale,chkFemale;
    Checkbox chkMca,chkBca,chkBba,chkMba;
    JPanel top;
    @SuppressWarnings("rawtypes")
	JComboBox comboFoot, comboInches;
    protected String gender,weight,height,feet,inches, DOB, FName,LName,MName,phone,password,id,email,allergies;
    String[] heightFoot = {"Feet","4","5","6","7"};
    String[] heightInches = {"Inches","0","1","2","3","4","5","6","7","8","9","10","11"};
	/**
	 * Create the panel.
	 */
	public RegisterPatient() {
		
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		lblRegister = new JLabel("Registration Form");
		lblRegister.setBounds(186,11,500, 50);
		lblRegister.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		add(lblRegister);
		
		lblFName = new JLabel("First Name: ");
		lblFName.setBounds(26, 100, 75, 25);
		add(lblFName);
		
		txtFName = new JTextField(25);
		txtFName.setBounds(111, 100, 150, 25);
		add( txtFName);
	    
		lblLName = new JLabel("Last Name: ");
		lblLName.setBounds(271,100,89,25);
		add(lblLName);
		
		txtLName = new JTextField(25);
		txtLName.setBounds(333, 100, 150, 25);
		add(txtLName);
	    
		lblMName = new JLabel("Middle Initial: ");
		lblMName.setBounds(493,100,150,25);
		add(lblMName);
		
		txtMName = new JTextField(2);
		txtMName.setBounds(564, 100, 25, 25);
		add(txtMName);
		
		lblGender = new JLabel("Gender: ");
		lblGender.setBounds(26, 150, 65, 25);
		add(lblGender);
        
		chkMale = new Checkbox("Male: ");
        chkMale.setBounds(99, 150, 50, 25);
        
        chkFemale = new Checkbox("Female: ");
        chkFemale.setBounds(155, 150, 60, 25);
		
        add(chkMale);
        add(chkFemale);
		
		lblDOB = new JLabel("Date of Birth:   MM/DD/YYYY ");
		lblDOB.setBounds(221, 150, 162, 25);
		add(lblDOB);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(378, 150, 75, 25);
		add(txtDOB);
		
		lblWeight = new JLabel("Weight (lbs): ");
		lblWeight.setBounds(26, 200, 75, 25);
		add(lblWeight);
		
		txtWeight = new JTextField();
		txtWeight.setBounds(99, 200, 25, 25);
		add(txtWeight);
		
		lblHeight = new JLabel("Height (ft): ");
		lblHeight.setBounds(134, 200, 81, 25);
		add(lblHeight);

		comboFoot = new JComboBox(heightFoot);
		comboFoot.setBounds(194, 200, 50, 25);
		add(comboFoot);
		
		comboInches = new JComboBox(heightInches);
		comboInches.setBounds(245, 200, 75, 25);
		add(comboInches);
		
		lblUserID = new JLabel("ID: (6 Digits): ");
		lblUserID.setBounds(26, 250, 150, 25);
		add(lblUserID);
		
		txtUser = new JTextField();
		txtUser.setBounds(99, 250, 75, 25);
		add(txtUser);
        
		
		lblPassword = new JLabel("Password: (> 8 Characters): ");
		lblPassword.setBounds(186, 250, 162, 25);
		add(lblPassword);
		
		txtPass = new JTextField();
		txtPass.setBounds(343, 250, 75, 25);
		add(txtPass);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(26, 286, 50, 25);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(76, 286, 200, 25);
		add(txtEmail);
		
		lblPhone = new JLabel("Phone: ");
		lblPhone.setBounds(286, 286, 50, 25);
		add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(343, 286, 200, 25);
		add(txtPhone);
		
		lblAllergy = new JLabel("Known Allergies seperated by Commas");
		lblAllergy.setBounds(26,322,225,25);
		add(lblAllergy);
		
		txtAllergies = new JTextArea();
		txtAllergies.setBounds(26,351,392,113);
		txtAllergies.setBorder(border);
		add(txtAllergies);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(24,475, 100, 50);
		add(btnSubmit);
		
		btnNew = new JButton("Reset");
		btnNew.setBounds(366,475,100, 50);
		add(btnNew);
		
		txtOutput = new JTextArea("Strings Dislayed here");
		txtOutput.setBounds(26,536,500,187);
		txtOutput.setBorder(border);
		add(txtOutput);
	    btnSubmit.addActionListener(this);
	    btnNew.addActionListener(this);
	  }
	  public void actionPerformed(ActionEvent event) {
		    Object source = event.getSource();
		    if (source == btnSubmit && filledOut()){
		       String initial = txtMName.getText();
		       if (chkMale.getState() == true && chkFemale.getState() == false ){
		    	   gender = chkMale.getLabel();
		       }
		       if (chkFemale.getState() == true && chkMale.getState() == false){
		    	   gender = chkFemale.getLabel();
			       }
		       if ((chkFemale.getState() == true && chkMale.getState() == true) || (chkFemale.getState() == false && chkMale.getState() == false)){
		    	   gender = "";
		       }
		       if (initial != null){
		    	   MName += " ";
		       }
		      //All Values in Text Fields placed into Strings
		       feet = String.valueOf(comboFoot.getSelectedItem());
		       inches = String.valueOf(comboInches.getSelectedItem());
		       height = feet.concat("'" + inches + '"');
		       weight = txtWeight.getText();
		       DOB = txtDOB.getText();
		       MName = txtMName.getText();
		       FName = txtFName.getText();
		       LName = txtLName.getText();
		       phone = txtPhone.getText();
		       email = txtEmail.getText();
		       allergies = txtAllergies.getText();
		       id = txtUser.getText();
		       password = txtPass.getText();
		       
		       //For the output Text Area
		       txtOutput.setText(FName + ' ' + MName + LName);
		       txtOutput.append('\n' + height);
		       txtOutput.append('\n' + DOB);
		       txtOutput.append('\n' + gender);
		       txtOutput.append('\n' + weight);
		       txtOutput.append('\n' + phone);
		       txtOutput.append('\n' + password);
		       txtOutput.append('\n' + id);
		       txtOutput.append('\n' + email);
		       
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
		       id = "";
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
