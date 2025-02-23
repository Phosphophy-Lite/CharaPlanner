package charaplanner.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Relationships {
    private final StringProperty sexualOrientation;
    private final StringProperty romanticOrientation;
    private final StringProperty familyStatus;
    private final StringProperty relationshipStatus;

    private final StringProperty parentA;
    private final StringProperty parentB;
    private final StringProperty siblings;
    private final StringProperty children;
    private final StringProperty friends;
    private final StringProperty bestFriend;
    private final StringProperty significantOther;
    private final StringProperty rival;
    private final StringProperty mentor;
    private final StringProperty apprentice;
    private final StringProperty enemies;
    private final StringProperty nemesis;
    private final StringProperty unclesAunts;
    private final StringProperty grandParents;
    private final StringProperty other;


    
    public Relationships(){
        this.sexualOrientation = new SimpleStringProperty("");
        this.romanticOrientation = new SimpleStringProperty("");
        this.familyStatus = new SimpleStringProperty("");
        this.relationshipStatus = new SimpleStringProperty("");
        this.parentA = new SimpleStringProperty("");
        this.parentB = new SimpleStringProperty("");
        this.siblings = new SimpleStringProperty("");
        this.bestFriend = new SimpleStringProperty("");
        this.significantOther = new SimpleStringProperty("");
        this.rival = new SimpleStringProperty("");
        this.mentor = new SimpleStringProperty("");
        this.apprentice = new SimpleStringProperty("");
        this.nemesis = new SimpleStringProperty("");
        this.unclesAunts = new SimpleStringProperty("");
        this.grandParents = new SimpleStringProperty("");
        this.other = new SimpleStringProperty("");
        this.enemies = new SimpleStringProperty("");
        this.friends = new SimpleStringProperty("");
        this.children = new SimpleStringProperty("");
    }

    public String getSexualOrientation() { return sexualOrientation.get(); }
    public void setSexualOrientation(String sexualOrientation) { this.sexualOrientation.set(sexualOrientation); }
    public StringProperty getSexualOrientationProperty() { return sexualOrientation; }

    public String getRomanticOrientation() { return romanticOrientation.get(); }
    public void setRomanticOrientation(String romanticOrientation) { this.romanticOrientation.set(romanticOrientation); }
    public StringProperty getRomanticOrientationProperty() { return romanticOrientation; }

    public String getFamilyStatus() { return familyStatus.get(); }
    public void setFamilyStatus(String familyStatus) { this.familyStatus.set(familyStatus); }
    public StringProperty getFamilyStatusProperty() { return familyStatus; }

    public String getRelationshipStatus() { return relationshipStatus.get(); }
    public void setRelationshipStatus(String relationshipStatus) { this.relationshipStatus.set(relationshipStatus); }
    public StringProperty getRelationshipStatusProperty() { return relationshipStatus; }

    public String getParentA() { return parentA.get(); }
    public void setParentA(String parentA) { this.parentA.set(parentA); }
    public StringProperty getParentAProperty() { return parentA; }

    public String getParentB() { return parentB.get(); }
    public void setParentB(String parentB) { this.parentB.set(parentB); }
    public StringProperty getParentBProperty() { return parentB; }

    public String getSiblings() { return siblings.get(); }
    public void setSiblings(String siblings) { this.siblings.set(siblings); }
    public StringProperty getSiblingsProperty() { return siblings; }

    public String getBestFriend() { return bestFriend.get(); }
    public void setBestFriend(String bestFriend) { this.bestFriend.set(bestFriend); }
    public StringProperty getBestFriendProperty() { return bestFriend; }

    public String getSignificantOther() { return significantOther.get(); }
    public void setSignificantOther(String significantOther) { this.significantOther.set(significantOther); }
    public StringProperty getSignificantOtherProperty() { return significantOther; }

    public String getRival() { return rival.get(); }
    public void setRival(String rival) { this.rival.set(rival); }
    public StringProperty getRivalProperty() { return rival; }

    public String getMentor() { return mentor.get(); }
    public void setMentor(String mentor) { this.mentor.set(mentor); }
    public StringProperty getMentorProperty() { return mentor; }

    public String getApprentice() { return apprentice.get(); }
    public void setApprentice(String apprentice) { this.apprentice.set(apprentice); }
    public StringProperty getApprenticeProperty() { return apprentice; }

    public String getNemesis() { return nemesis.get(); }
    public void setNemesis(String nemesis) { this.nemesis.set(nemesis); }
    public StringProperty getNemesisProperty() { return nemesis; }

    public String getChildren() { return children.get(); }
    public void setChildren(String children) { this.children.set(children); }
    public StringProperty getChildrenProperty() { return children; }

    public String getFriends() { return friends.get(); }
    public void setFriends(String friends) { this.friends.set(friends); }
    public StringProperty getFriendsProperty() { return friends; }

    public String getEnemies() { return enemies.get(); }
    public void setEnemies(String enemies) { this.enemies.set(enemies); }
    public StringProperty getEnemiesProperty() { return enemies; }

    public String getUnclesAunts() { return unclesAunts.get(); }
    public void setUnclesAunts(String unclesAunts) { this.unclesAunts.set(unclesAunts); }
    public StringProperty getUnclesAuntsProperty() { return unclesAunts; }

    public String getGrandParents() { return grandParents.get(); }
    public void setGrandParents(String grandParents) { this.grandParents.set(grandParents); }
    public StringProperty getGrandParentsProperty() { return grandParents; }

    public String getOther() { return other.get(); }
    public void setOther(String other) { this.other.set(other); }
    public StringProperty getOtherProperty() { return other; }

}
