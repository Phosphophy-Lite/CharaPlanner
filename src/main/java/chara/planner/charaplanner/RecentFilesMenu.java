package chara.planner.charaplanner;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.io.*;

public class RecentFilesMenu extends Menu {
    private String pathToFile;
    private static final int MAX_RECENT_FILES = 8;
    private ObservableList<String> recentEntries;
    private MainApp mainApp;

    /**
     * Create a new instance of RecentFileMenu.
     * @param name The name of this menu, not displayed but used to store the
    list of recently used file names.
     */
    public RecentFilesMenu(String name, MainApp mainApp){
        super();
        this.mainApp = mainApp;

        this.recentEntries = FXCollections.observableArrayList();

        // Listen to recentEntries changes to update the GUI menu dynamically during execution
        recentEntries.addListener((ListChangeListener<String>) change -> {
            updateMenuItems();
        });

        // Figure out path to save the recent file list
        this.pathToFile = System.getProperty("user.dir"); //Try to get the current working directory

        if((this.pathToFile==null) || (this.pathToFile.length() <= 0)){
            this.pathToFile=new String(name+".recent"); //probably unreachable
        }
        else if(this.pathToFile.endsWith(File.separator)){
            this.pathToFile=this.pathToFile+name+".recent";
        }
        else{
            this.pathToFile=this.pathToFile+File.separator+name+".recent";
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
                e.printStackTrace();
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
            e.printStackTrace();
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
        recentEntries.add(0,filePath);

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

    public ObservableList<String> getRecentEntriesList(){
        return recentEntries;
    }
}
