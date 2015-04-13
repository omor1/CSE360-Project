import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class ExistingFormDoctor_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ExistingFormDoctor_Panel() {
setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(6, 72, 470, 142);
		add(editorPane);
		
		JButton btnPendingForms = new JButton("Pending Forms");
		btnPendingForms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Form> l;
				try {
					l = MDGui.db.retrieveListofForms(MDGui.user, "Pending");
					String str = "";
					for(int ii = 0; ii < l.size(); ii++){
						str += l.get(ii).toString();
						str += "\n";
					}
					editorPane.setText(str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPendingForms.setBounds(24, 43, 155, 29);
		add(btnPendingForms);
		
		JButton btnCompletedForms = new JButton("Completed Forms");
		btnCompletedForms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					List<Form> l = MDGui.db.retrieveListofForms(MDGui.user, "Completed");
					String str = "";
					for(int ii = 0; ii < l.size(); ii++){
						str += l.get(ii).toString();
						str += "\n";
					}
					editorPane.setText(str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCompletedForms.setBounds(243, 43, 155, 29);
		add(btnCompletedForms);
		
		JLabel lblExisitingForms = new JLabel("Exisiting Forms");
		lblExisitingForms.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblExisitingForms.setHorizontalAlignment(SwingConstants.CENTER);
		lblExisitingForms.setBounds(78, 6, 285, 29);
		add(lblExisitingForms);
		
		JButton btnHomepage = new JButton("Homepage");
		btnHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MDGui.intializeDoctor();
			}
		});
		btnHomepage.setBounds(149, 226, 117, 29);
		add(btnHomepage);

	}

}
