package chara.planner.charaplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import chara.planner.charaplanner.Character;

import java.io.File;

public class CharacterEditDialogController {
    @FXML
    private TextField displayNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField birthDateField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField jobField;
    @FXML
    private TextField jobPositionField;

    @FXML
    private TextField nicknamesField;
    @FXML
    private TextField birthPlaceField;
    @FXML
    private TextField nationalityField;
    @FXML
    private TextField specieField;
    @FXML
    private TextField affiliationField;
    @FXML
    private TextField religionField;

    @FXML
    private TextField hairField;
    @FXML
    private TextField skinField;
    @FXML
    private TextField eyesField;
    @FXML
    private TextField facialFeaturesField;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField buildField;
    @FXML
    private TextField distFeaturesField;
    @FXML
    private TextField clothingField;
    @FXML
    private TextField aestheticField;
    @FXML
    private TextField accessoriesField;
    @FXML
    private TextField itemsField;
    @FXML
    private TextField weaponsField;
    @FXML
    private TextField medicalField;
    @FXML
    private TextArea descArea;


    @FXML
    private Label labelSelectedFile;

    private Stage dialogStage;
    private Character character;
    private boolean okClicked = false;
    private String pictureFilePath = "";

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void setCharacter(Character character) {
        this.character = character;
        displayNameField.setText(character.getDisplayName());
        firstNameField.setText(character.getBasicInfos().getFirstName());
        lastNameField.setText(character.getBasicInfos().getLastName());
        birthDateField.setText(character.getBasicInfos().getBirthDate());
        genderField.setText(character.getBasicInfos().getGender());
        ageField.setText(character.getBasicInfos().getAge());
        jobField.setText(character.getBasicInfos().getJob());
        jobPositionField.setText(character.getBasicInfos().getJobPosition());
        nicknamesField.setText(character.getBasicInfos().getNicknames());
        birthPlaceField.setText(character.getBasicInfos().getBirthPlace());
        nationalityField.setText(character.getBasicInfos().getNationality());
        specieField.setText(character.getBasicInfos().getSpecie());
        affiliationField.setText(character.getBasicInfos().getAffiliation());
        religionField.setText(character.getBasicInfos().getReligion());

        hairField.setText(character.getAppearance().getHair());
        skinField.setText(character.getAppearance().getSkin());
        eyesField.setText(character.getAppearance().getEyes());
        facialFeaturesField.setText(character.getAppearance().getFacialFeatures());
        heightField.setText(character.getAppearance().getHeight());
        weightField.setText(character.getAppearance().getWeight());
        buildField.setText(character.getAppearance().getBuild());
        distFeaturesField.setText(character.getAppearance().getDistFeatures());
        clothingField.setText(character.getAppearance().getClothing());
        aestheticField.setText(character.getAppearance().getAesthetic());
        accessoriesField.setText(character.getAppearance().getAccessories());
        itemsField.setText(character.getAppearance().getItems());
        weaponsField.setText(character.getAppearance().getWeapons());
        medicalField.setText(character.getAppearance().getMedical());
        descArea.setText(character.getAppearance().getDesc());


        labelSelectedFile.setText(character.getProfilePicPath());
        pictureFilePath = (character.getProfilePicPath() != null) ? character.getProfilePicPath() : "";
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            character.setDisplayName(displayNameField.getText());
            character.getBasicInfos().setFirstName(firstNameField.getText());
            character.getBasicInfos().setLastName(lastNameField.getText());
            character.getBasicInfos().setBirthDate(birthDateField.getText());
            character.getBasicInfos().setAge(ageField.getText());
            character.getBasicInfos().setGender(genderField.getText());
            character.getBasicInfos().setJob(jobField.getText());
            character.getBasicInfos().setJobPosition(jobPositionField.getText());
            character.getBasicInfos().setNicknames(nicknamesField.getText());
            character.getBasicInfos().setBirthPlace(birthPlaceField.getText());
            character.getBasicInfos().setNationality(nationalityField.getText());
            character.getBasicInfos().setSpecie(specieField.getText());
            character.getBasicInfos().setAffiliation(affiliationField.getText());
            character.getBasicInfos().setReligion(religionField.getText());

            character.getAppearance().setHair(hairField.getText());
            character.getAppearance().setSkin(skinField.getText());
            character.getAppearance().setEyes(eyesField.getText());
            character.getAppearance().setFacialFeatures(facialFeaturesField.getText());
            character.getAppearance().setHeight(heightField.getText());
            character.getAppearance().setWeight(weightField.getText());
            character.getAppearance().setBuild(buildField.getText());
            character.getAppearance().setDistFeatures(distFeaturesField.getText());
            character.getAppearance().setClothing(clothingField.getText());
            character.getAppearance().setAesthetic(aestheticField.getText());
            character.getAppearance().setAccessories(accessoriesField.getText());
            character.getAppearance().setItems(itemsField.getText());
            character.getAppearance().setWeapons(weaponsField.getText());
            character.getAppearance().setMedical(medicalField.getText());
            character.getAppearance().setDesc(descArea.getText());

            character.setProfilePicPath(pictureFilePath);

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (displayNameField.getText() == null || displayNameField.getText().isEmpty()) {
            errorMessage += "Display name mustn't be empty.\n";
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void handleImportPicture() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open picture file");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"));
        File f = fc.showOpenDialog(null);
        if(f!=null){
            pictureFilePath = f.getAbsolutePath();
            labelSelectedFile.setText("Selected File: " + f.getAbsolutePath());
        }
    }
}
