
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Patient_Panel extends JPanel {

    /**
     * Create the panel.
     */
    public Patient_Panel() {
        setLayout(null);

        JLabel lblMenu = new JLabel("Patient Menu");
        lblMenu.setBounds(6, 6, 138, 16);
        lblMenu.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 20));
        add(lblMenu);

        JButton btnCreateForm = new JButton("Create Form");
        btnCreateForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MDGui.intializePatientCreateForm();
            }
        });
        btnCreateForm.setBounds(6, 44, 150, 29);
        add(btnCreateForm);

        JButton btnViewExistingForm = new JButton("View Existing Form");
        btnViewExistingForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MDGui.intializeExistingFormPatient();
            }
        });
        btnViewExistingForm.setBounds(6, 85, 150, 29);
        add(btnViewExistingForm);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MDGui.initializeLogin();
            }
        });
        btnLogout.setBounds(6, 125, 150, 29);
        add(btnLogout);

    }
}
