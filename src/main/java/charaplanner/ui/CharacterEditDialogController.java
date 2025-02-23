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
import lombok.Getter;
import lombok.Setter;

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
    @Setter
    private static String lastVisitedDirectory;


    @Getter
    private boolean okClicked = false;
    @Setter
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
                    setText(c.displayName().get()); // Display displayName
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
                    setText(c.displayName().get());
                }
            }
        });

        comboBox.setConverter(new StringConverter<>()
        {
            @Override
            public String toString(charaplanner.data.Character c)
            {
                // defines how a character should be displayed in the editable text field (by displayName)
                return (c != null) ? c.displayName().get() : "";
            }

            @Override
            public charaplanner.data.Character fromString(String string)
            {
                // when user types a new string into the editable text box
                // search for an existing character by displayName,
                // or handle the custom input
                return comboBox.getItems().stream()
                        .filter(c -> c.displayName().get().equals(string))
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
        displayNameField.setText(character.displayName().get());
        firstNameField.setText(character.basicInfos().get().firstName().get());
        lastNameField.setText(character.basicInfos().get().lastName().get());
        birthDateField.setText(character.basicInfos().get().birthDate().get());
        genderField.setText(character.basicInfos().get().gender().get());
        ageField.setText(character.basicInfos().get().age().get());
        jobField.setText(character.basicInfos().get().job().get());
        jobPositionField.setText(character.basicInfos().get().jobPosition().get());
        pronounsField.setText(character.basicInfos().get().pronouns().get());
        nicknamesField.setText(character.basicInfos().get().nicknames().get());
        birthPlaceField.setText(character.basicInfos().get().birthPlace().get());
        nationalityField.setText(character.basicInfos().get().nationality().get());
        specieField.setText(character.basicInfos().get().specie().get());
        affiliationField.setText(character.basicInfos().get().affiliation().get());
        religionField.setText(character.basicInfos().get().religion().get());
        quoteArea.setText(character.quote().get());

        Color associatedColor = Color.web(character.associatedColor().get());
        associatedColorPicker.setValue(associatedColor);

        link1LabelField.setText(character.link1().get().label().get());
        link1UrlField.setText(character.link1().get().url().get());
        link2LabelField.setText(character.link2().get().label().get());
        link2UrlField.setText(character.link2().get().url().get());
        link3LabelField.setText(character.link3().get().label().get());
        link3UrlField.setText(character.link3().get().url().get());

        hairField.setText(character.appearance().get().hair().get());
        skinField.setText(character.appearance().get().skin().get());
        eyesField.setText(character.appearance().get().eyes().get());
        facialFeaturesField.setText(character.appearance().get().facialFeatures().get());
        heightField.setText(character.appearance().get().height().get());
        weightField.setText(character.appearance().get().weight().get());
        buildField.setText(character.appearance().get().build().get());
        distFeaturesField.setText(character.appearance().get().distFeatures().get());
        clothingField.setText(character.appearance().get().clothing().get());
        styleField.setText(character.appearance().get().style().get());
        accessoriesField.setText(character.appearance().get().accessories().get());
        itemsField.setText(character.appearance().get().items().get());
        weaponsField.setText(character.appearance().get().weapons().get());
        medicalField.setText(character.appearance().get().medical().get());
        physDescArea.setText(character.appearance().get().desc().get());

        traitsField.setText(character.personality().get().traits().get());
        strengthsField.setText(character.personality().get().strengths().get());
        weaknessesField.setText(character.personality().get().weaknesses().get());
        skillsField.setText(character.personality().get().skills().get());
        alignmentField.setText(character.personality().get().alignment().get());
        mbtiEnneaField.setText(character.personality().get().mbtiEnnea().get());
        mentalHealthField.setText(character.personality().get().mentalHealth().get());
        fearsField.setText(character.personality().get().fears().get());
        hobbiesField.setText(character.personality().get().hobbies().get());
        iqField.setText(character.personality().get().iq().get());
        personaDescArea.setText(character.personality().get().desc().get());

        plotRoleField.setText(character.story().get().plotRole().get());
        backstoryArea.setText(character.story().get().backstory().get());
        goalsArea.setText(character.story().get().goals().get());
        achievementsArea.setText(character.story().get().achievements().get());
        failuresArea.setText(character.story().get().failures().get());
        traumasArea.setText(character.story().get().traumas().get());
        crimesArea.setText(character.story().get().crimes().get());
        secretsArea.setText(character.story().get().secrets().get());
        powersArea.setText(character.story().get().powers().get());
        educationField.setText(character.story().get().education().get());
        expertiseField.setText(character.story().get().expertise().get());
        socialStatusField.setText(character.story().get().socialStatus().get());
        wealthField.setText(character.story().get().wealth().get());

        sexualOrientationField.setText(character.relationships().get().sexualOrientation().get());
        romanticOrientationField.setText(character.relationships().get().romanticOrientation().get());
        familyStatusField.setText(character.relationships().get().familyStatus().get());
        relationshipStatusField.setText(character.relationships().get().relationshipStatus().get());

        nativeLanguagesField.setText(character.trivia().get().nativeLanguages().get());
        learntLanguagesArea.setText(character.trivia().get().learntLanguages().get());
        speechField.setText(character.trivia().get().speech().get());
        voiceclaimField.setText(character.trivia().get().voiceclaim().get());
        themeSongsArea.setText(character.trivia().get().themeSongs().get());
        animalField.setText(character.trivia().get().animal().get());
        plantField.setText(character.trivia().get().plant().get());
        gemstoneField.setText(character.trivia().get().gemstone().get());
        seasonField.setText(character.trivia().get().season().get());
        placeField.setText(character.trivia().get().place().get());
        foodField.setText(character.trivia().get().food().get());
        drinkField.setText(character.trivia().get().drink().get());
        aestheticField.setText(character.trivia().get().aesthetic().get());
        likesArea.setText(character.trivia().get().likes().get());
        dislikesArea.setText(character.trivia().get().dislikes().get());

        physicalStrengthSlider.setValue(character.stats().get().physicalStrength().get());
        mindStrengthSlider.setValue(character.stats().get().mindStrength().get());
        perceptionSlider.setValue(character.stats().get().perception().get());
        speedSlider.setValue(character.stats().get().speed().get());
        dexteritySlider.setValue(character.stats().get().dexterity().get());
        combatSlider.setValue(character.stats().get().combat().get());
        persuasionSlider.setValue(character.stats().get().persuasion().get());
        charismaSlider.setValue(character.stats().get().charisma().get());
        healthSlider.setValue(character.stats().get().health().get());
        socialSkillsSlider.setValue(character.stats().get().socialSkills().get());
        braverySlider.setValue(character.stats().get().bravery().get());
        intelligenceSlider.setValue(character.stats().get().intelligence().get());
        confidenceSlider.setValue(character.stats().get().confidence().get());
        selfEsteemSlider.setValue(character.stats().get().selfEsteem().get());
        viewsSlider.setValue(character.stats().get().views().get());
        humorSlider.setValue(character.stats().get().humor().get());
        wisdomSlider.setValue(character.stats().get().wisdom().get());
        empathySlider.setValue(character.stats().get().empathy().get());
        sensitivitySlider.setValue(character.stats().get().sensitivity().get());
        creativitySlider.setValue(character.stats().get().creativity().get());

        labelSelectedProfilePic.setText(character.profilePicPath().get());
        profilePicPath = (character.profilePicPath().get());
        labelSelectedRefsheet.setText(character.appearance().get().refsheetPath().get());
        refsheetPath = (character.appearance().get().refsheetPath().get());

        setOrSelectName(parentA, character.relationships().get().parentA().get());
        setOrSelectName(parentB, character.relationships().get().parentB().get());
        setOrSelectName(parentB, character.relationships().get().children().get());
        setOrSelectName(siblings, character.relationships().get().siblings().get());
        setOrSelectName(parentB, character.relationships().get().friends().get());
        setOrSelectName(bestFriend, character.relationships().get().bestFriend().get());
        setOrSelectName(significantOther, character.relationships().get().significantOther().get());
        setOrSelectName(rival, character.relationships().get().rival().get());
        setOrSelectName(mentor, character.relationships().get().mentor().get());
        setOrSelectName(apprentice, character.relationships().get().apprentice().get());
        setOrSelectName(parentB, character.relationships().get().enemies().get());
        setOrSelectName(nemesis, character.relationships().get().nemesis().get());
        setOrSelectName(parentB, character.relationships().get().grandParents().get());
        setOrSelectName(parentB, character.relationships().get().unclesAunts().get());
        setOrSelectName(parentB, character.relationships().get().other().get());
    }

    private void setOrSelectName(ComboBox<charaplanner.data.Character> comboBox, String name) {
        // search for a character with the specified name in the comboBox
        Optional<charaplanner.data.Character> matchingCharacter = comboBox.getItems()
                .stream()
                .filter(c -> c.displayName().get().equals(name))
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
            character.displayName().set(displayNameField.getText());
            character.basicInfos().get().firstName().set(firstNameField.getText());
            character.basicInfos().get().lastName().set(lastNameField.getText());
            character.basicInfos().get().birthDate().set(birthDateField.getText());
            character.basicInfos().get().age().set(ageField.getText());
            character.basicInfos().get().gender().set(genderField.getText());
            character.basicInfos().get().job().set(jobField.getText());
            character.basicInfos().get().jobPosition().set(jobPositionField.getText());
            character.basicInfos().get().pronouns().set(pronounsField.getText());
            character.basicInfos().get().nicknames().set(nicknamesField.getText());
            character.basicInfos().get().birthPlace().set(birthPlaceField.getText());
            character.basicInfos().get().nationality().set(nationalityField.getText());
            character.basicInfos().get().specie().set(specieField.getText());
            character.basicInfos().get().affiliation().set(affiliationField.getText());
            character.basicInfos().get().religion().set(religionField.getText());
            character.quote().set(quoteArea.getText());

            String hexAssociatedColor = "#" + associatedColorPicker.getValue().toString().substring(2);
            character.associatedColor().set(hexAssociatedColor);

            character.link1().get().label().set(link1LabelField.getText());
            character.link1().get().url().set(link1UrlField.getText());
            character.link2().get().label().set(link2LabelField.getText());
            character.link2().get().url().set(link2UrlField.getText());
            character.link3().get().label().set(link3LabelField.getText());
            character.link3().get().url().set(link3UrlField.getText());

            character.appearance().get().hair().set(hairField.getText());
            character.appearance().get().skin().set(skinField.getText());
            character.appearance().get().eyes().set(eyesField.getText());
            character.appearance().get().facialFeatures().set(facialFeaturesField.getText());
            character.appearance().get().height().set(heightField.getText());
            character.appearance().get().weight().set(weightField.getText());
            character.appearance().get().build().set(buildField.getText());
            character.appearance().get().distFeatures().set(distFeaturesField.getText());
            character.appearance().get().clothing().set(clothingField.getText());
            character.appearance().get().style().set(styleField.getText());
            character.appearance().get().accessories().set(accessoriesField.getText());
            character.appearance().get().items().set(itemsField.getText());
            character.appearance().get().weapons().set(weaponsField.getText());
            character.appearance().get().medical().set(medicalField.getText());
            character.appearance().get().desc().set(physDescArea.getText());

            character.personality().get().traits().set(traitsField.getText());
            character.personality().get().strengths().set(strengthsField.getText());
            character.personality().get().weaknesses().set(weaknessesField.getText());
            character.personality().get().skills().set(skillsField.getText());
            character.personality().get().alignment().set(alignmentField.getText());
            character.personality().get().mbtiEnnea().set(mbtiEnneaField.getText());
            character.personality().get().mentalHealth().set(mentalHealthField.getText());
            character.personality().get().fears().set(fearsField.getText());
            character.personality().get().hobbies().set(hobbiesField.getText());
            character.personality().get().iq().set(iqField.getText());
            character.personality().get().philosophy().set(philosophyField.getText());
            character.personality().get().desc().set(personaDescArea.getText());

            character.story().get().plotRole().set(plotRoleField.getText());
            character.story().get().backstory().set(backstoryArea.getText());
            character.story().get().goals().set(goalsArea.getText());
            character.story().get().achievements().set(achievementsArea.getText());
            character.story().get().failures().set(failuresArea.getText());
            character.story().get().traumas().set(traumasArea.getText());
            character.story().get().crimes().set(crimesArea.getText());
            character.story().get().secrets().set(secretsArea.getText());
            character.story().get().powers().set(powersArea.getText());
            character.story().get().education().set(educationField.getText());
            character.story().get().expertise().set(expertiseField.getText());
            character.story().get().socialStatus().set(socialStatusField.getText());
            character.story().get().wealth().set(wealthField.getText());

            character.relationships().get().sexualOrientation().set(sexualOrientationField.getText());
            character.relationships().get().romanticOrientation().set(romanticOrientationField.getText());
            character.relationships().get().familyStatus().set(familyStatusField.getText());
            character.relationships().get().relationshipStatus().set(relationshipStatusField.getText());

            character.trivia().get().nativeLanguages().set(nativeLanguagesField.getText());
            character.trivia().get().learntLanguages().set(learntLanguagesArea.getText());
            character.trivia().get().speech().set(speechField.getText());
            character.trivia().get().voiceclaim().set(voiceclaimField.getText());
            character.trivia().get().themeSongs().set(themeSongsArea.getText());
            character.trivia().get().animal().set(animalField.getText());
            character.trivia().get().plant().set(plantField.getText());
            character.trivia().get().gemstone().set(gemstoneField.getText());
            character.trivia().get().season().set(seasonField.getText());
            character.trivia().get().place().set(placeField.getText());
            character.trivia().get().food().set(foodField.getText());
            character.trivia().get().drink().set(drinkField.getText());
            character.trivia().get().aesthetic().set(aestheticField.getText());
            character.trivia().get().likes().set(likesArea.getText());
            character.trivia().get().dislikes().set(dislikesArea.getText());

            character.stats().get().physicalStrength().set(physicalStrengthSlider.getValue());
            character.stats().get().mindStrength().set(mindStrengthSlider.getValue());
            character.stats().get().perception().set(perceptionSlider.getValue());
            character.stats().get().speed().set(speedSlider.getValue());
            character.stats().get().dexterity().set(dexteritySlider.getValue());
            character.stats().get().combat().set(combatSlider.getValue());
            character.stats().get().persuasion().set(persuasionSlider.getValue());
            character.stats().get().charisma().set(charismaSlider.getValue());
            character.stats().get().health().set(healthSlider.getValue());
            character.stats().get().socialSkills().set(socialSkillsSlider.getValue());
            character.stats().get().bravery().set(braverySlider.getValue());
            character.stats().get().intelligence().set(intelligenceSlider.getValue());
            character.stats().get().confidence().set(confidenceSlider.getValue());
            character.stats().get().selfEsteem().set(selfEsteemSlider.getValue());
            character.stats().get().views().set(viewsSlider.getValue());
            character.stats().get().humor().set(humorSlider.getValue());
            character.stats().get().wisdom().set(wisdomSlider.getValue());
            character.stats().get().empathy().set(empathySlider.getValue());
            character.stats().get().sensitivity().set(sensitivitySlider.getValue());
            character.stats().get().creativity().set(creativitySlider.getValue());

            character.profilePicPath().set(profilePicPath);
            character.appearance().get().refsheetPath().set((refsheetPath));

            character.relationships().get().parentA().set(parentA.getEditor().getText());
            character.relationships().get().parentB().set(parentB.getEditor().getText());
            character.relationships().get().children().set(children.getEditor().getText());
            character.relationships().get().siblings().set(siblings.getEditor().getText());
            character.relationships().get().friends().set(friends.getEditor().getText());
            character.relationships().get().bestFriend().set(bestFriend.getEditor().getText());
            character.relationships().get().significantOther().set(significantOther.getEditor().getText());
            character.relationships().get().rival().set(rival.getEditor().getText());
            character.relationships().get().mentor().set(mentor.getEditor().getText());
            character.relationships().get().apprentice().set(apprentice.getEditor().getText());
            character.relationships().get().enemies().set(enemies.getEditor().getText());
            character.relationships().get().nemesis().set(nemesis.getEditor().getText());
            character.relationships().get().grandParents().set(grandParents.getEditor().getText());
            character.relationships().get().unclesAunts().set(unclesAunts.getEditor().getText());
            character.relationships().get().other().set(other.getEditor().getText());

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
                .filter(item -> !item.displayName().get().equals(character.displayName().get()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList)); //make a new observable list without modifying the original one

        for(ComboBox<Character> comboBox : comboBoxesList) {
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
