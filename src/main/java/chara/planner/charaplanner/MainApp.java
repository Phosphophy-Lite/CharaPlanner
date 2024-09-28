package chara.planner.charaplanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;


public class MainApp extends Application {

    private Stage stage;
    private BorderPane rootLayout;

    //ObservableList : array that is an ArrayList but that is necessary for javaFx to add a listener to the changes made to it so the UI can be updated
    private ObservableList<Character> charaData = FXCollections.observableArrayList();

    public MainApp(){
        charaData.add(new Character("Velleius", "Vitalis", LocalDate.of(156,1,12), "Male", 1200));
        charaData.add(new Character("Wolfgang", "Richthofer", LocalDate.of(2002,10,23), "Male", 22));

    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.stage.setTitle("Character Planner");

        stage.setMinHeight(675);
        stage.setMinWidth(800);

        initRootLayout();
        initCharaOverview();

    }

    public void initRootLayout() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("RootLayout.fxml"));
        rootLayout = (BorderPane) fxmlLoader.load();

        Scene scene = new Scene(rootLayout, 1200, 675);
        stage.setScene(scene);
        stage.show();

    }

    public void initCharaOverview() throws IOException {
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


    }

    public Stage getStage() {
        return stage;
    }

    public ObservableList<Character> getCharaList() {
        return charaData;
    }

    public static void main(String[] args) {
        launch();
    }

}
