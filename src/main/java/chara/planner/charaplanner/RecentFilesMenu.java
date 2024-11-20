package chara.planner.charaplanner;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecentFilesMenu extends Menu {
    private String pathToFile;
    private static final int MAX_RECENT_FILES = 8;
    String[] recentEntries;
    static String defaultText;
    private MainApp mainApp;

    /**
     * Create a new instance of RecentFileMenu.
     * @param name The name of this menu, not displayed but used to store the
    list of recently used file names.
     */
    public RecentFilesMenu(String name, MainApp mainApp){
        super();
        this.mainApp = mainApp;
        this.setText("Recently opened files...");

        this.recentEntries = new String[MAX_RECENT_FILES];
        Arrays.fill(this.recentEntries, "");

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
        //Load the recent entries if they exist
        File recentFile = new File(pathToFile);
        if (recentFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(recentFile))) {
                List<String> entries = new ArrayList<>();
                String line;
                while ((line = reader.readLine()) != null && entries.size() < MAX_RECENT_FILES) {
                    entries.add(line);
                }
                entries.toArray(recentEntries);
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
     * Adds a new entry to the menu. Moves everything "down" one row.
     * @param filePath The new path to add.
     */
    public void addEntry(String filePath){
        //Shift older entries down so the new one is at the top of the list
        System.arraycopy(recentEntries,0,recentEntries,1,MAX_RECENT_FILES-1);
        recentEntries[0] = filePath;

        updateMenuItems();
        saveRecentEntries();
    }

    /**
     * Updates the Recently opened files menu with menu items for each recent entry
     */
    private void updateMenuItems() {
        this.getItems().clear(); // Clear existing items

        //for each entry in the recent Entries logged from the .recent file, add a menu item
        for (String entry : recentEntries) {
            MenuItem menuItem = new MenuItem(entry);
            menuItem.setOnAction(event -> openRecentFile(entry)); // Handle file opening
            this.getItems().add(menuItem);
        }
    }

    /**
     * Updates the Recently opened files menu with menu items for each recent entry
     * @param filePath The path of the recently opened file that gets clicked on
     */
    private void openRecentFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            mainApp.loadDataFile(file); // Call loadDataFile from MainApp
        } else {
            System.out.println("File not found: " + filePath);
        }
    }
}
