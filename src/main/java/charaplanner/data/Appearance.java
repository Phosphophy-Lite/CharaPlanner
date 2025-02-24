package charaplanner.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Appearance(
        StringProperty hair,
        StringProperty skin,
        StringProperty eyes,
        StringProperty facialFeatures,
        StringProperty height,
        StringProperty weight,
        StringProperty build,
        StringProperty distFeatures,
        StringProperty clothing,
        StringProperty style,
        StringProperty accessories,
        StringProperty items,
        StringProperty weapons,
        StringProperty medical,
        StringProperty desc,
        StringProperty refsheetPath
) {
    public Appearance() {
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
                new SimpleStringProperty("")
        );
    }
}