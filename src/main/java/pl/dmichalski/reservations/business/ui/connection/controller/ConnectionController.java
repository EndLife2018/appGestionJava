package pl.dmichalski.reservations.business.ui.connection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.repository.UserRepository;
import pl.dmichalski.reservations.business.service.UserService;
import pl.dmichalski.reservations.business.ui.connection.view.MainConnectionView;
import pl.dmichalski.reservations.business.ui.connection.view.modal.ConnexionModal;
import pl.dmichalski.reservations.business.ui.main_menu.controller.MainMenuController;
import pl.dmichalski.reservations.business.ui.old.shared.controller.AbstractFrameController;

import javax.swing.*;

@Controller
public class ConnectionController extends AbstractFrameController {

    private MainConnectionView mainConnectionFrame;
    private ConnexionModal connexionModal;
    private UserRepository userRepository;
    private MainMenuController mainMenuController;
    @Autowired
    private UserService userService;

    @Autowired
    public ConnectionController(MainConnectionView mainConnectionFrame, ConnexionModal connexionModal, UserRepository userRepository, MainMenuController mainMenuController) {
        this.mainConnectionFrame = mainConnectionFrame;
        this.connexionModal = connexionModal;
        this.userRepository = userRepository;
        this.mainMenuController = mainMenuController;
        this.prepareModal();

    }

    public void prepareModal() {
        connexionModal.setContentPane(connexionModal.getPanel1());
        registerAction(connexionModal.getSeConnecterButton(), (e) -> connect());
    }

    public void prepareAndOpenFrame() {
        mainConnectionFrame.setContentPane(mainConnectionFrame.getPanel1());
        registerAction(mainConnectionFrame.getSeConnecterButton(), (e) -> openConnectWindows());
        mainConnectionFrame.setVisible(true);
    }

    private void openConnectWindows() {
        connexionModal.setVisible(true);
    }

    private void connect() {
        Boolean user = userService.loginUser(connexionModal.getUsername().getText(), connexionModal.getPassword().getText());
        if(user == null) {
            JOptionPane.showMessageDialog(connexionModal,
                    "Identifiants incorrects.",
                    "Attention",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            this.connexionModal.dispose();
            this.mainConnectionFrame.dispose();
            mainMenuController.prepareAndOpenFrame();
        }
    }

}
