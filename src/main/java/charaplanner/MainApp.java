package charaplanner;

import charaplanner.ui.CharaListWrapper;
import charaplanner.ui.CharaOverviewController;
import charaplanner.data.Character;
import charaplanner.ui.CharacterEditDialogController;
import charaplanner.ui.CharacterNewDialogController;
import charaplanner.ui.RootLayoutController;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.prefs.Preferences;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class MainApp extends Application {

    @Getter
    @Setter
    private boolean fileModified;
    @Getter
    private Stage stage;
    private BorderPane rootLayout;

    //ObservableList : array that is an ArrayList but that is necessary for javaFx to add a listener to the changes made to it so the UI can be updated
    private final ObservableList<Character> charaData = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.stage.setTitle("CharaPlanner");

        //Icon setting
        this.stage.getIcons().addAll(
                new Image(MainApp.class.getResourceAsStream("/img/icon_16.png")),
                new Image(MainApp.class.getResourceAsStream("/img/icon_32.png")),
                new Image(MainApp.class.getResourceAsStream("/img/icon_48.png")),
                new Image(MainApp.class.getResourceAsStream("/img/icon_64.png")),
                new Image(MainApp.class.getResourceAsStream("/img/icon_128.png")),
                new Image(MainApp.class.getResourceAsStream("/img/icon_612.png"))
        );

        stage.setMinHeight(675);
        stage.setMinWidth(800);

        RootLayoutController rootController = initRootLayout();
        CharaOverviewController charaOverviewController = initCharaOverview();

        rootController.setCharaOverviewController(charaOverviewController);

        // If user clicks on cross to close the app, show warning dialog box if fileIsModified = true and cancel event depending on user choice
        stage.setOnCloseRequest(event -> {
            if (!rootController.canCloseFile(fileModified)) {
                // If the function returns false, consume the event to prevent closing
                event.consume();
            }
        });
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

    /**
     * Set the current database file path and remembers it in the preferences
     * @param file : set to null for a newly created empty unsaved file
     */
    public void setDataFilePath(File file){
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if(file != null){
            prefs.put("filePath", file.getAbsolutePath());
            stage.setTitle("CharaPlanner - " + file.getName());
        }else{
            prefs.remove("filePath");
            stage.setTitle("CharaPlanner");

            //Reset modified status for the new created file
            fileModified = false;
        }
    }

    public void loadDataFile(File file){
        try{
            JAXBContext context = JAXBContext.newInstance(CharaListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            CharaListWrapper wrapper = (CharaListWrapper) um.unmarshal(file);

            // If a new version of the project was released with new classes/new attributes in classes
            // update the character objects to be initialized with the new attributes
            // otherwise the characters would become uneditable for new versions
            for(Character character : wrapper.getCharacters()){
                updateObjectFields(character);
            }

            charaData.clear();
            charaData.addAll(wrapper.getCharacters());

            // Save the file path to the registry.
            setDataFilePath(file);

            //Reset modified status for the new opened file
            fileModified = false;
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
            JAXBContext context = JAXBContext.newInstance(CharaListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            CharaListWrapper wrapper = new CharaListWrapper();
            wrapper.setCharacters(charaData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setDataFilePath(file);

            //Update status of current file
            fileModified = false;
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
            System.out.println(exception);
        }
    }

    /**
     * Check if retrieved Object from preexisting XML file lacks fields (null attributes) due to a newer
     * update in the project's Object class, and adds the missing fields
     * @param obj
     */
    private void updateObjectFields(Object obj){
        if(obj == null){return;} //safety check

        try{
            Field[] fields = obj.getClass().getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true); //Allow access to private fields

                // Check if field was initialized, if not (field is null), initialize it
                if(field.get(obj) == null){
                    Class<?> fieldType = field.getType(); //retrieve type of field

                    //Handle SimpleStringProperty (just setting it to blank would be enough for this project)
                    if(fieldType == SimpleStringProperty.class){
                        field.set(obj, new SimpleStringProperty(""));
                    }

                    //Handle SimpleObjectProperty<?>
                    else if(SimpleObjectProperty.class.isAssignableFrom(fieldType)){
                        Class<?> genericType = getGenericType(field); //Retrieve the Class parameter of the SimpleObjectProperty
                        if(genericType != null){
                            Object newInstance = genericType.getDeclaredConstructor().newInstance(); //retrieve constructor for said class
                            field.set(obj, new SimpleObjectProperty<>(newInstance));
                            updateObjectFields(newInstance); //recursively updates the attributes of this subclass
                        }
                    }
                    //No other option, we only use SimpleStringProperties or SimpleObjectProperties for sub classes
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Helper method to determine the generic type of a SimpleObjectProperty
     * @param field
     * @return
     */
    private Class<?> getGenericType(Field field){
        try{
            Type genericType = field.getGenericType();
            if(genericType instanceof ParameterizedType){
                ParameterizedType paramType = (ParameterizedType) genericType;
                Type[] typeArgs = paramType.getActualTypeArguments();
                if(typeArgs.length > 0 && typeArgs[0] instanceof Class){
                    return (Class<?>) typeArgs[0];
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean showCharaEditDialog(Character character) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("CharacterEditDialog.fxml"));
            BorderPane page = (BorderPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Character");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.setMinHeight(400);
            dialogStage.setMinWidth(300);

            CharacterEditDialogController controller = loader.getController();

            // Set the character into the controller.
            controller.setDialogStage(dialogStage);
            controller.setCharacter(character);

            // Populate the ComboBoxes after having set the character into the controller to exclude it from the ComboBoxes' list
            controller.populateComboBoxes(this);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            //if OK button is clicked, consider there are unsaved modifications to the character database
            if(controller.isOkClicked()){
                if(!stage.getTitle().endsWith("*")){
                    stage.setTitle(stage.getTitle() + "*");
                }
                fileModified = true;
            }

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
            BorderPane page = (BorderPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Create Character");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);

            dialogStage.setMinHeight(220);
            dialogStage.setMinWidth(400);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the character into the controller.
            CharacterNewDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCharacter(character);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            //if OK button is clicked, consider there are unsaved modifications to the character database
            if(controller.isOkClicked()){
                if(!stage.getTitle().endsWith("*")){
                    stage.setTitle(stage.getTitle() + "*");
                }
                fileModified = true;
            }

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void handleHyperLink(Hyperlink hyperlink, String url){
        try {
            hyperlink.setOnAction(a->getHostServices().showDocument(url));
        } catch (Exception e) {
            e.printStackTrace();
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

        Hyperlink githubLink = new Hyperlink("Phosphophy-Lite - CharaPlanner on Github.com");
        handleHyperLink(githubLink, "https://github.com/Phosphophy-Lite/CharaPlanner");


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
