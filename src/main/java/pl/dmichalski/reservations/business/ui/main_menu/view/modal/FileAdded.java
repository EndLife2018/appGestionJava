package pl.dmichalski.reservations.business.ui.main_menu.view.modal;


import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

import javax.swing.*;

@Component
public class FileAdded extends JDialog {

    private JLabel fichierLabel;
    private JPanel jPanel;
    private JButton ouvrirButton;
    private JButton okButton;
    public java.io.File currentFile;

    public FileAdded() {
        this.setFrameUp();
    }

    private void setFrameUp() {
        setSize(500,300);
        setTitle("Fichier ajouté");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        LookAndFeelUtils.setWindowsLookAndFeel();
    }

    public JLabel getFichierLabel() {
        return fichierLabel;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public JButton getOuvrirButton() {
        return ouvrirButton;
    }

    public JButton getOkButton() {
        return okButton;
    }
}
