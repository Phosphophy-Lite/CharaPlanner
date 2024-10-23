package chara.planner.charaplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
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
