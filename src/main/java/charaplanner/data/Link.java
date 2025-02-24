package charaplanner.data;

import jakarta.xml.bind.annotation.XmlElement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Link(StringProperty label, StringProperty url) {
    public Link() {
        this(new SimpleStringProperty(""), new SimpleStringProperty(""));
    }

    // DO NOT REMOVE : These Getters & Setters are necessary for JAXB to serialize/unserialize data to/from XML files
    // JAXB needs methods returning simple types, so we provide these

    @XmlElement
    public String getLabel() {
        return label.get();
    }

    public void setLabel(String label) {
        this.label.set(label);
    }

    @XmlElement
    public String getUrl() {
        return url.get();
    }

    public void setUrl(String url) {
        this.url.set(url);
    }


}
