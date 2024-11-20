package chara.planner.charaplanner;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;

public class RootLayoutController {
    private MainApp mainApp;
    private CharaOverviewController charaOverviewController;
    private RecentFilesMenu recentFilesMenu;

    @FXML
    private MenuBar menuBar;

    /**
     * Is called by the main application to give a reference back to itself.
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.recentFilesMenu = new RecentFilesMenu("recentFiles", mainApp);
        System.out.println(recentFilesMenu);
        Menu recentMenu = new Menu("Recent");
        recentMenu.getItems().addAll(recentFilesMenu.getItems());
        menuBar.getMenus().add(recentMenu);
    }

    public void setCharaOverviewController(CharaOverviewController charaOverviewController) {
        this.charaOverviewController = charaOverviewController;
    }
    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
        mainApp.getCharaList().clear();
        mainApp.setDataFilePath(null);
    }

    /**
     * Opens a FileChooser to let the user select a database to load.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show open file dialog on top of stage
        File file = fileChooser.showOpenDialog(mainApp.getStage());

        if (file != null) {
            mainApp.loadDataFile(file);
            recentFilesMenu.addEntry(file.getPath()); // adds the opened file to the recent files menu
        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
        File personFile = mainApp.getDataFilePath();
        if (personFile != null) {
            mainApp.saveCharaDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog on top of stage
        File file = fileChooser.showSaveDialog(mainApp.getStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveCharaDataToFile(file);
        }
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleNewChara(){
        charaOverviewController.handleNewChara();
    }

    @FXML
    private void handleDeleteChara(){
        charaOverviewController.handleDeleteChara();
    }

    @FXML
    private void handleEditChara(){
        charaOverviewController.handleEditChara();
    }
}
