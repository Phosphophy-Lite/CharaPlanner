package chara.planner.charaplanner;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.net.URL;

public class CharaOverviewController {
    @FXML private TableView<Character> tableView;

    @FXML private TableColumn<Character, String> nameColumn;

    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label genderLabel;
    @FXML private Label ageLabel;
    @FXML private Label birthDateLabel;
    @FXML private Label jobLabel;
    @FXML private Label jobPositionLabel;
    @FXML private Label pronounsLabel;
    @FXML private Label nicknamesLabel;
    @FXML private Label birthPlaceLabel;
    @FXML private Label nationalityLabel;
    @FXML private Label specieLabel;
    @FXML private Label affiliationLabel;
    @FXML private Label religionLabel;

    @FXML private Label hairLabel;
    @FXML private Label skinLabel;
    @FXML private Label eyesLabel;
    @FXML private Label facialFeaturesLabel;
    @FXML private Label heightLabel;
    @FXML private Label weightLabel;
    @FXML private Label buildLabel;
    @FXML private Label distFeaturesLabel;
    @FXML private Label clothingLabel;
    @FXML private Label aestheticLabel;
    @FXML private Label accessoriesLabel;
    @FXML private Label itemsLabel;
    @FXML private Label weaponsLabel;
    @FXML private Label medicalLabel;
    @FXML private Label physDescLabel;

    @FXML private Label traitsLabel;
    @FXML private Label strengthsLabel;
    @FXML private Label weaknessesLabel;
    @FXML private Label skillsLabel;
    @FXML private Label alignmentLabel;
    @FXML private Label mbtiEnneaLabel;
    @FXML private Label mentalHealthLabel;
    @FXML private Label fearsLabel;
    @FXML private Label hobbiesLabel;
    @FXML private Label iqLabel;
    @FXML private Label philosophyLabel;
    @FXML private Label personaDescLabel;

    @FXML private Label plotRoleLabel;
    @FXML private Label backstoryLabel;
    @FXML private Label goalsLabel;
    @FXML private Label achievementsLabel;
    @FXML private Label failuresLabel;
    @FXML private Label traumasLabel;
    @FXML private Label crimesLabel;
    @FXML private Label secretsLabel;
    @FXML private Label powersLabel;
    @FXML private Label educationLabel;
    @FXML private Label expertiseLabel;
    @FXML private Label socialStatusLabel;
    @FXML private Label wealthLabel;

    @FXML private Label sexualOrientationLabel;
    @FXML private Label romanticOrientationLabel;
    @FXML private Label familyStatusLabel;
    @FXML private Label relationshipStatusLabel;

    @FXML private Label nativeLanguagesLabel;
    @FXML private Label learntLanguagesLabel;
    @FXML private Label speechLabel;
    @FXML private Label voiceclaimLabel;
    @FXML private Label themeSongsLabel;
    @FXML private Label animalLabel;
    @FXML private Label plantLabel;
    @FXML private Label gemstoneLabel;
    @FXML private Label seasonLabel;
    @FXML private Label placeLabel;
    @FXML private Label foodLabel;
    @FXML private Label drinkLabel;
    @FXML private Label likesLabel;
    @FXML private Label dislikesLabel;


    @FXML private VBox vBox;
    @FXML private Label nameRightLabel;
    @FXML private ImageView profilePicImageView;

    @FXML private Slider sliderTest;
    @FXML private StatSlider stattest;


    private MainApp mainApp;

    public CharaOverviewController() {

    }

    @FXML
    private void initialize(){
        //Center horizontally elements of VBox
        vBox.setAlignment(Pos.BASELINE_CENTER);

        sliderTest.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                switch (n.intValue()) {
                    case 0: return "Low";
                    case 5: return "Medium";
                    case 10: return "High";
                    default: return "Label";
                }
            }

