package charaplanner.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Relationships(
        StringProperty sexualOrientation,
        StringProperty romanticOrientation,
        StringProperty familyStatus,
        StringProperty relationshipStatus,
        StringProperty parentA,
        StringProperty parentB,
        StringProperty siblings,
        StringProperty children,
        StringProperty friends,
        StringProperty bestFriend,
        StringProperty significantOther,
        StringProperty rival,
        StringProperty mentor,
        StringProperty apprentice,
        StringProperty enemies,
        StringProperty nemesis,
        StringProperty unclesAunts,
        StringProperty grandParents,
        StringProperty other
) {
    public Relationships() {
        this(
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty("")
        );
    }
}
