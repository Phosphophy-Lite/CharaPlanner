package charaplanner.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Personality(
        StringProperty traits,
        StringProperty skills,
        StringProperty strengths,
        StringProperty weaknesses,
        StringProperty alignment,
        StringProperty mbtiEnnea,
        StringProperty mentalHealth,
        StringProperty fears,
        StringProperty hobbies,
        StringProperty iq,
        StringProperty philosophy,
        StringProperty desc
) {
    public Personality() {
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
                new SimpleStringProperty("")
        );
    }
}