package charaplanner.ui;

import charaplanner.MainApp;
import charaplanner.data.Character;
import charaplanner.data.Link;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lombok.NoArgsConstructor;

import java.util.Optional;

import java.net.URL;

@NoArgsConstructor
public class CharaOverviewController {
    /* Basic Infos */
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

    /* Appearance */
    @FXML private Label hairLabel;
    @FXML private Label skinLabel;
    @FXML private Label eyesLabel;
    @FXML private Label facialFeaturesLabel;
    @FXML private Label heightLabel;
    @FXML private Label weightLabel;
    @FXML private Label buildLabel;
    @FXML private Label distFeaturesLabel;
    @FXML private Label clothingLabel;
    @FXML private Label styleLabel;
    @FXML private Label accessoriesLabel;
    @FXML private Label itemsLabel;
    @FXML private Label weaponsLabel;
    @FXML private Label medicalLabel;
    @FXML private Label physDescLabel;
    @FXML private ImageView refsheetImageView;

    /* Personality */
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

    /* Story */
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

    /* Relationships */
    @FXML private Label sexualOrientationLabel;
    @FXML private Label romanticOrientationLabel;
    @FXML private Label familyStatusLabel;
    @FXML private Label relationshipStatusLabel;
    @FXML private Label parentALabel;
    @FXML private Label parentBLabel;
    @FXML private Label siblingsLabel;
    @FXML private Label bestFriendLabel;
    @FXML private Label significantOtherLabel;
    @FXML private Label rivalLabel;
    @FXML private Label mentorLabel;
    @FXML private Label apprenticeLabel;
    @FXML private Label nemesisLabel;
    @FXML private Label friendsLabel;
    @FXML private Label childrenLabel;
    @FXML private Label enemiesLabel;
    @FXML private Label unclesAuntsLabel;
    @FXML private Label grandParentsLabel;
    @FXML private Label otherLabel;

    /* Trivia */
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
    @FXML private Label aestheticLabel;
    @FXML private Label likesLabel;
    @FXML private Label dislikesLabel;

    /* Stats */
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

    /* Character table */
    @FXML private TableView<charaplanner.data.Character> tableView;
    @FXML private TableColumn<charaplanner.data.Character, String> nameColumn;

    /* Right pane for more infos */
    @FXML private Label nameRightLabel;
    @FXML private ImageView profilePicImageView;
    @FXML private ColorPicker colorPicker;
    @FXML private Label quoteLabel;
    @FXML private Hyperlink link1;
    @FXML private Hyperlink link2;
    @FXML private Hyperlink link3;


    private MainApp mainApp;

