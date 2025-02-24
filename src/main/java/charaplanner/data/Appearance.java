package charaplanner.data;

import jakarta.xml.bind.annotation.XmlElement;
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

    // DO NOT REMOVE : These Getters & Setters are necessary for JAXB to serialize/unserialize data to/from XML files
    // JAXB needs methods returning simple types, so we provide these

    @XmlElement
    public String getHair() {
        return hair.get();
    }

    @XmlElement
    public String getSkin() {
        return skin.get();
    }

    @XmlElement
    public String getEyes() {
        return eyes.get();
    }

    @XmlElement
    public String getFacialFeatures() {
        return facialFeatures.get();
    }

    @XmlElement
    public String getHeight() {
        return height.get();
    }

    @XmlElement
    public String getWeight() {
        return weight.get();
    }

    @XmlElement
    public String getBuild() {
        return build.get();
    }

    @XmlElement
    public String getDistFeatures() {
        return distFeatures.get();
    }

    @XmlElement
    public String getClothing() {
        return clothing.get();
    }

    @XmlElement
    public String getStyle() {
        return style.get();
    }

    @XmlElement
    public String getAccessories() {
        return accessories.get();
    }

    @XmlElement
    public String getItems() {
        return items.get();
    }

    @XmlElement
    public String getWeapons() {
        return weapons.get();
    }

    @XmlElement
    public String getMedical() {
        return medical.get();
    }

    @XmlElement
    public String getDesc() {
        return desc.get();
    }

    @XmlElement
    public String getRefsheetPath() {
        return refsheetPath.get();
    }

    // Do not remove setters, JAXB Unmarshaller needs them to unserialize xml data

    public void setHair(String hair) {
        this.hair.set(hair);
    }

    public void setSkin(String skin) {
        this.skin.set(skin);
    }

    public void setEyes(String eyes) {
        this.eyes.set(eyes);
    }

    public void setFacialFeatures(String facialFeatures) {
        this.facialFeatures.set(facialFeatures);
    }

    public void setHeight(String height) {
        this.height.set(height);
    }

    public void setWeight(String weight) {
        this.weight.set(weight);
    }

    public void setBuild(String build) {
        this.build.set(build);
    }

    public void setDistFeatures(String distFeatures) {
        this.distFeatures.set(distFeatures);
    }

    public void setClothing(String clothing) {
        this.clothing.set(clothing);
    }

    public void setStyle(String style) {
        this.style.set(style);
    }

    public void setAccessories(String accessories) {
        this.accessories.set(accessories);
    }

    public void setItems(String items) {
        this.items.set(items);
    }

    public void setWeapons(String weapons) {
        this.weapons.set(weapons);
    }

    public void setMedical(String medical) {
        this.medical.set(medical);
    }

    public void setDesc(String desc) {
        this.desc.set(desc);
    }

    public void setRefsheetPath(String refsheetPath) {
        this.refsheetPath.set(refsheetPath);
    }
}