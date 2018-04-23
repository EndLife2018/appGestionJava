package pl.dmichalski.reservations.business.ui.main_menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.service.UserService;
import pl.dmichalski.reservations.business.ui.main_menu.view.MainMenu;
import pl.dmichalski.reservations.business.ui.old.shared.controller.AbstractFrameController;

@Controller
public class MainMenuController extends AbstractFrameController {

    private MainMenu mainMenuFrame;
    //private AddFileModal addFileModal;
    @Autowired
    private UserService userService;

    @Autowired
    public MainMenuController(MainMenu mainMenuFrame) {
        this.mainMenuFrame = mainMenuFrame;
        //this.addFileModal = addFileModal;
        this.prepareModal();

    }

    public void prepareModal() {
        //addFileModal.setContentPane(addFileModal.getPanel1());
        //registerAction(addFileModal.getSeConnecterButton(), (e) -> connect());
    }

    public void prepareAndOpenFrame() {
        mainMenuFrame.setContentPane(mainMenuFrame.getPanel1());
        mainMenuFrame.getLabelCurrentUser().setText("Espace personnel de " + userService.getCurrentUser().getUsername());
        //registerAction(mainMenuFrame.getConnectionButton(), (e) -> openConnectWindows());
        mainMenuFrame.setVisible(true);
    }

    //private void openConnectWindows() {
        //addFileModal.setVisible(true);
    //}

    private void connect() {
    }

}
