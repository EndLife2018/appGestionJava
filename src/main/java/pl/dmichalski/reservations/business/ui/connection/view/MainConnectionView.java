package pl.dmichalski.reservations.business.ui.connection.view;


import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

import javax.swing.*;
import java.awt.*;

@Component
public class MainConnectionView extends JFrame {
    private JPanel panel1;
    private JButton seConnecterButton;

    public MainConnectionView() throws HeadlessException {
        this.setFrameUp();
    }


    public JPanel getPanel1() {
        return panel1;
    }

    public JButton getSeConnecterButton() {
        return seConnecterButton;
    }

    private void setFrameUp() {
        setSize(500,500);
        setTitle(ConstMessagesEN.Labels.MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        LookAndFeelUtils.setWindowsLookAndFeel();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
