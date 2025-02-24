package charaplanner.data;

import jakarta.xml.bind.annotation.XmlElement;
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

    // DO NOT REMOVE : These Getters & Setters are necessary for JAXB to serialize/unserialize data to/from XML files
    // JAXB needs methods returning simple types, so we provide these

    @XmlElement
    public String getTraits() {
        return traits.get();
    }

    public void setTraits(String traits) {
        this.traits.set(traits);
    }

    @XmlElement
    public String getSkills() {
        return skills.get();
    }

    public void setSkills(String skills) {
        this.skills.set(skills);
    }

    @XmlElement
    public String getStrengths() {
        return strengths.get();
    }

    public void setStrengths(String strengths) {
        this.strengths.set(strengths);
    }

    @XmlElement
    public String getWeaknesses() {
        return weaknesses.get();
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses.set(weaknesses);
    }

    @XmlElement
    public String getAlignment() {
        return alignment.get();
    }

    public void setAlignment(String alignment) {
        this.alignment.set(alignment);
    }

    @XmlElement
    public String getMbtiEnnea() {
        return mbtiEnnea.get();
    }

    public void setMbtiEnnea(String mbtiEnnea) {
        this.mbtiEnnea.set(mbtiEnnea);
    }

    @XmlElement
    public String getMentalHealth() {
        return mentalHealth.get();
    }

    public void setMentalHealth(String mentalHealth) {
        this.mentalHealth.set(mentalHealth);
    }

    @XmlElement
    public String getFears() {
        return fears.get();
    }

    public void setFears(String fears) {
        this.fears.set(fears);
    }

    @XmlElement
    public String getHobbies() {
        return hobbies.get();
    }

    public void setHobbies(String hobbies) {
        this.hobbies.set(hobbies);
    }

    @XmlElement
    public String getIq() {
        return iq.get();
    }

    public void setIq(String iq) {
        this.iq.set(iq);
    }

    @XmlElement
    public String getPhilosophy() {
        return philosophy.get();
    }

    public void setPhilosophy(String philosophy) {
        this.philosophy.set(philosophy);
    }

    @XmlElement
    public String getDesc() {
        return desc.get();
    }

    public void setDesc(String desc) {
        this.desc.set(desc);
    }

}