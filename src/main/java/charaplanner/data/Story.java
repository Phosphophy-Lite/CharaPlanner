package charaplanner.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Story(
        StringProperty plotRole,
        StringProperty backstory,
        StringProperty goals,
        StringProperty achievements,
        StringProperty failures,
        StringProperty traumas,
        StringProperty crimes,
        StringProperty secrets,
        StringProperty powers,
        StringProperty education,
        StringProperty expertise,
        StringProperty socialStatus,
        StringProperty wealth
) {
    public Story() {
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
                new SimpleStringProperty("")
        );
    }
}