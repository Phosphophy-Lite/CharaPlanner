package charaplanner.data;

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
    private final ObjectProperty<Relationships> relationships;
    private final ObjectProperty<Trivia> trivia;
    private final ObjectProperty<Stats> stats;
    private final StringProperty profilePicPath;
    private final StringProperty associatedColor;
    private final StringProperty quote;
    private final ObjectProperty<Link> link1;
    private final ObjectProperty<Link> link2;
    private final ObjectProperty<Link> link3;

    public Character() {
        this(null, null, null, null, null, null, null, null, null);
    }

    //With arguments for testing purposes
    public Character(String displayName, String firstName, String lastName, String birthDate, String gender, String age, String job, String jobPosition, String profilePicPath) {
        this.displayName = new SimpleStringProperty(displayName);
        this.basicInfos = new SimpleObjectProperty<>(new BasicInfos(firstName, lastName, birthDate, gender, age, job, jobPosition));
        this.appearance = new SimpleObjectProperty<>(new Appearance());
        this.personality = new SimpleObjectProperty<>(new Personality());
        this.story = new SimpleObjectProperty<>(new Story());
        this.relationships = new SimpleObjectProperty<>(new Relationships());
        this.trivia = new SimpleObjectProperty<>(new Trivia());
        this.stats = new SimpleObjectProperty<>(new Stats());
        this.profilePicPath = new SimpleStringProperty(profilePicPath);
        this.associatedColor = new SimpleStringProperty("#FFFFFF");
        this.quote = new SimpleStringProperty("");
        this.link1 = new SimpleObjectProperty<>(new Link());
        this.link2 = new SimpleObjectProperty<>(new Link());
        this.link3 = new SimpleObjectProperty<>(new Link());
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

    public Relationships getRelationships() {
        return relationships.get();
    }

    public void setRelationships(Relationships relationships) {
        this.relationships.set(relationships);
    }

    public ObjectProperty<Relationships> getRelationshipsProperty() {
        return relationships;
    }

    public Trivia getTrivia() {
        return trivia.get();
    }

    public void setTrivia(Trivia trivia) {
        this.trivia.set(trivia);
    }

    public ObjectProperty<Trivia> getTriviaProperty() {
        return trivia;
    }

    public Stats getStats() {
        return stats.get();
    }

    public void setStats(Stats stats) {
        this.stats.set(stats);
    }

    public ObjectProperty<Stats> getStatsProperty() {
        return stats;
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

    public String getAssociatedColor(){
        return associatedColor.get();
    }

    public StringProperty getAssociatedColorProperty(){
        return associatedColor;
    }

    public void setAssociatedColor(String associatedColor){
        this.associatedColor.set(associatedColor);
    }

    public String getQuote(){
        return quote.get();
    }

    public StringProperty getQuoteProperty(){
        return quote;
    }

    public void setQuote(String quote){
        this.quote.set(quote);
    }

    public Link getLink1() {
        return link1.get();
    }

    public ObjectProperty<Link> getLink1Property() {
        return link1;
    }

    public void setLink1(Link link) {
        this.link1.set(link);
    }

    public Link getLink2() {
        return link2.get();
    }

    public ObjectProperty<Link> getLink2Property() {
        return link2;
    }

    public void setLink2(Link link) {
        this.link2.set(link);
    }

    public Link getLink3() {
        return link3.get();
    }

    public ObjectProperty<Link> getLink3Property() {
        return link3;
    }

    public void setLink3(Link link) {
        this.link3.set(link);
    }

}
