package pl.dmichalski.reservations.business.ui.main_menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.File;
import pl.dmichalski.reservations.business.service.FileService;
import pl.dmichalski.reservations.business.service.UserService;
import pl.dmichalski.reservations.business.ui.main_menu.view.MainMenu;
import pl.dmichalski.reservations.business.ui.main_menu.view.modal.FileAdded;
import pl.dmichalski.reservations.business.ui.old.shared.controller.AbstractFrameController;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.SQLException;


@Controller
public class MainMenuController extends AbstractFrameController {

    private MainMenu mainMenuFrame;
    private UserService userService;
    private FileService fileService;
    private DefaultListModel<File> fileList;
    private FileAdded fileAddedFrame;


    @Autowired
    public MainMenuController(MainMenu mainMenuFrame, UserService userService, FileService fileService, FileAdded fileAdded) {
        this.mainMenuFrame = mainMenuFrame;
        this.userService = userService;
        this.fileService = fileService;
        this.fileAddedFrame = fileAdded;
        this.preparePopup();
    }

    private void preparePopup() {
        this.fileAddedFrame.setContentPane(fileAddedFrame.getjPanel());
        this.registerAction(this.fileAddedFrame.getOuvrirButton(), (e) -> {
            try {
                this.openFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        this.registerAction(this.fileAddedFrame.getOkButton(), (e) -> {
            this.fileAddedFrame.setVisible(false);
        });
    }

    private void openFile() throws IOException {
        Desktop.getDesktop().open(this.fileAddedFrame.currentFile);
        this.fileAddedFrame.setVisible(false);
    }

    public void prepareAndOpenFrame() {
        mainMenuFrame.setContentPane(mainMenuFrame.getPanel1());
        mainMenuFrame.getLabelCurrentUser().setText("Espace personnel de " + UserService.getCurrentUser().getUsername());
        fileList = new DefaultListModel<>();
        fileService.getFilesForCurrentUser().forEach(fileList::addElement);
        mainMenuFrame.appendFileList(fileList);
        mainMenuFrame.setVisible(true);

        this.registerAction(mainMenuFrame.getSupprimerButton(), (e) -> this.onDeleteClicked());
        this.registerAction(mainMenuFrame.getAjouterButton(), (e) -> {
            try {
                this.onAjouterClicked();
            } catch (IOException | SQLException e1) {
                e1.printStackTrace();
            }
        });
        this.registerAction(mainMenuFrame.getTelechargerButton(), (e) -> {
            try {
                this.downloadFile();
            } catch (SQLException | IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void downloadFile() throws SQLException, IOException {
        File toDownload = this.mainMenuFrame.getList1().getSelectedValue();
        InputStream in = toDownload.getFileData().getBinaryStream();
        this.checkIfDirectoryExist(System.getProperty("user.home") + "/GDEFiles/");
        java.io.File toWrite = new java.io.File(System.getProperty("user.home") + "/GDEFiles/" + toDownload.getFileName());
        OutputStream out = new FileOutputStream(toWrite);
        byte[] buff = new byte[4096];
        int len = 0;
        while ((len = in.read(buff)) != -1) {
            out.write(buff, 0, len);
        }
        this.fileAddedFrame.getFichierLabel().setText("Votre fichier est disponible dans : " + toWrite.getAbsolutePath());
        this.fileAddedFrame.currentFile = toWrite;
        this.fileAddedFrame.setVisible(true);
    }

    private void checkIfDirectoryExist(String path) {
        java.io.File directory = new java.io.File(path);
        if (!directory.exists()){
            directory.mkdir();
        }
    }

    private void onDeleteClicked() {
        fileService.deleteFile(mainMenuFrame.getList1().getSelectedValue());
        fileList.removeElementAt(mainMenuFrame.getList1().getSelectedIndex());
    }

    public void onModifierClicked() {

    }

    public void onAjouterClicked() throws IOException, SQLException {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(mainMenuFrame);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            byte[] file = convertFileContentToBlob(chooser.getSelectedFile().getAbsolutePath());
            File workFile = new File();
            workFile.setFileData(new javax.sql.rowset.serial.SerialBlob(file));
            String name = chooser.getSelectedFile().getName();
            workFile.setFileName(name);
            workFile.setFileType(name.substring(name.lastIndexOf("."),name.length()));
            workFile.setUser(UserService.currentUser);
            fileService.saveFile(workFile);
            fileList.addElement(workFile);
        }
    }

    public static byte[] convertFileContentToBlob(String filePath) throws IOException {
        byte[] fileContent;
        // initialize string buffer to hold contents of file
        StringBuilder fileContentStr = new StringBuilder("");
        BufferedReader reader = null;
        try {
            // initialize buffered reader
            reader = new BufferedReader(new FileReader(filePath));
            String line = null;
            // read lines of file
            while ((line = reader.readLine()) != null) {
                //append line to string buffer
                fileContentStr.append(line).append("\n");
            }
            // convert string to byte array
            fileContent = fileContentStr.toString().trim().getBytes();
        } catch (IOException e) {
            throw new IOException("Unable to convert file to byte array. " + e.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return fileContent;
    }

}
