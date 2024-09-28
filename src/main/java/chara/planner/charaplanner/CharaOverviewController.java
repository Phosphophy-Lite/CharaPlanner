package chara.planner.charaplanner;

import chara.planner.charaplanner.Character;
import chara.planner.charaplanner.MainApp;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CharaOverviewController {
    @FXML
    private TableView<Character> tableView;

    @FXML
    private TableColumn<Character, String> nameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label birthDateLabel;

    @FXML
    private VBox vBox;
    @FXML
    private Label nameRightLabel;


    private MainApp mainApp;

    public CharaOverviewController() {

    }

    @FXML
    private void initialize(){
        //Center horizontally elements of VBox
        vBox.setAlignment(Pos.BASELINE_CENTER);

        nameColumn.setCellValueFactory(data -> data.getValue().getFirstNameProperty());
        showCharaDetails(null);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue,newValue) -> showCharaDetails(newValue));

        //Creates a custom TalbeRow object for each row in the TableView to specify each row's behavior
        tableView.setRowFactory(tv -> {
            TableRow<Character> row = new TableRow<>();

            //Attach a ContextMenu to the row
            ContextMenu rowMenu = new ContextMenu();
            MenuItem deleteItem = new MenuItem("Delete");

            //Specify action of Delete item (remove character from the Table)
            deleteItem.setOnAction(event -> {
                Character selectedCharacter = row.getItem(); //acts on the right-clicked row, not dependent on selection in the table
                if(selectedCharacter != null) {
                    tableView.getItems().remove(selectedCharacter);

                }
            });
            //Attach delete item to the context menu
            rowMenu.getItems().add(deleteItem);

            //Only show the context menu if the row is not empty
            row.setOnContextMenuRequested(event -> {
                if (!row.isEmpty()) {
                    rowMenu.show(row, event.getScreenX(), event.getScreenY());
                }
            });

            //Hide the context menu on any left-click
            row.setOnMouseClicked(event -> {
                if (event.getButton() != javafx.scene.input.MouseButton.SECONDARY) {
                    rowMenu.hide();
                }
            });
            return row;
        });

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tableView.setItems(mainApp.getCharaList());
    }

    private void showCharaDetails(Character chara){
        if(chara != null){
            firstNameLabel.setText(chara.getFirstName());
            lastNameLabel.setText(chara.getLastName());
            genderLabel.setText(chara.getGender());
            ageLabel.setText(String.valueOf(chara.getAge()));
            birthDateLabel.setText(String.valueOf(chara.getFormattedDate()));
            nameRightLabel.setText(chara.getFirstName());
        }
        else{
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            genderLabel.setText("");
            ageLabel.setText("");
            birthDateLabel.setText("");
            nameRightLabel.setText("");
        }
    }

}
