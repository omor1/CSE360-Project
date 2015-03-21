import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		editorPane.setBounds(6, 72, 438, 129);
		add(editorPane);
		
		JButton btnPendingForms = new JButton("Pending Forms");
		btnPendingForms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editorPane.setText("List of Pending Forms");
			}
		});
		btnPendingForms.setBounds(24, 43, 155, 29);
		add(btnPendingForms);
		
		JButton btnCompletedForms = new JButton("Completed Forms");
		btnCompletedForms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editorPane.setText("List of Completed Forms");
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
		btnHomepage.setBounds(150, 265, 117, 29);
		add(btnHomepage);

	}

}
