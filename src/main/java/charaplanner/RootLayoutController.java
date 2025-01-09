package charaplanner;

import java.io.File;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.util.Optional;
import java.util.prefs.Preferences;

public class RootLayoutController {
    private MainApp mainApp;
    private CharaOverviewController charaOverviewController;
    private RecentFilesMenu recentFilesMenu;
    private static String lastVisitedDirectory;

    @FXML private Menu recentMenu;

    @FXML
    private void initialize() {
        lastVisitedDirectory = getLastVisitedDirectoryPath();
    }

    /**
     * Is called by the main application to give a reference back to itself. Also takes care of the recently opened files menu.
     * @param mainApp
     */
    @FXML // do not remove otherwise menu items won't update during exec
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.recentFilesMenu = new RecentFilesMenu("recentFiles", mainApp, this);

        ObservableList<String> menuItemsList = recentFilesMenu.getRecentEntriesList();
        bindMenutoObservableList(recentMenu, recentFilesMenu, menuItemsList);
        //recentMenu.getItems().clear();
        //recentMenu.getItems().addAll(recentFilesMenu.getItems());
    }

    //necessary to work
    private void bindMenutoObservableList(Menu menu, RecentFilesMenu recentFilesMenu, ObservableList<String> menuList){
        // Listen for changes in the observable list
        menuList.addListener((ListChangeListener<String>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (String item : change.getAddedSubList()) {
                        MenuItem menuItem = new MenuItem(item);
                        menuItem.setOnAction(event -> recentFilesMenu.openRecentFile(menuItem.getText()));
                        menu.getItems().add(0,menuItem);
                    }
                }
                if (change.wasRemoved()) {
                    for (String item : change.getRemoved()) {
                        menu.getItems().removeIf(menuItem -> menuItem.getText().equals(item));
                    }
                }
            }
        });

        // Initialize the menu with current list items
        menu.getItems().clear();
        for (String item : menuList) {
            MenuItem menuItem = new MenuItem(item);
            menuItem.setOnAction(event -> recentFilesMenu.openRecentFile(menuItem.getText()));
            menu.getItems().add(menuItem); // Add items in the correct order
        }
    }

    public void setCharaOverviewController(CharaOverviewController charaOverviewController) {
        this.charaOverviewController = charaOverviewController;
    }
    /**
     * Creates an empty database.
     */
    @FXML
    private void handleNew() {
        if(canCloseFile(mainApp.fileIsModified)){
            mainApp.getCharaList().clear();
            mainApp.setDataFilePath(null);
        }
    }

    /**
     * Opens a FileChooser to let the user select a database to load.
     */
    @FXML
    private void handleOpen() {
        if(canCloseFile(mainApp.fileIsModified)) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(lastVisitedDirectory));

            // Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                    "XML files (*.xml)", "*.xml");
            fileChooser.getExtensionFilters().add(extFilter);

            // Show open file dialog on top of stage
            File file = fileChooser.showOpenDialog(mainApp.getStage());

            if (file != null) {
                lastVisitedDirectory = setLastVisitedDirectoryPath(file);
                mainApp.loadDataFile(file);
                recentFilesMenu.addEntry(file.getPath()); // adds the opened file to the recent files menu
            }
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
        fileChooser.setInitialDirectory(new File(lastVisitedDirectory));

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
            lastVisitedDirectory = setLastVisitedDirectoryPath(file);
            mainApp.saveCharaDataToFile(file);
            recentFilesMenu.addEntry(file.getPath()); // add in the recently opened files
        }
    }

    public boolean canCloseFile(boolean fileIsModified) {
        if(fileIsModified){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            alert.setHeaderText("File contains unsaved changes");
            alert.setContentText("File has been modified. Do you want to save?");

            ButtonType buttonTypeSave = new ButtonType("Save...");
            ButtonType buttonTypeDontSave = new ButtonType("Do not save");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeSave, buttonTypeDontSave, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()){
                if(result.get() == buttonTypeSave){
                    handleSave();
                }
                else if (result.get() == buttonTypeCancel) {
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    @FXML
    private void handleExit() {
        if(canCloseFile(mainApp.fileIsModified)){
            System.exit(0);
        }
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

    @FXML
    private void handleAbout(){
        mainApp.showAboutDialog();
    }

    private String setLastVisitedDirectoryPath(File file){
        if(file!= null && file.getParent() != null){
            Preferences prefs = Preferences.userNodeForPackage(RootLayoutController.class);
            prefs.put("xmlLastVisitedDirectory", file.getParent());
            return file.getParent();
        }
        return System.getProperty("user.home");
    }

    private String getLastVisitedDirectoryPath(){
        Preferences prefs = Preferences.userNodeForPackage(RootLayoutController.class);
        String dirPath = prefs.get("xmlLastVisitedDirectory", null);
        if(dirPath != null){
            return dirPath;
        }
        else{
            return System.getProperty("user.home");
        }
    }
}
