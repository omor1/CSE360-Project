import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.SwingConstants;


public class CreateForm_Panel extends JPanel {
	private Form form;
	/**
	 * Create the panel.
	 */
	public CreateForm_Panel() {
		setLayout(null);
		
		JLabel lblCreateForm = new JLabel("Create Form");
		lblCreateForm.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblCreateForm.setBounds(153, 0, 170, 32);
		add(lblCreateForm);

		JLabel lblS = new JLabel("Nausea");
		lblS.setHorizontalAlignment(SwingConstants.CENTER);
		lblS.setBounds(20, 50, 61, 16);
		add(lblS);
		
		JLabel lblS_1 = new JLabel("Pain");
		lblS_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblS_1.setBounds(258, 50, 61, 16);
		add(lblS_1);
		
		JLabel lblS_2 = new JLabel("Fatigue");
		lblS_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblS_2.setBounds(20, 98, 61, 16);
		add(lblS_2);
		
		JLabel lblS_3 = new JLabel("Anexity");
		lblS_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblS_3.setBounds(258, 98, 65, 16);
		add(lblS_3);
		
		JLabel lblS_4 = new JLabel("Shortness of Breath");
		lblS_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblS_4.setToolTipText("");
		lblS_4.setBounds(20, 140, 176, 16);
		add(lblS_4);
		
		JLabel lblAdditionalComments = new JLabel("Additional Comments(max 255 characters):");
		lblAdditionalComments.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblAdditionalComments.setBounds(20, 168, 270, 16);
		add(lblAdditionalComments);
		
		JEditorPane dtrpnPatientscommit = new JEditorPane();
		dtrpnPatientscommit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dtrpnPatientscommit.setText(null);
			}
		});
		dtrpnPatientscommit.setText("PatientsCommit");
		dtrpnPatientscommit.setBounds(20, 191, 270, 91);
		add(dtrpnPatientscommit);
		
		String[] scaleOfPain = {null,"1","2","3","4","5","6","7","8","9","10"};
		
		JComboBox comboBox1 = new JComboBox(scaleOfPain);
		comboBox1.setBounds(123, 50, 123, 25);
		add(comboBox1);
		
		JComboBox comboBox2 = new JComboBox(scaleOfPain);
		comboBox2.setBounds(327, 50, 120, 25);
		add(comboBox2);
		
		JComboBox comboBox3 = new JComboBox(scaleOfPain);
		comboBox3.setBounds(123, 94, 123, 25);
		add(comboBox3);
		
		JComboBox comboBox4 = new JComboBox(scaleOfPain);
		comboBox4.setBounds(327, 90, 120, 32);
		add(comboBox4);
		
		JComboBox comboBox5 = new JComboBox(scaleOfPain);
		comboBox5.setBounds(208, 136, 123, 27);
		add(comboBox5);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(filledOut() != true){
					JOptionPane.showMessageDialog(null, "Did not fill out form correctly\nPlease double" 
							+ " check your answers and resubmit");
				}else{
					JOptionPane.showMessageDialog(null, "Form submited correctly!\n"
							+ "Priority Level: " + comboToInt() );
					
					form = new Form(Integer.parseInt(comboBox1.getSelectedItem().toString()), Integer.parseInt(comboBox2.getSelectedItem().toString()),
							Integer.parseInt(comboBox3.getSelectedItem().toString()), Integer.parseInt(comboBox4.getSelectedItem().toString()), Integer.parseInt(comboBox5.getSelectedItem().toString()),
							dtrpnPatientscommit.getText());
					try {
						MDGui.db.createForm(form);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					setVisible(false);
					MDGui.intializePatient();
				}
			}
			//this is our threshold calculator. Determines priority level of form. 
			private int comboToInt(){
				int sum = 0;
				sum += Integer.parseInt(comboBox1.getSelectedItem().toString());
				sum += Integer.parseInt(comboBox2.getSelectedItem().toString());
				sum += Integer.parseInt(comboBox3.getSelectedItem().toString());
				sum += Integer.parseInt(comboBox4.getSelectedItem().toString());
				sum += Integer.parseInt(comboBox5.getSelectedItem().toString());				
				int fsum = sum/5; 
				return fsum;
			}
			private boolean filledOut(){
				if(comboBox1.getSelectedItem() == null || comboBox2.getSelectedItem() == null
						|| comboBox3.getSelectedItem() == null || comboBox4.getSelectedItem() == null 
						|| comboBox5.getSelectedItem() == null){
					return false;
				}else{
					return true;
				}
			}
		});
		btnSubmit.setBounds(302, 253, 117, 29);
		add(btnSubmit);
		
		JButton btnHomepage = new JButton("Homepage");
		btnHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MDGui.intializePatient();
			}
		});
		btnHomepage.setBounds(302, 216, 117, 32);
		add(btnHomepage);
	
	}
}
