package pl.dmichalski.reservations.business.ui.connection.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

import javax.swing.*;

@Component
public class ConnexionModal extends JDialog {

    private JPanel panel1;
    private JButton seConnecterButton;
    private JTextField username;
    private JTextField password;

    public ConnexionModal() {
        this.setFrameUp();
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JButton getSeConnecterButton() {
        return seConnecterButton;
    }


    public JTextField getUsername() {
        return username;
    }

    public JTextField getPassword() {
        return password;
    }

    private void setFrameUp() {
        setSize(500,500);
        setTitle("Connection screen");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        LookAndFeelUtils.setWindowsLookAndFeel();
    }
}