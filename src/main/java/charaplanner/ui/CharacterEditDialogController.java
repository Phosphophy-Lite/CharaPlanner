package charaplanner.ui;

import charaplanner.MainApp;
import charaplanner.data.Character;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;

import java.util.prefs.Preferences;
import java.util.stream.Collectors;

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
    @FXML private TextField styleField;
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

    @FXML private ComboBox<charaplanner.data.Character> parentA;
    @FXML private ComboBox<charaplanner.data.Character> parentB;
    @FXML private ComboBox<charaplanner.data.Character> children;
    @FXML private ComboBox<charaplanner.data.Character> siblings;
    @FXML private ComboBox<charaplanner.data.Character> friends;
    @FXML private ComboBox<charaplanner.data.Character> bestFriend;
    @FXML private ComboBox<charaplanner.data.Character> significantOther;
    @FXML private ComboBox<charaplanner.data.Character> rival;
    @FXML private ComboBox<charaplanner.data.Character> mentor;
    @FXML private ComboBox<charaplanner.data.Character> apprentice;
    @FXML private ComboBox<charaplanner.data.Character> enemies;
    @FXML private ComboBox<charaplanner.data.Character> nemesis;
    @FXML private ComboBox<charaplanner.data.Character> grandParents;
    @FXML private ComboBox<charaplanner.data.Character> unclesAunts;
    @FXML private ComboBox<charaplanner.data.Character> other;
    private List<ComboBox<charaplanner.data.Character>> comboBoxesList;

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
    @FXML private TextField aestheticField;
    @FXML private TextArea likesArea;
    @FXML private TextArea dislikesArea;

    @FXML private StatSlider physicalStrengthSlider;
    @FXML private StatSlider mindStrengthSlider;
    @FXML private StatSlider perceptionSlider;
    @FXML private StatSlider speedSlider;
    @FXML private StatSlider dexteritySlider;
    @FXML private StatSlider combatSlider;
    @FXML private StatSlider persuasionSlider;
    @FXML private StatSlider charismaSlider;
    @FXML private StatSlider healthSlider;
    @FXML private StatSlider socialSkillsSlider;
    @FXML private StatSlider braverySlider;
    @FXML private StatSlider intelligenceSlider;
    @FXML private StatSlider confidenceSlider;
    @FXML private StatSlider selfEsteemSlider;
    @FXML private StatSlider viewsSlider;
    @FXML private StatSlider humorSlider;
    @FXML private StatSlider wisdomSlider;
    @FXML private StatSlider empathySlider;
    @FXML private StatSlider sensitivitySlider;
    @FXML private StatSlider creativitySlider;


    @FXML private Label labelSelectedProfilePic;
    private String profilePicPath = "";
    @FXML private Label labelSelectedRefsheet;
    private String refsheetPath = "";

    @FXML private TextArea quoteArea;
    @FXML private ColorPicker associatedColorPicker;
    @FXML private TextField link1LabelField;
    @FXML private TextField link1UrlField;
    @FXML private TextField link2LabelField;
    @FXML private TextField link2UrlField;
    @FXML private TextField link3LabelField;
    @FXML private TextField link3UrlField;

    private charaplanner.data.Character character;
    private static String lastVisitedDirectory;


    private boolean okClicked = false;
    private Stage dialogStage;

    @FXML
    private void initialize() {
        List<StatSlider> statSlidersList;
        comboBoxesList = List.of(
                parentA,
                parentB,
                children,
                siblings,
                friends,
                bestFriend,
                significantOther,
                rival,
                mentor,
                apprentice,
                enemies,
                nemesis,
                grandParents,
                unclesAunts,
                other
        );

        statSlidersList = List.of(
                physicalStrengthSlider,
                mindStrengthSlider,
                perceptionSlider,
                speedSlider,
                dexteritySlider,
                combatSlider,
                persuasionSlider,
                charismaSlider,
                healthSlider,
                socialSkillsSlider,
                braverySlider,
                intelligenceSlider,
                confidenceSlider,
                selfEsteemSlider,
                viewsSlider,
                humorSlider,
                wisdomSlider,
                empathySlider,
                sensitivitySlider,
                creativitySlider
        );

        setStatSlidersLabels();
        enableAllStatSliders(statSlidersList);
        setupAllComboBoxes(comboBoxesList);

        setLastVisitedDirectory(getLastVisitedDirectoryPath());
    }

    public static void setLastVisitedDirectory(String path) {
        lastVisitedDirectory = path;
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    private void setupAllComboBoxes(List<ComboBox<charaplanner.data.Character>> comboBoxesList){
        for (ComboBox<charaplanner.data.Character> comboBox : comboBoxesList) {
            setupComboBox(comboBox);
        }
    }
    private void setupComboBox(ComboBox<charaplanner.data.Character> comboBox) {
        // cell factory to display the displayName of each Character in the comboBox
        comboBox.setCellFactory(box -> new ListCell<>()
        {
            @Override
            protected void updateItem(charaplanner.data.Character c, boolean empty)
            {
                super.updateItem(c, empty);
                if (empty || c == null)
                {
                    setText(null);
                }
                else
                {
                    setText(c.getDisplayName()); // Display displayName
                }
            }
        });

        // set the button cell to display displayName when an item is selected
        comboBox.setButtonCell(new ListCell<>()
        {
            @Override
            protected void updateItem(charaplanner.data.Character c, boolean empty)
            {
                super.updateItem(c, empty);
                if (empty || c == null)
                {
                    setText(null);
                }
                else
                {
                    setText(c.getDisplayName());
                }
            }
        });

        comboBox.setConverter(new StringConverter<>()
        {
            @Override
            public String toString(charaplanner.data.Character c)
            {
                // defines how a character should be displayed in the editable text field (by displayName)
                return (c != null) ? c.getDisplayName() : "";
            }

            @Override
            public charaplanner.data.Character fromString(String string)
            {
                // when user types a new string into the editable text box
                // search for an existing character by displayName,
                // or handle the custom input
                return comboBox.getItems().stream()
                        .filter(c -> c.getDisplayName().equals(string))
                        .findFirst()
                        .orElse(null);
            }
        });
    }

    private void setStatSlidersLabels() {
        final String average = "Average";
        final String balanced = "Balanced";
        physicalStrengthSlider.setCustomLabels("Weak", average, "Strong");
        mindStrengthSlider.setCustomLabels("Vulnerable", average, "Resilient");
        perceptionSlider.setCustomLabels("Oblivious", average, "Attentive");
        speedSlider.setCustomLabels("Slow", average, "Fast");
        dexteritySlider.setCustomLabels("Clumsy", average, "Handy");
        combatSlider.setCustomLabels("Can't fight", average, "Warrior");
        persuasionSlider.setCustomLabels("Unpersuasive", "Moderate", "Influential");
        charismaSlider.setCustomLabels("Low", "Lambda", "High");
        healthSlider.setCustomLabels("Very Bad", average, "Very Healthy");
        socialSkillsSlider.setCustomLabels("Very Awkward", balanced, "Social Butterfly");
        braverySlider.setCustomLabels("Coward", balanced, "Audacious");
        intelligenceSlider.setCustomLabels("Low", average, "Genius");
        confidenceSlider.setCustomLabels("Insecure", balanced, "Arrogant");
        selfEsteemSlider.setCustomLabels("Low", balanced, "High");
        viewsSlider.setCustomLabels("Idealistic", balanced, "Pragmatic");
        humorSlider.setCustomLabels("Serious", "Occasional", "Comedian");
        wisdomSlider.setCustomLabels("Foolish", average, "Very Wise");
        empathySlider.setCustomLabels("None", average, "Empath");
        sensitivitySlider.setCustomLabels("Insensitive", average, "Hypersensitive");
        creativitySlider.setCustomLabels("Low", average, "High");
    }

    private void enableAllStatSliders(List<StatSlider> statSlidersList){
        for(StatSlider slider : statSlidersList){
            slider.enable();
        }
    }

    public void setCharacter(charaplanner.data.Character character) {
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
        quoteArea.setText(character.getQuote());

        Color associatedColor = Color.web(character.getAssociatedColor());
        associatedColorPicker.setValue(associatedColor);

        link1LabelField.setText(character.getLink1().label().get());
        link1UrlField.setText(character.getLink1().url().get());
        link2LabelField.setText(character.getLink2().label().get());
        link2UrlField.setText(character.getLink2().url().get());
        link3LabelField.setText(character.getLink3().label().get());
        link3UrlField.setText(character.getLink3().url().get());

        hairField.setText(character.getAppearance().getHair());
        skinField.setText(character.getAppearance().getSkin());
        eyesField.setText(character.getAppearance().getEyes());
        facialFeaturesField.setText(character.getAppearance().getFacialFeatures());
        heightField.setText(character.getAppearance().getHeight());
        weightField.setText(character.getAppearance().getWeight());
        buildField.setText(character.getAppearance().getBuild());
        distFeaturesField.setText(character.getAppearance().getDistFeatures());
        clothingField.setText(character.getAppearance().getClothing());
        styleField.setText(character.getAppearance().getStyle());
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

        nativeLanguagesField.setText(character.getTrivia().nativeLanguages().get());
        learntLanguagesArea.setText(character.getTrivia().learntLanguages().get());
        speechField.setText(character.getTrivia().speech().get());
        voiceclaimField.setText(character.getTrivia().voiceclaim().get());
        themeSongsArea.setText(character.getTrivia().themeSongs().get());
        animalField.setText(character.getTrivia().animal().get());
        plantField.setText(character.getTrivia().plant().get());
        gemstoneField.setText(character.getTrivia().gemstone().get());
        seasonField.setText(character.getTrivia().season().get());
        placeField.setText(character.getTrivia().place().get());
        foodField.setText(character.getTrivia().food().get());
        drinkField.setText(character.getTrivia().drink().get());
        aestheticField.setText(character.getTrivia().aesthetic().get());
        likesArea.setText(character.getTrivia().likes().get());
        dislikesArea.setText(character.getTrivia().dislikes().get());

        physicalStrengthSlider.setValue(character.getStats().getPhysicalStrength());
        mindStrengthSlider.setValue(character.getStats().getMindStrength());
        perceptionSlider.setValue(character.getStats().getPerception());
        speedSlider.setValue(character.getStats().getSpeed());
        dexteritySlider.setValue(character.getStats().getDexterity());
        combatSlider.setValue(character.getStats().getCombat());
        persuasionSlider.setValue(character.getStats().getPersuasion());
        charismaSlider.setValue(character.getStats().getCharisma());
        healthSlider.setValue(character.getStats().getHealth());
        socialSkillsSlider.setValue(character.getStats().getSocialSkills());
        braverySlider.setValue(character.getStats().getBravery());
        intelligenceSlider.setValue(character.getStats().getIntelligence());
        confidenceSlider.setValue(character.getStats().getConfidence());
        selfEsteemSlider.setValue(character.getStats().getSelfEsteem());
        viewsSlider.setValue(character.getStats().getViews());
        humorSlider.setValue(character.getStats().getHumor());
        wisdomSlider.setValue(character.getStats().getWisdom());
        empathySlider.setValue(character.getStats().getEmpathy());
        sensitivitySlider.setValue(character.getStats().getSensitivity());
        creativitySlider.setValue(character.getStats().getCreativity());

        labelSelectedProfilePic.setText(character.getProfilePicPath());
        profilePicPath = (character.getProfilePicPath() != null) ? character.getProfilePicPath() : "";
        labelSelectedRefsheet.setText(character.getAppearance().getRefsheetPath());
        refsheetPath = (character.getAppearance().getRefsheetPath() != null) ? character.getAppearance().getRefsheetPath() : "";

        setOrSelectName(parentA, character.getRelationships().getParentA());
        setOrSelectName(parentB, character.getRelationships().getParentB());
        setOrSelectName(parentB, character.getRelationships().getChildren());
        setOrSelectName(siblings, character.getRelationships().getSiblings());
        setOrSelectName(parentB, character.getRelationships().getFriends());
        setOrSelectName(bestFriend, character.getRelationships().getBestFriend());
        setOrSelectName(significantOther, character.getRelationships().getSignificantOther());
        setOrSelectName(rival, character.getRelationships().getRival());
        setOrSelectName(mentor, character.getRelationships().getMentor());
        setOrSelectName(apprentice, character.getRelationships().getApprentice());
        setOrSelectName(parentB, character.getRelationships().getEnemies());
        setOrSelectName(nemesis, character.getRelationships().getNemesis());
        setOrSelectName(parentB, character.getRelationships().getGrandParents());
        setOrSelectName(parentB, character.getRelationships().getUnclesAunts());
        setOrSelectName(parentB, character.getRelationships().getOther());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private void setOrSelectName(ComboBox<charaplanner.data.Character> comboBox, String name) {
        // search for a character with the specified name in the comboBox
        Optional<charaplanner.data.Character> matchingCharacter = comboBox.getItems()
                .stream()
                .filter(c -> c.getDisplayName().equals(name))
                .findFirst();

        if (matchingCharacter.isPresent()) {
            // character exists is in the list, set the selected item to this character's name
            comboBox.setValue(matchingCharacter.get());
        } else {
            // character doesn't exist, set the text of the combobox as a custom text
            comboBox.getEditor().setText(name);
        }
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
            character.setQuote(quoteArea.getText());

            String hexAssociatedColor = "#" + associatedColorPicker.getValue().toString().substring(2);
            character.setAssociatedColor(hexAssociatedColor);

            character.getLink1().label().set(link1LabelField.getText());
            character.getLink1().url().set(link1UrlField.getText());
            character.getLink2().label().set(link2LabelField.getText());
            character.getLink2().url().set(link2UrlField.getText());
            character.getLink3().label().set(link3LabelField.getText());
            character.getLink3().url().set(link3UrlField.getText());

            character.getAppearance().setHair(hairField.getText());
            character.getAppearance().setSkin(skinField.getText());
            character.getAppearance().setEyes(eyesField.getText());
            character.getAppearance().setFacialFeatures(facialFeaturesField.getText());
            character.getAppearance().setHeight(heightField.getText());
            character.getAppearance().setWeight(weightField.getText());
            character.getAppearance().setBuild(buildField.getText());
            character.getAppearance().setDistFeatures(distFeaturesField.getText());
            character.getAppearance().setClothing(clothingField.getText());
            character.getAppearance().setStyle(styleField.getText());
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

            character.getTrivia().nativeLanguages().set(nativeLanguagesField.getText());
            character.getTrivia().learntLanguages().set(learntLanguagesArea.getText());
            character.getTrivia().speech().set(speechField.getText());
            character.getTrivia().voiceclaim().set(voiceclaimField.getText());
            character.getTrivia().themeSongs().set(themeSongsArea.getText());
            character.getTrivia().animal().set(animalField.getText());
            character.getTrivia().plant().set(plantField.getText());
            character.getTrivia().gemstone().set(gemstoneField.getText());
            character.getTrivia().season().set(seasonField.getText());
            character.getTrivia().place().set(placeField.getText());
            character.getTrivia().food().set(foodField.getText());
            character.getTrivia().drink().set(drinkField.getText());
            character.getTrivia().aesthetic().set(aestheticField.getText());
            character.getTrivia().likes().set(likesArea.getText());
            character.getTrivia().dislikes().set(dislikesArea.getText());

            character.getStats().setPhysicalStrength(physicalStrengthSlider.getValue());
            character.getStats().setMindStrength(mindStrengthSlider.getValue());
            character.getStats().setPerception(perceptionSlider.getValue());
            character.getStats().setSpeed(speedSlider.getValue());
            character.getStats().setDexterity(dexteritySlider.getValue());
            character.getStats().setCombat(combatSlider.getValue());
            character.getStats().setPersuasion(persuasionSlider.getValue());
            character.getStats().setCharisma(charismaSlider.getValue());
            character.getStats().setHealth(healthSlider.getValue());
            character.getStats().setSocialSkills(socialSkillsSlider.getValue());
            character.getStats().setBravery(braverySlider.getValue());
            character.getStats().setIntelligence(intelligenceSlider.getValue());
            character.getStats().setConfidence(confidenceSlider.getValue());
            character.getStats().setSelfEsteem(selfEsteemSlider.getValue());
            character.getStats().setViews(viewsSlider.getValue());
            character.getStats().setHumor(humorSlider.getValue());
            character.getStats().setWisdom(wisdomSlider.getValue());
            character.getStats().setEmpathy(empathySlider.getValue());
            character.getStats().setSensitivity(sensitivitySlider.getValue());
            character.getStats().setCreativity(creativitySlider.getValue());

            character.setProfilePicPath(profilePicPath);
            character.getAppearance().setRefsheetPath(refsheetPath);

            character.getRelationships().setParentA(parentA.getEditor().getText());
            character.getRelationships().setParentB(parentB.getEditor().getText());
            character.getRelationships().setChildren(children.getEditor().getText());
            character.getRelationships().setSiblings(siblings.getEditor().getText());
            character.getRelationships().setFriends(friends.getEditor().getText());
            character.getRelationships().setBestFriend(bestFriend.getEditor().getText());
            character.getRelationships().setSignificantOther(significantOther.getEditor().getText());
            character.getRelationships().setRival(rival.getEditor().getText());
            character.getRelationships().setMentor(mentor.getEditor().getText());
            character.getRelationships().setApprentice(apprentice.getEditor().getText());
            character.getRelationships().setEnemies(enemies.getEditor().getText());
            character.getRelationships().setNemesis(nemesis.getEditor().getText());
            character.getRelationships().setGrandParents(grandParents.getEditor().getText());
            character.getRelationships().setUnclesAunts(unclesAunts.getEditor().getText());
            character.getRelationships().setOther(other.getEditor().getText());

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
    private void handleImportImage(int num) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(lastVisitedDirectory));
        fc.setTitle("Open picture file");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"));
        File f = fc.showOpenDialog(null);

        if (f != null) {
            setLastVisitedDirectory(getLastVisitedDirectoryPath(f));
            if (num == 0) {
                profilePicPath = f.getAbsolutePath();
                labelSelectedProfilePic.setText("Selected File: " + f.getAbsolutePath());
            }
            else {
                refsheetPath = f.getAbsolutePath();
                labelSelectedRefsheet.setText("Selected File: " + f.getAbsolutePath());
            }
        }
    }

    @FXML
    private void handleImportProfilePic() {
        handleImportImage(0);
    }

    @FXML
    private void handleImportRefsheet() {
        handleImportImage(1);
    }

    public void populateComboBoxes(MainApp mainApp) {  //populate comboBoxes with the charaData list without the edited character
        ObservableList<charaplanner.data.Character> charaData = mainApp.getCharaList()
                .stream()
                .filter(item -> !item.getDisplayName().equals(this.character.getDisplayName()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList)); //make a new observable list without modifying the original one

        for(ComboBox<Character> comboBox : this.comboBoxesList) {
            comboBox.setItems(charaData);
        }
    }

    private static String getLastVisitedDirectoryPath(File file) {
        if (file!= null && file.getParent() != null && file.getParentFile().isDirectory()) {
            Preferences prefs = Preferences.userNodeForPackage(CharacterEditDialogController.class);
            prefs.put("imgLastVisitedDirectory", file.getParent());
            return file.getParent();
        }
        return System.getProperty("user.home");
    }

    private static String getLastVisitedDirectoryPath() {
        Preferences prefs = Preferences.userNodeForPackage(CharacterEditDialogController.class);
        String dirPath = prefs.get("imgLastVisitedDirectory", null);

        if (dirPath != null) {
            File dir = new File(dirPath);
            if (dir.isDirectory()) { // check if directory still exists (hasn't been deleted by user since)
                return dirPath;
            }
        }
        return System.getProperty("user.home");
    }
}
