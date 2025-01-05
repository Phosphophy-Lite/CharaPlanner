package chara.planner.charaplanner;

import java.io.File;

import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class RootLayoutController {
    private MainApp mainApp;
    private CharaOverviewController charaOverviewController;
    private RecentFilesMenu recentFilesMenu;

    @FXML private Menu recentMenu;

    @FXML
    private MenuBar menuBar;

    /**
     * Is called by the main application to give a reference back to itself. Also takes care of the recently opened files menu.
     * @param mainApp
     */
    @FXML // do not remove otherwise menu items wont update during exec
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.recentFilesMenu = new RecentFilesMenu("recentFiles", mainApp);

        ObservableList<String> menuItemsList = recentFilesMenu.getRecentEntriesList();
        bindMenutoObservableList(recentMenu, recentFilesMenu, menuItemsList);
        //recentMenu.getItems().clear();
        //recentMenu.getItems().addAll(recentFilesMenu.getItems());

    }
    //necessary, do not remove (i know i wrote spaghetti code everywhere but im lost at this point, i just know it works with this)
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
            recentFilesMenu.addEntry(file.getPath()); // add in the recently opened files
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

    @FXML
    private void handleAbout(){
        mainApp.showAboutDialog();
    }
}
