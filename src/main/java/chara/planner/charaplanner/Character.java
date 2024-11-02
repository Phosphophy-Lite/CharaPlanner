package chara.planner.charaplanner;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Character {
    private final StringProperty displayName;
    private final ObjectProperty<BasicInfos> basicInfos;
    private final ObjectProperty<Appearance> appearance;
    private final ObjectProperty<Personality> personality;
    private final ObjectProperty<Story> story;
    private final StringProperty profilePicPath;

    public Character() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public Character(String displayName, String firstName, String lastName, String birthDate, String gender, String age, String job, String jobPosition, String profilePicPath) {
        this.displayName = new SimpleStringProperty(displayName);
        this.basicInfos = new SimpleObjectProperty<BasicInfos>(new BasicInfos(firstName, lastName, birthDate, gender, age, job, jobPosition));
        this.appearance = new SimpleObjectProperty<Appearance>(new Appearance());
        this.personality = new SimpleObjectProperty<Personality>(new Personality());
        this.story = new SimpleObjectProperty<Story>(new Story());
        this.profilePicPath = new SimpleStringProperty(profilePicPath);
    }

    public String getDisplayName() {
        return displayName.get();
    }

    public void setDisplayName(String dN){
        this.displayName.set(dN);
    }

    public StringProperty getDisplayNameProperty(){
        return displayName;
    }

    public ObjectProperty<BasicInfos> getBasicInfosProperty() {
        return basicInfos;
    }

    public BasicInfos getBasicInfos() {
        return basicInfos.get();
    }

    public void setBasicInfos(BasicInfos basicInfos) {
        this.basicInfos.set(basicInfos);
    }

    public Appearance getAppearance() {
        return appearance.get();
    }

    public void setAppearance(Appearance appearance) {
        this.appearance.set(appearance);
    }

    public ObjectProperty<Appearance> getAppearanceProperty() {
        return appearance;
    }

    public Personality getPersonality() {
        return personality.get();
    }

    public void setPersonality(Personality personality) {
        this.personality.set(personality);
    }

    public ObjectProperty<Personality> getPersonalityProperty() {
        return personality;
    }

    public Story getStory() {
        return story.get();
    }

    public void setStory(Story story) {
        this.story.set(story);
    }

    public ObjectProperty<Story> getStoryProperty() {
        return story;
    }

    public String getProfilePicPath(){
        return profilePicPath.get();
    }

    public void setProfilePicPath(String profilePicPath){
        this.profilePicPath.set(profilePicPath);
    }

    public StringProperty getProfilePicPathProperty(){
        return profilePicPath;
    }


}
