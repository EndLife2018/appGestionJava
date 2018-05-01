package pl.dmichalski.reservations.business.ui.main_menu.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

import javax.swing.*;
import java.awt.event.*;



@Component
public class Search extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField searchField;

    public Search() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.setFrameUp();


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    private void setFrameUp() {
        setSize(500,300);
        setTitle("Fichier ajouté");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        LookAndFeelUtils.setWindowsLookAndFeel();
    }

    public static void main(String[] args) {
        Search dialog = new Search();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getButtonOK() {
        return buttonOK;
    }
}
