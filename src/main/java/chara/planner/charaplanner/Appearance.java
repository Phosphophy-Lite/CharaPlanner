package chara.planner.charaplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Appearance {
    private final StringProperty hair;
    private final StringProperty skin;
    private final StringProperty eyes; //String and not LocalDate object because depending on the user's universe, it might not be a usual date format
    private final StringProperty facialFeatures;
    private final StringProperty height; //String and not integer depending on the user's desired metric/unknown age
    private final StringProperty weight;
    private final StringProperty build;
    private final StringProperty distFeatures;
    private final StringProperty clothing;
    private final StringProperty aesthetic;
    private final StringProperty accessories;
    private final StringProperty items;
    private final StringProperty weapons;
    private final StringProperty medical;
    private final StringProperty desc;

    public Appearance() {
        this.hair = new SimpleStringProperty("");
        this.skin = new SimpleStringProperty("");
        this.eyes = new SimpleStringProperty("");
        this.facialFeatures = new SimpleStringProperty("");
        this.height = new SimpleStringProperty("");
        this.weight = new SimpleStringProperty("");
        this.build = new SimpleStringProperty("");

        this.distFeatures = new SimpleStringProperty("");
        this.clothing = new SimpleStringProperty("");
        this.aesthetic = new SimpleStringProperty("");
        this.accessories = new SimpleStringProperty("");
        this.items = new SimpleStringProperty("");
        this.weapons = new SimpleStringProperty("");
        this.medical = new SimpleStringProperty("");
        this.desc = new SimpleStringProperty("");
    }

    public String getHair() { return hair.get(); }
    public void setHair(String hair) { this.hair.set(hair); }
    public StringProperty hairProperty() { return hair; }

    public String getSkin() { return skin.get(); }
    public void setSkin(String skin) { this.skin.set(skin); }
    public StringProperty skinProperty() { return skin; }

    public String getEyes() { return eyes.get(); }
    public void setEyes(String eyes) { this.eyes.set(eyes); }
    public StringProperty eyesProperty() { return eyes; }

    public String getFacialFeatures() { return facialFeatures.get(); }
    public void setFacialFeatures(String facialFeatures) { this.facialFeatures.set(facialFeatures); }
    public StringProperty facialFeaturesProperty() { return facialFeatures; }

    public String getHeight() { return height.get(); }
    public void setHeight(String height) { this.height.set(height); }
    public StringProperty heightProperty() { return height; }

    public String getWeight() { return weight.get(); }
    public void setWeight(String weight) { this.weight.set(weight); }
    public StringProperty weightProperty() { return weight; }

    public String getBuild() { return build.get(); }
    public void setBuild(String build) { this.build.set(build); }
    public StringProperty buildProperty() { return build; }

    public String getDistFeatures() { return distFeatures.get(); }
    public void setDistFeatures(String distFeatures) { this.distFeatures.set(distFeatures); }
    public StringProperty distFeaturesProperty() { return distFeatures; }

    public String getClothing() { return clothing.get(); }
    public void setClothing(String clothing) { this.clothing.set(clothing); }
    public StringProperty clothingProperty() { return clothing; }

    public String getAesthetic() { return aesthetic.get(); }
    public void setAesthetic(String aesthetic) { this.aesthetic.set(aesthetic); }
    public StringProperty aestheticProperty() { return aesthetic; }

    public String getAccessories() { return accessories.get(); }
    public void setAccessories(String accessories) { this.accessories.set(accessories); }
    public StringProperty accessoriesProperty() { return accessories; }

    public String getItems() { return items.get(); }
    public void setItems(String items) { this.items.set(items); }
    public StringProperty itemsProperty() { return items; }

    public String getWeapons() { return weapons.get(); }
    public void setWeapons(String weapons) { this.weapons.set(weapons); }
    public StringProperty weaponsProperty() { return weapons; }

    public String getMedical() { return medical.get(); }
    public void setMedical(String medical) { this.medical.set(medical); }
    public StringProperty medicalProperty() { return medical; }

    public String getDesc() { return desc.get(); }
    public void setDesc(String desc) { this.desc.set(desc); }
    public StringProperty descProperty() { return desc; }
}
