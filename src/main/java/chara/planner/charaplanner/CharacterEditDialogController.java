package chara.planner.charaplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import chara.planner.charaplanner.Character;

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

    private Stage dialogStage;
    private Character character;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void setCharacter(Character character) {
        this.character = character;
        displayNameField.setText(character.getDisplayName());
        firstNameField.setText(character.getFirstName());
        lastNameField.setText(character.getLastName());
        birthDateField.setText(character.getBirthDate());
        genderField.setText(character.getGender());
        ageField.setText(character.getAge());
        jobField.setText(character.getJob());
        jobPositionField.setText(character.getJobPosition());
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
            character.setFirstName(firstNameField.getText());
            character.setLastName(lastNameField.getText());
            character.setBirthDate(birthDateField.getText());
            character.setAge(ageField.getText());
            character.setGender(genderField.getText());
            character.setJob(jobField.getText());
            character.setJobPosition(jobPositionField.getText());

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


}
