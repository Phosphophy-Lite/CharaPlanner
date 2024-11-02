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
    @FXML private TextField displayNameField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField birthDateField;
    @FXML private TextField genderField;
    @FXML private TextField ageField;
    @FXML private TextField jobField;
    @FXML private TextField jobPositionField;
    @FXML private TextField pronounsField;
    @FXML private TextField nicknamesField;
    @FXML private TextField birthPlaceField;
    @FXML private TextField nationalityField;
    @FXML private TextField specieField;
    @FXML private TextField affiliationField;
    @FXML private TextField religionField;

    @FXML private TextField hairField;
    @FXML private TextField skinField;
    @FXML private TextField eyesField;
    @FXML private TextField facialFeaturesField;
    @FXML private TextField heightField;
    @FXML private TextField weightField;
    @FXML private TextField buildField;
    @FXML private TextField distFeaturesField;
    @FXML private TextField clothingField;
    @FXML private TextField aestheticField;
    @FXML private TextField accessoriesField;
    @FXML private TextField itemsField;
    @FXML private TextField weaponsField;
    @FXML private TextField medicalField;
    @FXML private TextArea physDescArea;

    @FXML private TextField traitsField;
    @FXML private TextField strengthsField;
    @FXML private TextField weaknessesField;
    @FXML private TextField skillsField;
    @FXML private TextField alignmentField;
    @FXML private TextField mbtiEnneaField;
    @FXML private TextField mentalHealthField;
    @FXML private TextField fearsField;
    @FXML private TextField hobbiesField;
    @FXML private TextField iqField;
    @FXML private TextField philosophyField;
    @FXML private TextArea personaDescArea;

    @FXML private TextField plotRoleField;
    @FXML private TextArea backstoryArea;
    @FXML private TextArea goalsArea;
    @FXML private TextArea achievementsArea;
    @FXML private TextArea failuresArea;
    @FXML private TextArea traumasArea;
    @FXML private TextArea crimesArea;
    @FXML private TextArea secretsArea;
    @FXML private TextArea powersArea;
    @FXML private TextField educationField;
    @FXML private TextField expertiseField;
    @FXML private TextField socialStatusField;
    @FXML private TextField wealthField;

    @FXML private TextField sexualOrientationField;
    @FXML private TextField romanticOrientationField;
    @FXML private TextField familyStatusField;
    @FXML private TextField relationshipStatusField;

    @FXML private TextField nativeLanguagesField;
    @FXML private TextArea learntLanguagesArea;
    @FXML private TextField speechField;
    @FXML private TextField voiceclaimField;
    @FXML private TextArea themeSongsArea;
    @FXML private TextField animalField;
    @FXML private TextField plantField;
    @FXML private TextField gemstoneField;
    @FXML private TextField seasonField;
    @FXML private TextField placeField;
    @FXML private TextField foodField;
    @FXML private TextField drinkField;
    @FXML private TextArea likesArea;
    @FXML private TextArea dislikesArea;

    @FXML private Label labelSelectedFile;

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
        pronounsField.setText(character.getBasicInfos().getPronouns());
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
        physDescArea.setText(character.getAppearance().getDesc());

        traitsField.setText(character.getPersonality().getTraits());
        strengthsField.setText(character.getPersonality().getStrengths());
        weaknessesField.setText(character.getPersonality().getWeaknesses());
        skillsField.setText(character.getPersonality().getSkills());
        alignmentField.setText(character.getPersonality().getAlignment());
        mbtiEnneaField.setText(character.getPersonality().getMbtiEnnea());
        mentalHealthField.setText(character.getPersonality().getMentalHealth());
        fearsField.setText(character.getPersonality().getFears());
        hobbiesField.setText(character.getPersonality().getHobbies());
        iqField.setText(character.getPersonality().getIq());
        personaDescArea.setText(character.getPersonality().getDesc());

        plotRoleField.setText(character.getStory().getPlotRole());
        backstoryArea.setText(character.getStory().getBackstory());
        goalsArea.setText(character.getStory().getGoals());
        achievementsArea.setText(character.getStory().getAchievements());
        failuresArea.setText(character.getStory().getFailures());
        traumasArea.setText(character.getStory().getTraumas());
        crimesArea.setText(character.getStory().getCrimes());
        secretsArea.setText(character.getStory().getSecrets());
        powersArea.setText(character.getStory().getPowers());
        educationField.setText(character.getStory().getEducation());
        expertiseField.setText(character.getStory().getExpertise());
        socialStatusField.setText(character.getStory().getSocialStatus());
        wealthField.setText(character.getStory().getWealth());

        sexualOrientationField.setText(character.getRelationships().getSexualOrientation());
        romanticOrientationField.setText(character.getRelationships().getRomanticOrientation());
        familyStatusField.setText(character.getRelationships().getFamilyStatus());
        relationshipStatusField.setText(character.getRelationships().getRelationshipStatus());

        nativeLanguagesField.setText(character.getTrivia().getNativeLanguages());
        learntLanguagesArea.setText(character.getTrivia().getLearntLanguages());
        speechField.setText(character.getTrivia().getSpeech());
        voiceclaimField.setText(character.getTrivia().getVoiceclaim());
        themeSongsArea.setText(character.getTrivia().getThemeSongs());
        animalField.setText(character.getTrivia().getAnimal());
        plantField.setText(character.getTrivia().getPlant());
        gemstoneField.setText(character.getTrivia().getGemstone());
        seasonField.setText(character.getTrivia().getSeason());
        placeField.setText(character.getTrivia().getPlace());
        foodField.setText(character.getTrivia().getFood());
        drinkField.setText(character.getTrivia().getDrink());
        likesArea.setText(character.getTrivia().getLikes());
        dislikesArea.setText(character.getTrivia().getDislikes());

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
            character.getBasicInfos().setPronouns(pronounsField.getText());
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
            character.getAppearance().setDesc(physDescArea.getText());

            character.getPersonality().setTraits(traitsField.getText());
            character.getPersonality().setStrengths(strengthsField.getText());
            character.getPersonality().setWeaknesses(weaknessesField.getText());
            character.getPersonality().setSkills(skillsField.getText());
            character.getPersonality().setAlignment(alignmentField.getText());
            character.getPersonality().setMbtiEnnea(mbtiEnneaField.getText());
            character.getPersonality().setMentalHealth(mentalHealthField.getText());
            character.getPersonality().setFears(fearsField.getText());
            character.getPersonality().setHobbies(hobbiesField.getText());
            character.getPersonality().setIq(iqField.getText());
            character.getPersonality().setPhilosophy(philosophyField.getText());
            character.getPersonality().setDesc(personaDescArea.getText());

            character.getStory().setPlotRole(plotRoleField.getText());
            character.getStory().setBackstory(backstoryArea.getText());
            character.getStory().setGoals(goalsArea.getText());
            character.getStory().setAchievements(achievementsArea.getText());
            character.getStory().setFailures(failuresArea.getText());
            character.getStory().setTraumas(traumasArea.getText());
            character.getStory().setCrimes(crimesArea.getText());
            character.getStory().setSecrets(secretsArea.getText());
            character.getStory().setPowers(powersArea.getText());
            character.getStory().setEducation(educationField.getText());
            character.getStory().setExpertise(expertiseField.getText());
            character.getStory().setSocialStatus(socialStatusField.getText());
            character.getStory().setWealth(wealthField.getText());

            character.getRelationships().setSexualOrientation(sexualOrientationField.getText());
            character.getRelationships().setRomanticOrientation(romanticOrientationField.getText());
            character.getRelationships().setFamilyStatus(familyStatusField.getText());
            character.getRelationships().setRelationshipStatus(relationshipStatusField.getText());

            character.getTrivia().setNativeLanguages(nativeLanguagesField.getText());
            character.getTrivia().setLearntLanguages(learntLanguagesArea.getText());
            character.getTrivia().setSpeech(speechField.getText());
            character.getTrivia().setVoiceclaim(voiceclaimField.getText());
            character.getTrivia().setThemeSongs(themeSongsArea.getText());
            character.getTrivia().setAnimal(animalField.getText());
            character.getTrivia().setPlant(plantField.getText());
            character.getTrivia().setGemstone(gemstoneField.getText());
            character.getTrivia().setSeason(seasonField.getText());
            character.getTrivia().setPlace(placeField.getText());
            character.getTrivia().setFood(foodField.getText());
            character.getTrivia().setDrink(drinkField.getText());
            character.getTrivia().setLikes(likesArea.getText());
            character.getTrivia().setDislikes(dislikesArea.getText());

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
