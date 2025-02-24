package charaplanner.ui;

import charaplanner.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class RecentFilesMenu extends Menu {

    private String pathToFile;
    private static final int MAX_RECENT_FILES = 8;
    private final ObservableList<String> recentEntries;
    private final MainApp mainApp;
    private final RootLayoutController rootController;

    /**
     * Create a new instance of RecentFileMenu.
     * @param name The name of this menu, not displayed but used to store the
    list of recently used file names.
     */
    public RecentFilesMenu(String name, MainApp mainApp, RootLayoutController rootController){
        super();
        this.mainApp = mainApp;
        this.rootController = rootController; // needed to use the canCloseFile() method in openRecentFile()

        this.recentEntries = FXCollections.observableArrayList();

        // Listen to recentEntries changes to update the GUI menu dynamically during execution
        recentEntries.addListener((ListChangeListener<String>) change -> updateMenuItems());

        // Figure out path to save the recent file list
        pathToFile = System.getProperty("user.home"); //Try to get the home directory

        final String recentFileExt = ".recent";

        try {
            // Locate user home directory
            pathToFile = System.getProperty("user.home");



            // Create CharaPlanner subdirectory
            File charaPlannerDir = new File(pathToFile, "CharaPlanner");
            if (!charaPlannerDir.exists() && !charaPlannerDir.mkdirs()) {
                   log.warn("Failed to create CharaPlanner subdirectory. Using default path.");
                    pathToFile = name + recentFileExt; // Fallback to default
                    return;
                }


            // Construct the path to the .recent file
            File recentFile = new File(charaPlannerDir, name + recentFileExt);
            pathToFile = recentFile.getAbsolutePath();
        } catch (Exception e) {
            // Log the error and fallback
            log.warn("Unable to determine path to save recent file list. {}", e.getMessage());
            pathToFile = name + recentFileExt; // Fallback to default
        }

        //Load recent entries from the .recent file
        loadRecentEntries();

        //Populate the menu with recent file items
        updateMenuItems();


    }

    private void loadRecentEntries(){
        //Load the recent entries file if it exists
        File recentFile = new File(pathToFile);
        if (recentFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(recentFile))) {
                recentEntries.clear();
                String line;
                while ((line = reader.readLine()) != null && recentEntries.size() < MAX_RECENT_FILES) {
                    recentEntries.add(line);
                }
            } catch (IOException e) {
                log.error("Failed to load recent entries from file: {}", recentFile.getAbsolutePath(), e);
            }
        }
    }


    // Method to save the current list of recent files to a file
    private void saveRecentEntries() {

        //FileWriter to write streams of characters inside the specified file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            for (String entry : recentEntries) {
                writer.write(entry);
                writer.newLine(); //Calling this method to terminate each output line is preferred to writing a newline character directly.
                //Not all platforms use newline character ('\n').
            }
        } catch (IOException e) {
            log.error("Failed to save recent entries to file: {}", new File(pathToFile).getAbsolutePath(), e);
        }
    }

    /**
     * Adds a new entry to the menu at the top of the list.
     * @param filePath The new path to add.
     */
    public void addEntry(String filePath){
        //Delete filePath from entries List if filePath already exists in it to avoid copies
        recentEntries.remove(filePath);

        //Add filePath at the top of the list
        recentEntries.addFirst(filePath);

        // Remove least recent entries from the list if it exceeds the maximum size allowed
        if(recentEntries.size() > MAX_RECENT_FILES){
            recentEntries.remove(MAX_RECENT_FILES);
        }

        updateMenuItems();
        saveRecentEntries();
    }

    private void removeEntry(String filePath){
        recentEntries.remove(filePath);
        updateMenuItems();
        saveRecentEntries();
    }

    /**
     * Updates the Recently opened files menu with menu items for each recent entry
     */
    @FXML
    public void updateMenuItems() {
        this.getItems().clear(); // Clear existing items
        //for each entry in the recent Entries (logged from the .recent file), add a menu item
        for (String entry : recentEntries) {
            MenuItem menuItem = new MenuItem(entry);
            menuItem.setOnAction(event -> openRecentFile(entry)); // Handle file opening
            this.getItems().add(menuItem);
        }
    }

    /**
     * Open the filePath clicked on in the recently opened files menu
     * @param filePath The path of the recently opened file that gets clicked on
     */
    public void openRecentFile(String filePath) {
        if(rootController.canCloseFile(mainApp.isFileModified())){ //check first with user if current file is okay to close (if modifications)
            File file = new File(filePath);
            if (file.exists()) {
                mainApp.loadDataFile(file); // Call loadDataFile from MainApp
                addEntry(filePath); // add opened File to list of recently opened files
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("File not found");
                alert.setContentText("File: " + file.getPath() + " was probably moved to another path or deleted and could not be found.\n");
                alert.showAndWait();
                removeEntry(filePath);
            }
        }

    }

    public ObservableList<String> getRecentEntriesList(){
        return recentEntries;
    }

}
