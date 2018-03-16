package pl.dmichalski.reservations.business.ui.main_menu.view;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

import javax.swing.*;
import java.awt.*;

@Component
public class MainMenu extends JFrame {
    private JButton testButton;
    private JPanel panel1;

    public MainMenu() throws HeadlessException {
        this.setFrameUp();
    }

    public JPanel getPanel1() {
        return panel1;
    }

    private void setFrameUp() {
        setSize(500,500);
        setTitle(ConstMessagesEN.Labels.MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        LookAndFeelUtils.setWindowsLookAndFeel();
    }
}


