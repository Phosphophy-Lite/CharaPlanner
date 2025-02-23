package charaplanner.ui;

import charaplanner.data.Character;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class CharacterNewDialogController {
    @FXML
    private TextField displayNameField;

    @Setter
    private Stage dialogStage;
    private charaplanner.data.Character character;
    @Getter
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setCharacter(Character character) {
        this.character = character;
        displayNameField.setText(character.displayName().get());
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            character.displayName().set(displayNameField.getText());
            character.basicInfos().get().firstName().set("");
            character.basicInfos().get().lastName().set("");
            character.basicInfos().get().birthDate().set("");
            character.basicInfos().get().age().set("");
            character.basicInfos().get().gender().set("");
            character.basicInfos().get().job().set("");
            character.basicInfos().get().jobPosition().set("");
            character.profilePicPath().set("");

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
