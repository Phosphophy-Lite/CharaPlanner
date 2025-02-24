package charaplanner.data;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@XmlRootElement
public record Character(
        StringProperty displayName,
        ObjectProperty<BasicInfos> basicInfos,
        ObjectProperty<Appearance> appearance,
        ObjectProperty<Personality> personality,
        ObjectProperty<Story> story,
        ObjectProperty<Relationships> relationships,
        ObjectProperty<Trivia> trivia,
        ObjectProperty<Stats> stats,
        StringProperty profilePicPath,
        StringProperty associatedColor,
        StringProperty quote,
        ObjectProperty<Link> link1,
        ObjectProperty<Link> link2,
        ObjectProperty<Link> link3
) {
    public Character() {
        this(
                new SimpleStringProperty(""),
                new SimpleObjectProperty<>(new BasicInfos()),
                new SimpleObjectProperty<>(new Appearance()),
                new SimpleObjectProperty<>(new Personality()),
                new SimpleObjectProperty<>(new Story()),
                new SimpleObjectProperty<>(new Relationships()),
                new SimpleObjectProperty<>(new Trivia()),
                new SimpleObjectProperty<>(new Stats()),
                new SimpleStringProperty(""),
                new SimpleStringProperty("#FFFFFF"),
                new SimpleStringProperty(""),
                new SimpleObjectProperty<>(new Link()),
                new SimpleObjectProperty<>(new Link()),
                new SimpleObjectProperty<>(new Link())
        );
    }

    // With arguments for testing purposes
    public Character(String displayName, String firstName, String lastName, String birthDate, String gender, String age, String job, String jobPosition, String profilePicPath) {
        this(
                new SimpleStringProperty(displayName),
                new SimpleObjectProperty<>(new BasicInfos(firstName, lastName, birthDate, gender, age, job, jobPosition)),
                new SimpleObjectProperty<>(new Appearance()),
                new SimpleObjectProperty<>(new Personality()),
                new SimpleObjectProperty<>(new Story()),
                new SimpleObjectProperty<>(new Relationships()),
                new SimpleObjectProperty<>(new Trivia()),
                new SimpleObjectProperty<>(new Stats()),
                new SimpleStringProperty(profilePicPath),
                new SimpleStringProperty("#FFFFFF"),
                new SimpleStringProperty(""),
                new SimpleObjectProperty<>(new Link()),
                new SimpleObjectProperty<>(new Link()),
                new SimpleObjectProperty<>(new Link())
        );
    }

    // DO NOT REMOVE : These Getters & Setters are necessary for JAXB to serialize/unserialize data to/from XML files
    // JAXB needs methods returning simple types, so we provide these

    @XmlElement
    public String getDisplayName() {
        return displayName.get();
    }

    public void setDisplayName(String displayName) {
        this.displayName.set(displayName);
    }

    @XmlElement
    public BasicInfos getBasicInfos() {
        return basicInfos.get();
    }

    public void setBasicInfos(BasicInfos basicInfos) {
        this.basicInfos.set(basicInfos);
    }

    @XmlElement
    public Appearance getAppearance() {
        return appearance.get();
    }

    public void setAppearance(Appearance appearance) {
        this.appearance.set(appearance);
    }

    @XmlElement
    public Personality getPersonality() {
        return personality.get();
    }

    public void setPersonality(Personality personality) {
        this.personality.set(personality);
    }

    @XmlElement
    public Story getStory() {
        return story.get();
    }

    public void setStory(Story story) {
        this.story.set(story);
    }

    @XmlElement
    public Relationships getRelationships() {
        return relationships.get();
    }

    public void setRelationships(Relationships relationships) {
        this.relationships.set(relationships);
    }

    @XmlElement
    public Trivia getTrivia() {
        return trivia.get();
    }

    public void setTrivia(Trivia trivia) {
        this.trivia.set(trivia);
    }

    @XmlElement
    public Stats getStats() {
        return stats.get();
    }

    public void setStats(Stats stats) {
        this.stats.set(stats);
    }

    @XmlElement
    public String getProfilePicPath() {
        return profilePicPath.get();
    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath.set(profilePicPath);
    }

    @XmlElement
    public String getAssociatedColor() {
        return associatedColor.get();
    }

    public void setAssociatedColor(String associatedColor) {
        this.associatedColor.set(associatedColor);
    }

    @XmlElement
    public String getQuote() {
        return quote.get();
    }

    public void setQuote(String quote) {
        this.quote.set(quote);
    }

    @XmlElement
    public Link getLink1() {
        return link1.get();
    }

    public void setLink1(Link link1) {
        this.link1.set(link1);
    }

    @XmlElement
    public Link getLink2() {
        return link2.get();
    }

    public void setLink2(Link link2) {
        this.link2.set(link2);
    }

    @XmlElement
    public Link getLink3() {
        return link3.get();
    }

    public void setLink3(Link link3) {
        this.link3.set(link3);
    }

}