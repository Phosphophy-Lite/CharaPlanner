package charaplanner.data;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
}