            @Override
            public Double fromString(String string) {
                // Convert label back to slider value if needed (not usually needed here)
                switch (string) {
                    case "Low": return 0.0;
                    case "Medium": return 5.0;
                    case "High": return 10.0;
                    default: return 0.0;
                }
            }
        });

        // Disable the slider
        sliderTest.setDisable(true);

        // Override the lowered opacity by setting it back to 1.0
        sliderTest.setOpacity(1.0);
        stattest.setCustomLabels("Low", "Medium", "High");

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
        pronounsLabel.setText("");
        nicknamesLabel.setText("");
        birthPlaceLabel.setText("");
        nationalityLabel.setText("");
        specieLabel.setText("");
        affiliationLabel.setText("");
        religionLabel.setText("");

        traitsLabel.setText("");
        strengthsLabel.setText("");
        weaknessesLabel.setText("");
        skillsLabel.setText("");
        alignmentLabel.setText("");
        mbtiEnneaLabel.setText("");
        mentalHealthLabel.setText("");
        fearsLabel.setText("");
        hobbiesLabel.setText("");
        iqLabel.setText("");
        philosophyLabel.setText("");
        personaDescLabel.setText("");

        hairLabel.setText("");
        skinLabel.setText("");
        eyesLabel.setText("");
        facialFeaturesLabel.setText("");
        heightLabel.setText("");
        weightLabel.setText("");
        buildLabel.setText("");
        distFeaturesLabel.setText("");
        clothingLabel.setText("");
        aestheticLabel.setText("");
        accessoriesLabel.setText("");
        itemsLabel.setText("");
        weaponsLabel.setText("");
        medicalLabel.setText("");
        physDescLabel.setText("");

        plotRoleLabel.setText("");
        backstoryLabel.setText("");
        goalsLabel.setText("");
        achievementsLabel.setText("");
        failuresLabel.setText("");
        traumasLabel.setText("");
        crimesLabel.setText("");
        secretsLabel.setText("");
        powersLabel.setText("");
        educationLabel.setText("");
        expertiseLabel.setText("");
        socialStatusLabel.setText("");
        wealthLabel.setText("");

        sexualOrientationLabel.setText("");
        romanticOrientationLabel.setText("");
        familyStatusLabel.setText("");
        relationshipStatusLabel.setText("");

        nativeLanguagesLabel.setText("");
        learntLanguagesLabel.setText("");
        speechLabel.setText("");
        voiceclaimLabel.setText("");
        themeSongsLabel.setText("");
        animalLabel.setText("");
        plantLabel.setText("");
        gemstoneLabel.setText("");
        seasonLabel.setText("");
        placeLabel.setText("");
        foodLabel.setText("");
        drinkLabel.setText("");
        likesLabel.setText("");
        dislikesLabel.setText("");
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
                pronounsLabel.setText(chara.getBasicInfos().getPronouns());
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
                physDescLabel.setText(chara.getAppearance().getDesc());
            }
            if(chara.getPersonality() != null){
                traitsLabel.setText(chara.getPersonality().getTraits());
                strengthsLabel.setText(chara.getPersonality().getStrengths());
                weaknessesLabel.setText(chara.getPersonality().getWeaknesses());
                skillsLabel.setText(chara.getPersonality().getSkills());
                alignmentLabel.setText(chara.getPersonality().getAlignment());
                mbtiEnneaLabel.setText(chara.getPersonality().getMbtiEnnea());
                mentalHealthLabel.setText(chara.getPersonality().getMentalHealth());
                fearsLabel.setText(chara.getPersonality().getFears());
                hobbiesLabel.setText(chara.getPersonality().getHobbies());
                iqLabel.setText(chara.getPersonality().getIq());
                philosophyLabel.setText(chara.getPersonality().getPhilosophy());
                personaDescLabel.setText(chara.getPersonality().getDesc());
            }
            if(chara.getStory() != null){
                plotRoleLabel.setText(chara.getStory().getPlotRole());
                backstoryLabel.setText(chara.getStory().getBackstory());
                goalsLabel.setText(chara.getStory().getGoals());
                achievementsLabel.setText(chara.getStory().getAchievements());
                failuresLabel.setText(chara.getStory().getFailures());
                traumasLabel.setText(chara.getStory().getTraumas());
                crimesLabel.setText(chara.getStory().getCrimes());
                secretsLabel.setText(chara.getStory().getSecrets());
                powersLabel.setText(chara.getStory().getPowers());
                educationLabel.setText(chara.getStory().getEducation());
                expertiseLabel.setText(chara.getStory().getExpertise());
                socialStatusLabel.setText(chara.getStory().getSocialStatus());
                wealthLabel.setText(chara.getStory().getWealth());
            }
            if(chara.getRelationships() != null){
                sexualOrientationLabel.setText(chara.getRelationships().getSexualOrientation());
                romanticOrientationLabel.setText(chara.getRelationships().getRomanticOrientation());
                familyStatusLabel.setText(chara.getRelationships().getFamilyStatus());
                relationshipStatusLabel.setText(chara.getRelationships().getRelationshipStatus());
            }
            if(chara.getTrivia() != null){
                nativeLanguagesLabel.setText(chara.getTrivia().getNativeLanguages());
                learntLanguagesLabel.setText(chara.getTrivia().getLearntLanguages());
                speechLabel.setText(chara.getTrivia().getSpeech());
                voiceclaimLabel.setText(chara.getTrivia().getVoiceclaim());
                themeSongsLabel.setText(chara.getTrivia().getThemeSongs());
                animalLabel.setText(chara.getTrivia().getAnimal());
                plantLabel.setText(chara.getTrivia().getPlant());
                gemstoneLabel.setText(chara.getTrivia().getGemstone());
                seasonLabel.setText(chara.getTrivia().getSeason());
                placeLabel.setText(chara.getTrivia().getPlace());
                foodLabel.setText(chara.getTrivia().getFood());
                drinkLabel.setText(chara.getTrivia().getDrink());
                likesLabel.setText(chara.getTrivia().getLikes());
                dislikesLabel.setText(chara.getTrivia().getDislikes());
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
