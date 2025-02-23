package charaplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Link(StringProperty label, StringProperty url) {
    public Link() {
        this(new SimpleStringProperty(""), new SimpleStringProperty(""));
    }
}
