package charaplanner.data;

import jakarta.xml.bind.annotation.XmlElement;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;

public record Stats(
        IntegerProperty physicalStrength,
        IntegerProperty mindStrength,
        IntegerProperty perception,
        IntegerProperty speed,
        IntegerProperty dexterity,
        IntegerProperty combat,
        IntegerProperty persuasion,
        IntegerProperty charisma,
        IntegerProperty health,
        IntegerProperty socialSkills,
        IntegerProperty bravery,
        IntegerProperty intelligence,
        IntegerProperty confidence,
        IntegerProperty selfEsteem,
        IntegerProperty views,
        IntegerProperty humor,
        IntegerProperty wisdom,
        IntegerProperty empathy,
        IntegerProperty sensitivity,
        IntegerProperty creativity
) {
    public Stats() {
        this(
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5)
        );
    }

    // DO NOT REMOVE : These Getters & Setters are necessary for JAXB to serialize/unserialize data to/from XML files
    // JAXB needs methods returning simple types, so we provide these

    @XmlElement
    public int getPhysicalStrength() {
        return physicalStrength.get();
    }

    public void setPhysicalStrength(int physicalStrength) {
        this.physicalStrength.set(physicalStrength);
    }

    @XmlElement
    public int getMindStrength() {
        return mindStrength.get();
    }

    public void setMindStrength(int mindStrength) {
        this.mindStrength.set(mindStrength);
    }

    @XmlElement
    public int getPerception() {
        return perception.get();
    }

    public void setPerception(int perception) {
        this.perception.set(perception);
    }

    @XmlElement
    public int getSpeed() {
        return speed.get();
    }

    public void setSpeed(int speed) {
        this.speed.set(speed);
    }

    @XmlElement
    public int getDexterity() {
        return dexterity.get();
    }

    public void setDexterity(int dexterity) {
        this.dexterity.set(dexterity);
    }

    @XmlElement
    public int getCombat() {
        return combat.get();
    }

    public void setCombat(int combat) {
        this.combat.set(combat);
    }

    @XmlElement
    public int getPersuasion() {
        return persuasion.get();
    }

    public void setPersuasion(int persuasion) {
        this.persuasion.set(persuasion);
    }

    @XmlElement
    public int getCharisma() {
        return charisma.get();
    }

    public void setCharisma(int charisma) {
        this.charisma.set(charisma);
    }

    @XmlElement
    public int getHealth() {
        return health.get();
    }

    public void setHealth(int health) {
        this.health.set(health);
    }

    @XmlElement
    public int getSocialSkills() {
        return socialSkills.get();
    }

    public void setSocialSkills(int socialSkills) {
        this.socialSkills.set(socialSkills);
    }

    @XmlElement
    public int getBravery() {
        return bravery.get();
    }

    public void setBravery(int bravery) {
        this.bravery.set(bravery);
    }

    @XmlElement
    public int getIntelligence() {
        return intelligence.get();
    }

    public void setIntelligence(int intelligence) {
        this.intelligence.set(intelligence);
    }

    @XmlElement
    public int getConfidence() {
        return confidence.get();
    }

    public void setConfidence(int confidence) {
        this.confidence.set(confidence);
    }

    @XmlElement
    public int getSelfEsteem() {
        return selfEsteem.get();
    }

    public void setSelfEsteem(int selfEsteem) {
        this.selfEsteem.set(selfEsteem);
    }

    @XmlElement
    public int getViews() {
        return views.get();
    }

    public void setViews(int views) {
        this.views.set(views);
    }

    @XmlElement
    public int getHumor() {
        return humor.get();
    }

    public void setHumor(int humor) {
        this.humor.set(humor);
    }

    @XmlElement
    public int getWisdom() {
        return wisdom.get();
    }

    public void setWisdom(int wisdom) {
        this.wisdom.set(wisdom);
    }

    @XmlElement
    public int getEmpathy() {
        return empathy.get();
    }

    public void setEmpathy(int empathy) {
        this.empathy.set(empathy);
    }

    @XmlElement
    public int getSensitivity() {
        return sensitivity.get();
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity.set(sensitivity);
    }

    @XmlElement
    public int getCreativity() {
        return creativity.get();
    }

    public void setCreativity(int creativity) {
        this.creativity.set(creativity);
    }

}