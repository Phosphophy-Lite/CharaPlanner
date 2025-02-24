package charaplanner.data;

import jakarta.xml.bind.annotation.XmlElement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Relationships(
        StringProperty sexualOrientation,
        StringProperty romanticOrientation,
        StringProperty familyStatus,
        StringProperty relationshipStatus,
        StringProperty parentA,
        StringProperty parentB,
        StringProperty siblings,
        StringProperty children,
        StringProperty friends,
        StringProperty bestFriend,
        StringProperty significantOther,
        StringProperty rival,
        StringProperty mentor,
        StringProperty apprentice,
        StringProperty enemies,
        StringProperty nemesis,
        StringProperty unclesAunts,
        StringProperty grandParents,
        StringProperty other
) {
    public Relationships() {
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
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty(""),
                new SimpleStringProperty("")
        );
    }

    // DO NOT REMOVE : These Getters & Setters are necessary for JAXB to serialize/unserialize data to/from XML files
    // JAXB needs methods returning simple types, so we provide these

    @XmlElement
    public String getSexualOrientation() {
        return sexualOrientation.get();
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation.set(sexualOrientation);
    }

    @XmlElement
    public String getRomanticOrientation() {
        return romanticOrientation.get();
    }

    public void setRomanticOrientation(String romanticOrientation) {
        this.romanticOrientation.set(romanticOrientation);
    }

    @XmlElement
    public String getFamilyStatus() {
        return familyStatus.get();
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus.set(familyStatus);
    }

    @XmlElement
    public String getRelationshipStatus() {
        return relationshipStatus.get();
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus.set(relationshipStatus);
    }

    @XmlElement
    public String getParentA() {
        return parentA.get();
    }

    public void setParentA(String parentA) {
        this.parentA.set(parentA);
    }

    @XmlElement
    public String getParentB() {
        return parentB.get();
    }

    public void setParentB(String parentB) {
        this.parentB.set(parentB);
    }

    @XmlElement
    public String getSiblings() {
        return siblings.get();
    }

    public void setSiblings(String siblings) {
        this.siblings.set(siblings);
    }

    @XmlElement
    public String getChildren() {
        return children.get();
    }

    public void setChildren(String children) {
        this.children.set(children);
    }

    @XmlElement
    public String getFriends() {
        return friends.get();
    }

    public void setFriends(String friends) {
        this.friends.set(friends);
    }

    @XmlElement
    public String getBestFriend() {
        return bestFriend.get();
    }

    public void setBestFriend(String bestFriend) {
        this.bestFriend.set(bestFriend);
    }

    @XmlElement
    public String getSignificantOther() {
        return significantOther.get();
    }

    public void setSignificantOther(String significantOther) {
        this.significantOther.set(significantOther);
    }

    @XmlElement
    public String getRival() {
        return rival.get();
    }

    public void setRival(String rival) {
        this.rival.set(rival);
    }

    @XmlElement
    public String getMentor() {
        return mentor.get();
    }

    public void setMentor(String mentor) {
        this.mentor.set(mentor);
    }

    @XmlElement
    public String getApprentice() {
        return apprentice.get();
    }

    public void setApprentice(String apprentice) {
        this.apprentice.set(apprentice);
    }

    @XmlElement
    public String getEnemies() {
        return enemies.get();
    }

    public void setEnemies(String enemies) {
        this.enemies.set(enemies);
    }

    @XmlElement
    public String getNemesis() {
        return nemesis.get();
    }

    public void setNemesis(String nemesis) {
        this.nemesis.set(nemesis);
    }

    @XmlElement
    public String getUnclesAunts() {
        return unclesAunts.get();
    }

    public void setUnclesAunts(String unclesAunts) {
        this.unclesAunts.set(unclesAunts);
    }

    @XmlElement
    public String getGrandParents() {
        return grandParents.get();
    }

    public void setGrandParents(String grandParents) {
        this.grandParents.set(grandParents);
    }

    @XmlElement
    public String getOther() {
        return other.get();
    }

    public void setOther(String other) {
        this.other.set(other);
    }

}