    @FXML
    private void initialize(){
        //initialize everything empty/default settings
        setStatSlidersLabels();
        showCharaDetails(null);

        //Styling profilePic image view by clipping to a rounded rectangle
        clipImgToRectangle(profilePicImageView, profilePicImageView.getFitWidth(), profilePicImageView.getFitHeight());
        clipImgToRectangle(refsheetImageView, refsheetImageView.getFitWidth(), refsheetImageView.getFitHeight());

        nameColumn.setCellValueFactory(data -> data.getValue().displayName());
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue,newValue) -> showCharaDetails(newValue));

        //Creates a custom TableRow object for each row in the TableView to specify each row's behavior
        tableView.setRowFactory(tv -> {
            TableRow<charaplanner.data.Character> row = new TableRow<>();

            //Attach a ContextMenu to the row
            ContextMenu rowMenu = new ContextMenu();
            MenuItem deleteItem = new MenuItem("Delete");
            MenuItem editItem = new MenuItem("Edit");

            //Specify action of Delete item (remove character from the Table)
            deleteItem.setOnAction(event -> {
                charaplanner.data.Character selectedCharacter = row.getItem(); //acts on the right-clicked row, not dependent on selection in the table
                if(selectedCharacter != null) {
                    handleDeleteChara();
                }
            });

            //Specify action of Delete item (remove character from the Table)
            editItem.setOnAction(event -> {
                charaplanner.data.Character selectedCharacter = row.getItem(); //acts on the right-clicked row, not dependent on selection in the table
                if(selectedCharacter != null) {
                    handleEditChara();
                }
            });

            //Attach items to the context menu
            rowMenu.getItems().add(deleteItem);
            rowMenu.getItems().add(editItem);

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

    private void clipImgToRectangle(ImageView imgView, double width, double height){ // clips image views to rectangle with rounded corners
        Rectangle clip = new Rectangle(width, height);
        clip.setArcHeight(30);
        clip.setArcWidth(30);
        imgView.setClip(clip);
    }

    private void centerCropImage(ImageView imgView){
        Image img = imgView.getImage();
        if(img != null) {
            double imageWidth = img.getWidth();
            double imageHeight = img.getHeight();

            double fitWidth = imgView.getFitWidth();
            double fitHeight = imgView.getFitHeight();

            // Calculate aspect ratios
            double imageRatio = imageWidth / imageHeight;
            double imgVewRatio = fitWidth / fitHeight;

            double viewportWidth;
            double viewportHeight;
            double x;
            double y;

            if (imageRatio > imgVewRatio) {
                // Image is wider than the view: adjust width and crop horizontally
                viewportHeight = imageHeight;
                viewportWidth = viewportHeight * imgVewRatio;
                x = (imageWidth - viewportWidth) / 2; // Center horizontally
                y = 0;
            } else {
                // Image is taller than the view: adjust height and crop vertically
                viewportWidth = imageWidth;
                viewportHeight = viewportWidth / imgVewRatio;
                x = 0;
                y = (imageHeight - viewportHeight) / 2; // Center vertically
            }

            // Set the viewport for proper center cropping
            Rectangle2D viewport = new Rectangle2D(x, y, viewportWidth, viewportHeight);
            imgView.setViewport(viewport);
        }
    }

    private void setLabelsEmpty(){ // ugly but using a list with indexes instead of individual labels with names would be confusing and only usable here
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
        quoteLabel.setText("");

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
        styleLabel.setText("");
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
        parentALabel.setText("");
        parentBLabel.setText("");
        siblingsLabel.setText("");
        bestFriendLabel.setText("");
        significantOtherLabel.setText("");
        rivalLabel.setText("");
        mentorLabel.setText("");
        apprenticeLabel.setText("");
        nemesisLabel.setText("");
        friendsLabel.setText("");
        childrenLabel.setText("");
        enemiesLabel.setText("");
        unclesAuntsLabel.setText("");
        grandParentsLabel.setText("");
        otherLabel.setText("");

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
        aestheticLabel.setText("");
        likesLabel.setText("");
        dislikesLabel.setText("");

        link1.setText("");
        link2.setText("");
        link3.setText("");
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

    private double[] getScaledDimensions(ImageView imgView) {
        Image image = imgView.getImage();
        if (image == null) return new double[]{0, 0};

        double imageWidth = image.getWidth();
        double imageHeight = image.getHeight();
        double fitWidth = imgView.getFitWidth();
        double fitHeight = imgView.getFitHeight();

        // scaling factors
        double scaleX = fitWidth / imageWidth;
        double scaleY = fitHeight / imageHeight;

        // use the smaller scale to preserve the aspect ratio
        double scale = Math.min(scaleX, scaleY);

        // new displayed dimensions
        double displayedWidth = imageWidth * scale;
        double displayedHeight = imageHeight * scale;

        return new double[]{displayedWidth, displayedHeight};
    }


    private void setLink(Hyperlink link, Link charaLink){
        if(charaLink != null){
            String charaLinkLabel = charaLink.label().get();
            String charaLinkUrl = charaLink.url().get();

            if(!charaLinkLabel.isEmpty() && !charaLinkUrl.isEmpty()){
                link.setText(charaLinkLabel);
                link.setDisable(false);
                mainApp.handleHyperLink(link, charaLinkUrl);
            }
            else{
                link.setOnAction(null);
                link.setDisable(true);
            }
        }
    }

    private void setImageView(ImageView imgView, String path, boolean isDefault, boolean centerCrop){
        if(!path.isEmpty()){
            if(isDefault){
                URL defaultPicUrl = getClass().getResource(path);
                if(defaultPicUrl != null){
                    Image img = new Image(defaultPicUrl.toExternalForm());
                    imgView.setImage(img);
                }
            }
            else{
                Image img = new Image("file:" + path);
                imgView.setImage(img);
            }
            if(centerCrop){
                centerCropImage(imgView);
            }
            if(imgView.isPreserveRatio()){
                // if preserve ratio modifies the size of this imageView, reset the rectangle properly with the new image
                double[] dimensions = getScaledDimensions(imgView);
                clipImgToRectangle(imgView, dimensions[0], dimensions[1]);
            }
        }
    }

    private void showCharaDetails(Character chara){
        //initialize with everything empty
        setLabelsEmpty();
        colorPicker.setValue(Color.WHITE); //reset Color Picker so it doesn't display the color of the character previously selected
        setImageView(profilePicImageView, "/img/Portrait_Placeholder.png",true, true);
        setImageView(refsheetImageView, "/img/RefSheet_Placeholder.png",true, false);

        //fill fields of character
        if (chara != null) {
            firstNameLabel.setText(chara.basicInfos().get().firstName().get());
            lastNameLabel.setText(chara.basicInfos().get().lastName().get());
            genderLabel.setText(chara.basicInfos().get().gender().get());
            ageLabel.setText(chara.basicInfos().get().age().get());
            birthDateLabel.setText(chara.basicInfos().get().birthDate().get());
            jobLabel.setText(chara.basicInfos().get().job().get());
            jobPositionLabel.setText(chara.basicInfos().get().jobPosition().get());
            pronounsLabel.setText(chara.basicInfos().get().pronouns().get());
            nationalityLabel.setText(chara.basicInfos().get().nationality().get());
            birthPlaceLabel.setText(chara.basicInfos().get().birthPlace().get());
            nicknamesLabel.setText(chara.basicInfos().get().nicknames().get());
            specieLabel.setText(chara.basicInfos().get().specie().get());
            affiliationLabel.setText(chara.basicInfos().get().affiliation().get());
            religionLabel.setText(chara.basicInfos().get().religion().get());
            
            hairLabel.setText(chara.appearance().get().hair().get());
            skinLabel.setText(chara.appearance().get().skin().get());
            eyesLabel.setText(chara.appearance().get().eyes().get());
            facialFeaturesLabel.setText(chara.appearance().get().facialFeatures().get());
            heightLabel.setText(chara.appearance().get().height().get());
            weightLabel.setText(chara.appearance().get().weight().get());
            buildLabel.setText(chara.appearance().get().build().get());
            distFeaturesLabel.setText(chara.appearance().get().distFeatures().get());
            clothingLabel.setText(chara.appearance().get().clothing().get());
            styleLabel.setText(chara.appearance().get().style().get());
            accessoriesLabel.setText(chara.appearance().get().accessories().get());
            itemsLabel.setText(chara.appearance().get().items().get());
            weaponsLabel.setText(chara.appearance().get().weapons().get());
            medicalLabel.setText(chara.appearance().get().medical().get());
            physDescLabel.setText(chara.appearance().get().desc().get());
            setImageView(refsheetImageView, chara.appearance().get().refsheetPath().get(),false, false);
        
            traitsLabel.setText(chara.personality().get().traits().get());
            strengthsLabel.setText(chara.personality().get().strengths().get());
            weaknessesLabel.setText(chara.personality().get().weaknesses().get());
            skillsLabel.setText(chara.personality().get().skills().get());
            alignmentLabel.setText(chara.personality().get().alignment().get());
            mbtiEnneaLabel.setText(chara.personality().get().mbtiEnnea().get());
            mentalHealthLabel.setText(chara.personality().get().mentalHealth().get());
            fearsLabel.setText(chara.personality().get().fears().get());
            hobbiesLabel.setText(chara.personality().get().hobbies().get());
            iqLabel.setText(chara.personality().get().iq().get());
            philosophyLabel.setText(chara.personality().get().philosophy().get());
            personaDescLabel.setText(chara.personality().get().desc().get());
        
            plotRoleLabel.setText(chara.story().get().plotRole().get());
            backstoryLabel.setText(chara.story().get().backstory().get());
            goalsLabel.setText(chara.story().get().goals().get());
            achievementsLabel.setText(chara.story().get().achievements().get());
            failuresLabel.setText(chara.story().get().failures().get());
            traumasLabel.setText(chara.story().get().traumas().get());
            crimesLabel.setText(chara.story().get().crimes().get());
            secretsLabel.setText(chara.story().get().secrets().get());
            powersLabel.setText(chara.story().get().powers().get());
            educationLabel.setText(chara.story().get().education().get());
            expertiseLabel.setText(chara.story().get().expertise().get());
            socialStatusLabel.setText(chara.story().get().socialStatus().get());
            wealthLabel.setText(chara.story().get().wealth().get());
        
            sexualOrientationLabel.setText(chara.relationships().get().sexualOrientation().get());
            romanticOrientationLabel.setText(chara.relationships().get().romanticOrientation().get());
            familyStatusLabel.setText(chara.relationships().get().familyStatus().get());
            relationshipStatusLabel.setText(chara.relationships().get().relationshipStatus().get());
            parentALabel.setText(chara.relationships().get().parentA().get());
            parentBLabel.setText(chara.relationships().get().parentB().get());
            siblingsLabel.setText(chara.relationships().get().siblings().get());
            bestFriendLabel.setText(chara.relationships().get().bestFriend().get());
            significantOtherLabel.setText(chara.relationships().get().significantOther().get());
            rivalLabel.setText(chara.relationships().get().rival().get());
            mentorLabel.setText(chara.relationships().get().mentor().get());
            apprenticeLabel.setText(chara.relationships().get().apprentice().get());
            nemesisLabel.setText(chara.relationships().get().nemesis().get());
            friendsLabel.setText(chara.relationships().get().friends().get());
            childrenLabel.setText(chara.relationships().get().children().get());
            enemiesLabel.setText(chara.relationships().get().enemies().get());
            unclesAuntsLabel.setText(chara.relationships().get().unclesAunts().get());
            grandParentsLabel.setText(chara.relationships().get().grandParents().get());
            otherLabel.setText(chara.relationships().get().other().get());
        
            nativeLanguagesLabel.setText(chara.trivia().get().nativeLanguages().get());
            learntLanguagesLabel.setText(chara.trivia().get().learntLanguages().get());
            speechLabel.setText(chara.trivia().get().speech().get());
            voiceclaimLabel.setText(chara.trivia().get().voiceclaim().get());
            themeSongsLabel.setText(chara.trivia().get().themeSongs().get());
            animalLabel.setText(chara.trivia().get().animal().get());
            plantLabel.setText(chara.trivia().get().plant().get());
            gemstoneLabel.setText(chara.trivia().get().gemstone().get());
            seasonLabel.setText(chara.trivia().get().season().get());
            placeLabel.setText(chara.trivia().get().place().get());
            foodLabel.setText(chara.trivia().get().food().get());
            drinkLabel.setText(chara.trivia().get().drink().get());
            aestheticLabel.setText(chara.trivia().get().aesthetic().get());
            likesLabel.setText(chara.trivia().get().likes().get());
            dislikesLabel.setText(chara.trivia().get().dislikes().get());

            physicalStrengthSlider.setValue(chara.stats().get().physicalStrength().get());
            mindStrengthSlider.setValue(chara.stats().get().mindStrength().get());
            perceptionSlider.setValue(chara.stats().get().perception().get());
            speedSlider.setValue(chara.stats().get().speed().get());
            dexteritySlider.setValue(chara.stats().get().dexterity().get());
            combatSlider.setValue(chara.stats().get().combat().get());
            persuasionSlider.setValue(chara.stats().get().persuasion().get());
            charismaSlider.setValue(chara.stats().get().charisma().get());
            healthSlider.setValue(chara.stats().get().health().get());
            socialSkillsSlider.setValue(chara.stats().get().socialSkills().get());
            braverySlider.setValue(chara.stats().get().bravery().get());
            intelligenceSlider.setValue(chara.stats().get().intelligence().get());
            confidenceSlider.setValue(chara.stats().get().confidence().get());
            selfEsteemSlider.setValue(chara.stats().get().selfEsteem().get());
            viewsSlider.setValue(chara.stats().get().views().get());
            humorSlider.setValue(chara.stats().get().humor().get());
            wisdomSlider.setValue(chara.stats().get().wisdom().get());
            empathySlider.setValue(chara.stats().get().empathy().get());
            sensitivitySlider.setValue(chara.stats().get().sensitivity().get());
            creativitySlider.setValue(chara.stats().get().creativity().get());

            nameRightLabel.setText(chara.displayName().get());
            quoteLabel.setText(chara.quote().get());
            Color associatedColor = Color.web(chara.associatedColor().get());
            colorPicker.setValue(associatedColor);
            setLink(link1, chara.link1().get());
            setLink(link2, chara.link2().get());
            setLink(link3, chara.link3().get());
            
            setImageView(profilePicImageView, chara.profilePicPath().get(),false, true);
        }
    }

    @FXML
    public void handleDeleteChara(){
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if(selectedIndex >=0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Character");
            alert.setHeaderText("Are you sure?");
            alert.setContentText("Selected character will be deleted.");

            // Show the alert and wait for the user's response
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                tableView.getItems().remove(selectedIndex);
                mainApp.setFileModified(true);
                String title = mainApp.getStage().getTitle();
                if (!title.endsWith("*")) {
                    mainApp.getStage().setTitle(title + "*");
                }


            }
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
