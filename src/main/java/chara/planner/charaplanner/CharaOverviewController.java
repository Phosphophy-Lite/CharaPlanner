package chara.planner.charaplanner;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.net.URL;

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
    private Label jobLabel;
    @FXML
    private Label jobPositionLabel;
    @FXML
    private Label nicknamesLabel;
    @FXML
    private Label birthPlaceLabel;
    @FXML
    private Label nationalityLabel;
    @FXML
    private Label specieLabel;
    @FXML
    private Label affiliationLabel;
    @FXML
    private Label religionLabel;

    @FXML
    private Label hairLabel;
    @FXML
    private Label skinLabel;
    @FXML
    private Label eyesLabel;
    @FXML
    private Label facialFeaturesLabel;
    @FXML
    private Label heightLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label buildLabel;
    @FXML
    private Label distFeaturesLabel;
    @FXML
    private Label clothingLabel;
    @FXML
    private Label aestheticLabel;
    @FXML
    private Label accessoriesLabel;
    @FXML
    private Label itemsLabel;
    @FXML
    private Label weaponsLabel;
    @FXML
    private Label medicalLabel;
    @FXML
    private Label descLabel;


    @FXML
    private VBox vBox;
    @FXML
    private Label nameRightLabel;
    @FXML
    private ImageView profilePicImageView;


    private MainApp mainApp;

    public CharaOverviewController() {

    }

    @FXML
    private void initialize(){
        //Center horizontally elements of VBox
        vBox.setAlignment(Pos.BASELINE_CENTER);

        nameColumn.setCellValueFactory(data -> data.getValue().getDisplayNameProperty());
        showCharaDetails(null);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue,newValue) -> showCharaDetails(newValue));

        //Creates a custom TableRow object for each row in the TableView to specify each row's behavior
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

    private void setLabelsEmpty(){
        firstNameLabel.setText("");
        lastNameLabel.setText("");
        genderLabel.setText("");
        ageLabel.setText("");
        birthDateLabel.setText("");
        nameRightLabel.setText("");
        jobLabel.setText("");
        jobPositionLabel.setText("");
        nicknamesLabel.setText("");
        birthPlaceLabel.setText("");
        nationalityLabel.setText("");
        specieLabel.setText("");
        affiliationLabel.setText("");
        religionLabel.setText("");
    }

    private void showCharaDetails(Character chara){
        setLabelsEmpty();
        if(chara != null){
            if(chara.getBasicInfos() != null){
                firstNameLabel.setText(chara.getBasicInfos().getFirstName());
                lastNameLabel.setText(chara.getBasicInfos().getLastName());
                genderLabel.setText(chara.getBasicInfos().getGender());
                ageLabel.setText(chara.getBasicInfos().getAge());
                birthDateLabel.setText(chara.getBasicInfos().getBirthDate());
                jobLabel.setText(chara.getBasicInfos().getJob());
                jobPositionLabel.setText(chara.getBasicInfos().getJobPosition());
                nationalityLabel.setText(chara.getBasicInfos().getNationality());
                birthPlaceLabel.setText(chara.getBasicInfos().getBirthPlace());
                nicknamesLabel.setText(chara.getBasicInfos().getNicknames());
                specieLabel.setText(chara.getBasicInfos().getSpecie());
                affiliationLabel.setText(chara.getBasicInfos().getAffiliation());
                religionLabel.setText(chara.getBasicInfos().getReligion());
            }
            if(chara.getAppearance() != null) {
                hairLabel.setText(chara.getAppearance().getHair());
                skinLabel.setText(chara.getAppearance().getSkin());
                eyesLabel.setText(chara.getAppearance().getEyes());
                facialFeaturesLabel.setText(chara.getAppearance().getFacialFeatures());
                heightLabel.setText(chara.getAppearance().getHeight());
                weightLabel.setText(chara.getAppearance().getWeight());
                buildLabel.setText(chara.getAppearance().getBuild());
                distFeaturesLabel.setText(chara.getAppearance().getDistFeatures());
                clothingLabel.setText(chara.getAppearance().getClothing());
                aestheticLabel.setText(chara.getAppearance().getAesthetic());
                accessoriesLabel.setText(chara.getAppearance().getAccessories());
                itemsLabel.setText(chara.getAppearance().getItems());
                weaponsLabel.setText(chara.getAppearance().getWeapons());
                medicalLabel.setText(chara.getAppearance().getMedical());
                descLabel.setText(chara.getAppearance().getDesc());
            }

            nameRightLabel.setText(chara.getDisplayName());
            if(chara.getProfilePicPath().isEmpty()){
                URL defaultPicUrl = getClass().getResource("/chara/planner/img/Portrait_Placeholder.png");
                if(defaultPicUrl != null){
                    Image profilePic = new Image(defaultPicUrl.toExternalForm());
                    profilePicImageView.setImage(profilePic);
                }
            }
            else{
                Image profilePic = new Image("file:" + chara.getProfilePicPath());
                profilePicImageView.setImage(profilePic);
            }
        }
        else{
            URL defaultPicUrl = getClass().getResource("/chara/planner/img/Portrait_Placeholder.png");
            if(defaultPicUrl != null){
                Image profilePic = new Image(defaultPicUrl.toExternalForm());
                profilePicImageView.setImage(profilePic);
            }

        }
    }

    @FXML
    public void handleDeleteChara(){
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if(selectedIndex >=0) {
            tableView.getItems().remove(selectedIndex);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Character Selected.");
            alert.setContentText("Please select a character in the table");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleNewChara() {
        Character tempChara = new Character();
        boolean okClicked = mainApp.showCharaNewDialog(tempChara);
        if (okClicked) {
            mainApp.getCharaList().add(tempChara);
        }
    }

    @FXML
    public void handleEditChara() {
        Character selectedChara = tableView.getSelectionModel().getSelectedItem();
        if (selectedChara != null) {
            boolean okClicked = mainApp.showCharaEditDialog(selectedChara);
            if (okClicked) {
                showCharaDetails(selectedChara);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Character Selected");
            alert.setContentText("Please select a character in the table.");

            alert.showAndWait();
        }
    }

}
