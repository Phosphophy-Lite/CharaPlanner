package chara.planner.charaplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Personality {
    private final StringProperty traits;
    private final StringProperty skills;
    private final StringProperty strengths;
    private final StringProperty weaknesses;
    private final StringProperty alignment;
    private final StringProperty mbtiEnnea;
    private final StringProperty mentalHealth;
    private final StringProperty fears;
    private final StringProperty hobbies;
    private final StringProperty iq;
    private final StringProperty philosophy;
    private final StringProperty desc;


    public Personality() {
        this.traits = new SimpleStringProperty("");
        this.skills = new SimpleStringProperty("");
        this.strengths = new SimpleStringProperty("");
        this.weaknesses = new SimpleStringProperty("");
        this.alignment = new SimpleStringProperty("");
        this.mbtiEnnea = new SimpleStringProperty("");
        this.mentalHealth = new SimpleStringProperty("");
        this.fears = new SimpleStringProperty("");
        this.hobbies = new SimpleStringProperty("");
        this.iq = new SimpleStringProperty("");
        this.philosophy = new SimpleStringProperty("");
        this.desc = new SimpleStringProperty("");
    }

    public String getTraits() { return traits.get(); }
    public void setTraits(String traits) { this.traits.set(traits); }
    public StringProperty traitsProperty() { return traits; }

    public String getSkills() { return skills.get(); }
    public void setSkills(String skills) { this.skills.set(skills); }
    public StringProperty skillsProperty() { return skills; }

    public String getStrengths() { return strengths.get(); }
    public void setStrengths(String strengths) { this.strengths.set(strengths); }
    public StringProperty strengthsProperty() { return strengths; }

    public String getWeaknesses() { return weaknesses.get(); }
    public void setWeaknesses(String weaknesses) { this.weaknesses.set(weaknesses); }
    public StringProperty weaknessesProperty() { return weaknesses; }

    public String getAlignment() { return alignment.get(); }
    public void setAlignment(String alignment) { this.alignment.set(alignment); }
    public StringProperty alignmentProperty() { return alignment; }

    public String getMbtiEnnea() { return mbtiEnnea.get(); }
    public void setMbtiEnnea(String mbtiEnnea) { this.mbtiEnnea.set(mbtiEnnea); }
    public StringProperty mbtiEnneaProperty() { return mbtiEnnea; }

    public String getMentalHealth() { return mentalHealth.get(); }
    public void setMentalHealth(String mentalHealth) { this.mentalHealth.set(mentalHealth); }
    public StringProperty mentalHealthProperty() { return mentalHealth; }

    public String getFears() { return fears.get(); }
    public void setFears(String fears) { this.fears.set(fears); }
    public StringProperty fearsProperty() { return fears; }

    public String getHobbies() { return hobbies.get(); }
    public void setHobbies(String hobbies) { this.hobbies.set(hobbies); }
    public StringProperty hobbiesProperty() { return hobbies; }

    public String getIq() { return iq.get(); }
    public void setIq(String iq) { this.iq.set(iq); }
    public StringProperty iqProperty() { return iq; }

    public String getPhilosophy() { return philosophy.get(); }
    public void setPhilosophy(String philosophy) { this.philosophy.set(philosophy); }
    public StringProperty philosophyProperty() { return philosophy; }

    public String getDesc() { return desc.get(); }
    public void setDesc(String desc) { this.desc.set(desc); }
    public StringProperty descProperty() { return desc; }

}