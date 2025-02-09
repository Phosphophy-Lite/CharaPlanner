package charaplanner;

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
    private final StringProperty style;
    private final StringProperty accessories;
    private final StringProperty items;
    private final StringProperty weapons;
    private final StringProperty medical;
    private final StringProperty desc;
    private final StringProperty refsheetPath;

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
        this.style = new SimpleStringProperty("");
        this.accessories = new SimpleStringProperty("");
        this.items = new SimpleStringProperty("");
        this.weapons = new SimpleStringProperty("");
        this.medical = new SimpleStringProperty("");
        this.desc = new SimpleStringProperty("");
        this.refsheetPath = new SimpleStringProperty("");

    }

    public String getHair() { return hair.get(); }
    public void setHair(String hair) { this.hair.set(hair); }
    public StringProperty getHairProperty() { return hair; }

    public String getSkin() { return skin.get(); }
    public void setSkin(String skin) { this.skin.set(skin); }
    public StringProperty getSkinProperty() { return skin; }

    public String getEyes() { return eyes.get(); }
    public void setEyes(String eyes) { this.eyes.set(eyes); }
    public StringProperty getEyesProperty() { return eyes; }

    public String getFacialFeatures() { return facialFeatures.get(); }
    public void setFacialFeatures(String facialFeatures) { this.facialFeatures.set(facialFeatures); }
    public StringProperty getFacialFeaturesProperty() { return facialFeatures; }

    public String getHeight() { return height.get(); }
    public void setHeight(String height) { this.height.set(height); }
    public StringProperty getHeightProperty() { return height; }

    public String getWeight() { return weight.get(); }
    public void setWeight(String weight) { this.weight.set(weight); }
    public StringProperty getWeightProperty() { return weight; }

    public String getBuild() { return build.get(); }
    public void setBuild(String build) { this.build.set(build); }
    public StringProperty getBuildProperty() { return build; }

    public String getDistFeatures() { return distFeatures.get(); }
    public void setDistFeatures(String distFeatures) { this.distFeatures.set(distFeatures); }
    public StringProperty getDistFeaturesProperty() { return distFeatures; }

    public String getClothing() { return clothing.get(); }
    public void setClothing(String clothing) { this.clothing.set(clothing); }
    public StringProperty getClothingProperty() { return clothing; }

    public String getStyle() { return style.get(); }
    public void setStyle(String style) { this.style.set(style); }
    public StringProperty getStyleProperty() { return style; }

    public String getAccessories() { return accessories.get(); }
    public void setAccessories(String accessories) { this.accessories.set(accessories); }
    public StringProperty getAccessoriesProperty() { return accessories; }

    public String getItems() { return items.get(); }
    public void setItems(String items) { this.items.set(items); }
    public StringProperty getItemsProperty() { return items; }

    public String getWeapons() { return weapons.get(); }
    public void setWeapons(String weapons) { this.weapons.set(weapons); }
    public StringProperty getWeaponsProperty() { return weapons; }

    public String getMedical() { return medical.get(); }
    public void setMedical(String medical) { this.medical.set(medical); }
    public StringProperty getMedicalProperty() { return medical; }

    public String getDesc() { return desc.get(); }
    public void setDesc(String desc) { this.desc.set(desc); }
    public StringProperty getDescProperty() { return desc; }


    public String getRefsheetPath(){
        return refsheetPath.get();
    }

    public void setRefsheetPath(String profilePicPath){
        this.refsheetPath.set(profilePicPath);
    }

    public StringProperty getRefsheetPathProperty(){
        return refsheetPath;
    }

}
