package charaplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Trivia(
        StringProperty nativeLanguages,
        StringProperty learntLanguages,
        StringProperty speech,
        StringProperty voiceclaim,
        StringProperty themeSongs,
        StringProperty animal,
        StringProperty plant,
        StringProperty gemstone,
        StringProperty season,
        StringProperty place,
        StringProperty food,
        StringProperty drink,
        StringProperty aesthetic,
        StringProperty likes,
        StringProperty dislikes
) {
    public Trivia() {
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
                new SimpleStringProperty("")
        );
    }
}
