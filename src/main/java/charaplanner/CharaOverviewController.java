package charaplanner;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Optional;

import java.net.URL;

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
    @FXML private Label aestheticLabel;
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
    @FXML private TableView<Character> tableView;
    @FXML private TableColumn<Character, String> nameColumn;

    /* Right pane for more infos */
    @FXML private Label nameRightLabel;
    @FXML private ImageView profilePicImageView;
    @FXML private ColorPicker colorPicker;
    @FXML private Label quoteLabel;
    @FXML private Hyperlink link1;
    @FXML private Hyperlink link2;
    @FXML private Hyperlink link3;


    private MainApp mainApp;

    public CharaOverviewController() {

    }

    @FXML
    private void initialize(){
        //initialize everything empty/default settings
        setStatSlidersLabels();
        showCharaDetails(null);

        //Styling profilePic image view by clipping to a rounded rectangle
        clipImgToRectangle(profilePicImageView, profilePicImageView.getFitWidth(), profilePicImageView.getFitHeight());
        clipImgToRectangle(refsheetImageView, refsheetImageView.getFitWidth(), refsheetImageView.getFitHeight());

        nameColumn.setCellValueFactory(data -> data.getValue().getDisplayNameProperty());
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue,newValue) -> showCharaDetails(newValue));

        //Creates a custom TableRow object for each row in the TableView to specify each row's behavior
        tableView.setRowFactory(tv -> {
            TableRow<Character> row = new TableRow<>();

            //Attach a ContextMenu to the row
            ContextMenu rowMenu = new ContextMenu();
            MenuItem deleteItem = new MenuItem("Delete");
            MenuItem editItem = new MenuItem("Edit");

            //Specify action of Delete item (remove character from the Table)
            deleteItem.setOnAction(event -> {
                Character selectedCharacter = row.getItem(); //acts on the right-clicked row, not dependent on selection in the table
                if(selectedCharacter != null) {
                    handleDeleteChara();
                }
            });

            //Specify action of Delete item (remove character from the Table)
            editItem.setOnAction(event -> {
                Character selectedCharacter = row.getItem(); //acts on the right-clicked row, not dependent on selection in the table
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

            double viewportWidth, viewportHeight;
            double x, y;

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
        parentALabel.setText("");
        parentBLabel.setText("");
        siblingsLabel.setText("");
        bestFriendLabel.setText("");
        significantOtherLabel.setText("");
        rivalLabel.setText("");
        mentorLabel.setText("");
        apprenticeLabel.setText("");
        nemesisLabel.setText("");

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

        link1.setText("");
        link2.setText("");
        link3.setText("");
    }

    private void setStatSlidersLabels(){
        physicalStrengthSlider.setCustomLabels("Weak", "Average", "Strong");
        mindStrengthSlider.setCustomLabels("Vulnerable", "Average", "Resilient");
        perceptionSlider.setCustomLabels("Oblivious", "Average", "Attentive");
        speedSlider.setCustomLabels("Slow", "Average", "Fast");
        dexteritySlider.setCustomLabels("Clumsy", "Average", "Handy");
        combatSlider.setCustomLabels("Can't fight", "Average", "Warrior");
        persuasionSlider.setCustomLabels("Unpersuasive", "Moderate", "Influential");
        charismaSlider.setCustomLabels("Low", "Lambda", "High");
        healthSlider.setCustomLabels("Very Bad", "Average", "Very Healthy");
        socialSkillsSlider.setCustomLabels("Very Awkward", "Balanced", "Social Butterfly");
        braverySlider.setCustomLabels("Coward", "Balanced", "Audacious");
        intelligenceSlider.setCustomLabels("Low", "Average", "Genius");
        confidenceSlider.setCustomLabels("Insecure", "Balanced", "Arrogant");
        selfEsteemSlider.setCustomLabels("Low", "Balanced", "High");
        viewsSlider.setCustomLabels("Idealistic", "Balanced", "Pragmatic");
        humorSlider.setCustomLabels("Serious", "Occasional", "Comedian");
        wisdomSlider.setCustomLabels("Foolish", "Average", "Very Wise");
        empathySlider.setCustomLabels("None", "Average", "Empath");
        sensitivitySlider.setCustomLabels("Insensitive", "Average", "Hypersensitive");
        creativitySlider.setCustomLabels("Low", "Average", "High");
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
            String charaLinkLabel = charaLink.getLinkLabel();
            String charaLinkUrl = charaLink.getLinkUrl();
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

        //fill non blank fields of character
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
                setImageView(refsheetImageView, chara.getAppearance().getRefsheetPath(),false, false);
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
                parentALabel.setText(chara.getRelationships().getParentA());
                parentBLabel.setText(chara.getRelationships().getParentB());
                siblingsLabel.setText(chara.getRelationships().getSiblings());
                bestFriendLabel.setText(chara.getRelationships().getBestFriend());
                significantOtherLabel.setText(chara.getRelationships().getSignificantOther());
                rivalLabel.setText(chara.getRelationships().getRival());
                mentorLabel.setText(chara.getRelationships().getMentor());
                apprenticeLabel.setText(chara.getRelationships().getApprentice());
                nemesisLabel.setText(chara.getRelationships().getNemesis());
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
            if(chara.getStats() != null){
                physicalStrengthSlider.setValue(chara.getStats().getPhysicalStrength());
                mindStrengthSlider.setValue(chara.getStats().getMindStrength());
                perceptionSlider.setValue(chara.getStats().getPerception());
                speedSlider.setValue(chara.getStats().getSpeed());
                dexteritySlider.setValue(chara.getStats().getDexterity());
                combatSlider.setValue(chara.getStats().getCombat());
                persuasionSlider.setValue(chara.getStats().getPersuasion());
                charismaSlider.setValue(chara.getStats().getCharisma());
                healthSlider.setValue(chara.getStats().getHealth());
                socialSkillsSlider.setValue(chara.getStats().getSocialSkills());
                braverySlider.setValue(chara.getStats().getBravery());
                intelligenceSlider.setValue(chara.getStats().getIntelligence());
                confidenceSlider.setValue(chara.getStats().getConfidence());
                selfEsteemSlider.setValue(chara.getStats().getSelfEsteem());
                viewsSlider.setValue(chara.getStats().getViews());
                humorSlider.setValue(chara.getStats().getHumor());
                wisdomSlider.setValue(chara.getStats().getWisdom());
                empathySlider.setValue(chara.getStats().getEmpathy());
                sensitivitySlider.setValue(chara.getStats().getSensitivity());
                creativitySlider.setValue(chara.getStats().getCreativity());
            }

            nameRightLabel.setText(chara.getDisplayName());
            quoteLabel.setText(chara.getQuote());
            Color associatedColor = Color.web(chara.getAssociatedColor());
            colorPicker.setValue(associatedColor);
            setLink(link1, chara.getLink1());
            setLink(link2, chara.getLink2());
            setLink(link3, chara.getLink3());

            setImageView(profilePicImageView, chara.getProfilePicPath(),false, true);
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
                mainApp.fileIsModified = true;
                String title = mainApp.getStage().getTitle();
                if(!title.endsWith("*")){
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
