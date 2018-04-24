package pl.dmichalski.reservations.business.ui.main_menu.view;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.File;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@Component
public class MainMenu extends JFrame {
    private JPanel panel1;
    private JLabel labelCurrentUser;
    private JList<File> list1;
    private JButton ajouterButton;
    private JButton supprimerButton;
    private JButton telechargerButton;
    private JButton sortByNameButton;
    private JButton sortByDateButton;
    private JButton sortByTypeButton;
    private JPanel btnPanel;


    public MainMenu() throws HeadlessException {
        this.setFrameUp();
        list1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                supprimerButton.setEnabled(true);
                telechargerButton.setEnabled(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                //supprimerButton.setEnabled(false);
                //telechargerButton.setEnabled(false);
            }
        });
    }

    public void appendFileList(ListModel<File> files) {
        this.list1.setModel(files);
    }

    private void setFrameUp() {
        setSize(500,500);
        setTitle(ConstMessagesEN.Labels.MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        LookAndFeelUtils.setWindowsLookAndFeel();
    }


    public JPanel getPanel1() {
        return panel1;
    }

    public JLabel getLabelCurrentUser() {
        return labelCurrentUser;
    }

    public JButton getAjouterButton() {
        return ajouterButton;
    }

    public JButton getSupprimerButton() {
        return supprimerButton;
    }

    public JList<File> getList1() {
        return list1;
    }

    public JButton getTelechargerButton() {
        return telechargerButton;
    }

    public JButton getSortByNameButton() {
        return sortByNameButton;
    }

    public JButton getSortByDateButton() {
        return sortByDateButton;
    }

    public JButton getSortByTypeButton() {
        return sortByTypeButton;
    }
}


