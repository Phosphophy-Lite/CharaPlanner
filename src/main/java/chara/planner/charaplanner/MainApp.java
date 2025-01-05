package chara.planner.charaplanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class MainApp extends Application {

    private Stage stage;
    private BorderPane rootLayout;

    //ObservableList : array that is an ArrayList but that is necessary for javaFx to add a listener to the changes made to it so the UI can be updated
    private ObservableList<Character> charaData = FXCollections.observableArrayList();

    public MainApp(){
        charaData.add(new Character("Wolfie", "Wolfgang", "Richthofer", "23/10/????", "Male", "22", "Student", "Literature", ""));
        charaData.add(new Character("Velleius(Mage)", "Velleius", "Vitalis", "500 av JC", "Male", "1200+", "Sage of the Council", "Archivist/Mage", ""));
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.stage.setTitle("Character Planner");

        stage.setMinHeight(675);
        stage.setMinWidth(800);

        RootLayoutController rootController = initRootLayout();
        CharaOverviewController charaOverviewController = initCharaOverview();

        rootController.setCharaOverviewController(charaOverviewController);

    }

    public RootLayoutController initRootLayout() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("RootLayout.fxml"));
        rootLayout = (BorderPane) fxmlLoader.load();

        Scene scene = new Scene(rootLayout, 1200, 675);
        stage.setScene(scene);

        RootLayoutController controller = fxmlLoader.getController();
        controller.setMainApp(this);

        stage.show();

        File file = getDataFilePath();
        if(file != null){
            loadDataFile(file);
        }
        return controller;
    }

    public CharaOverviewController initCharaOverview() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("CharaOverview.fxml"));
        AnchorPane charaOverview = (AnchorPane) fxmlLoader.load();

        rootLayout.setCenter(charaOverview);
        // Bind width and height of charaOverview to the parent center
        charaOverview.prefWidthProperty().bind(rootLayout.widthProperty());
        charaOverview.prefHeightProperty().bind(rootLayout.heightProperty().subtract(
                rootLayout.getTop() != null ? rootLayout.getTop().prefHeight(-1) : 0.0
        ));

        //Acces to the mainapp for controller
        CharaOverviewController charaOverviewController = fxmlLoader.getController();
        charaOverviewController.setMainApp(this);

        return charaOverviewController;
    }

    public Stage getStage() {
        return stage;
    }

    public ObservableList<Character> getCharaList() {
        return charaData;
    }

    public File getDataFilePath(){
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if(filePath != null){
            return new File(filePath);
        }
        else{
            return null;
        }
    }

    public void setDataFilePath(File file){
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if(file != null){
            prefs.put("filePath", file.getAbsolutePath());
            stage.setTitle("Character Planner - " + file.getName());
        }else{
            prefs.remove("filePath");
            stage.setTitle("Character Planner");
        }
    }

    public void loadDataFile(File file){
        try{
            JAXBContext context = JAXBContext
                    .newInstance(CharaListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            CharaListWrapper wrapper = (CharaListWrapper) um.unmarshal(file);

            charaData.clear();
            charaData.addAll(wrapper.getCharacters());

            // Save the file path to the registry.
            setDataFilePath(file);
        }catch (Exception exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());
            setDataFilePath(null);

            alert.showAndWait();
        }
    }

    public void saveCharaDataToFile(File file){
        try {
            JAXBContext context = JAXBContext
                    .newInstance(CharaListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            CharaListWrapper wrapper = new CharaListWrapper();
            wrapper.setCharacters(charaData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setDataFilePath(file);
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
            System.out.println(exception);
        }
    }

    public boolean showCharaEditDialog(Character character) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("CharacterEditDialog.fxml"));
            TabPane page = (TabPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Character");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            CharacterEditDialogController controller = loader.getController();

            // Set the character into the controller.
            controller.setDialogStage(dialogStage);
            controller.setCharacter(character);

            // Populate the ComboBoxes after having set the character into the controller to exclude it from the ComboBoxes' list
            controller.populateComboBoxes(this);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showCharaNewDialog(Character character){
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("CharacterNewDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Create Character");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the character into the controller.
            CharacterNewDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCharacter(character);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showAboutDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About this application...");

        // Create the content
        Text contentText = new Text("This application is developped by Phosphophy-Lite.\n" +
                "For any issues encountered, raise an issue on the corresponding github page down below.\n" +
                "This project is my first JavaFX experience, meant mainly for personal use, so sorry for any malfunction or lack of optimization.\n"
        );

        Hyperlink githubLink = new Hyperlink("Phosphophy-Lite @ Github.com");
        try {
            githubLink.setOnAction(a->getHostServices().showDocument("https://github.com/Phosphophy-Lite"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Combine text and hyperlink in a VBox
        VBox content = new VBox();
        content.getChildren().addAll(contentText, githubLink);
        alert.getDialogPane().setContent(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

}
