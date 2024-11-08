package chara.planner.charaplanner;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Stats {
    private final IntegerProperty physicalStrength;
    private final IntegerProperty mindStrength;
    private final IntegerProperty perception;
    private final IntegerProperty speed;
    private final IntegerProperty dexterity;
    private final IntegerProperty combat;
    private final IntegerProperty persuasion;
    private final IntegerProperty charisma;
    private final IntegerProperty health;
    private final IntegerProperty socialSkills;
    private final IntegerProperty bravery;
    private final IntegerProperty intelligence;
    private final IntegerProperty confidence;
    private final IntegerProperty selfEsteem;
    private final IntegerProperty views;
    private final IntegerProperty humor;
    private final IntegerProperty wisdom;
    private final IntegerProperty empathy;
    private final IntegerProperty sensitivity;
    private final IntegerProperty creativity;

    public Stats() {
        this.physicalStrength = new SimpleIntegerProperty(5);
        this.mindStrength = new SimpleIntegerProperty(5);
        this.perception = new SimpleIntegerProperty(5);
        this.speed = new SimpleIntegerProperty(5);
        this.dexterity = new SimpleIntegerProperty(5);
        this.combat = new SimpleIntegerProperty(5);
        this.persuasion = new SimpleIntegerProperty(5);
        this.charisma = new SimpleIntegerProperty(5);
        this.health = new SimpleIntegerProperty(5);
        this.socialSkills = new SimpleIntegerProperty(5);
        this.bravery = new SimpleIntegerProperty(5);
        this.intelligence = new SimpleIntegerProperty(5);
        this.confidence = new SimpleIntegerProperty(5);
        this.selfEsteem = new SimpleIntegerProperty(5);
        this.views = new SimpleIntegerProperty(5);
        this.humor = new SimpleIntegerProperty(5);
        this.wisdom = new SimpleIntegerProperty(5);
        this.empathy = new SimpleIntegerProperty(5);
        this.sensitivity = new SimpleIntegerProperty(5);
        this.creativity = new SimpleIntegerProperty(5);
    }

    public int getPhysicalStrength() { return physicalStrength.get(); }
    public void setPhysicalStrength(int physicalStrength) { this.physicalStrength.set(physicalStrength); }
    public IntegerProperty physicalStrengthProperty() { return physicalStrength; }

    public int getMindStrength() { return mindStrength.get(); }
    public void setMindStrength(int mindStrength) { this.mindStrength.set(mindStrength); }
    public IntegerProperty mindStrengthProperty() { return mindStrength; }

    public int getPerception() { return perception.get(); }
    public void setPerception(int perception) { this.perception.set(perception); }
    public IntegerProperty perceptionProperty() { return perception; }

    public int getSpeed() { return speed.get(); }
    public void setSpeed(int speed) { this.speed.set(speed); }
    public IntegerProperty speedProperty() { return speed; }

    public int getDexterity() { return dexterity.get(); }
    public void setDexterity(int dexterity) { this.dexterity.set(dexterity); }
    public IntegerProperty dexterityProperty() { return dexterity; }

    public int getCombat() { return combat.get(); }
    public void setCombat(int combat) { this.combat.set(combat); }
    public IntegerProperty combatProperty() { return combat; }

    public int getPersuasion() { return persuasion.get(); }
    public void setPersuasion(int persuasion) { this.persuasion.set(persuasion); }
    public IntegerProperty persuasionProperty() { return persuasion; }

    public int getCharisma() { return charisma.get(); }
    public void setCharisma(int charisma) { this.charisma.set(charisma); }
    public IntegerProperty charismaProperty() { return charisma; }

    public int getHealth() { return health.get(); }
    public void setHealth(int health) { this.health.set(health); }
    public IntegerProperty healthProperty() { return health; }

    public int getSocialSkills() { return socialSkills.get(); }
    public void setSocialSkills(int socialSkills) { this.socialSkills.set(socialSkills); }
    public IntegerProperty socialSkillsProperty() { return socialSkills; }

    public int getBravery() { return bravery.get(); }
    public void setBravery(int bravery) { this.bravery.set(bravery); }
    public IntegerProperty braveryProperty() { return bravery; }

    public int getIntelligence() { return intelligence.get(); }
    public void setIntelligence(int intelligence) { this.intelligence.set(intelligence); }
    public IntegerProperty intelligenceProperty() { return intelligence; }

    public int getConfidence() { return confidence.get(); }
    public void setConfidence(int confidence) { this.confidence.set(confidence); }
    public IntegerProperty confidenceProperty() { return confidence; }

    public int getSelfEsteem() { return selfEsteem.get(); }
    public void setSelfEsteem(int selfEsteem) { this.selfEsteem.set(selfEsteem); }
    public IntegerProperty selfEsteemProperty() { return selfEsteem; }

    public int getViews() { return views.get(); }
    public void setViews(int views) { this.views.set(views); }
    public IntegerProperty viewsProperty() { return views; }

    public int getHumor() { return humor.get(); }
    public void setHumor(int humor) { this.humor.set(humor); }
    public IntegerProperty humorProperty() { return humor; }

    public int getWisdom() { return wisdom.get(); }
    public void setWisdom(int wisdom) { this.wisdom.set(wisdom); }
    public IntegerProperty wisdomProperty() { return wisdom; }

    public int getEmpathy() { return empathy.get(); }
    public void setEmpathy(int empathy) { this.empathy.set(empathy); }
    public IntegerProperty empathyProperty() { return empathy; }

    public int getSensitivity() { return sensitivity.get(); }
    public void setSensitivity(int sensitivity) { this.sensitivity.set(sensitivity); }
    public IntegerProperty sensitivityProperty() { return sensitivity; }

    public int getCreativity() { return creativity.get(); }
    public void setCreativity(int creativity) { this.creativity.set(creativity); }
    public IntegerProperty creativityProperty() { return creativity; }

}
