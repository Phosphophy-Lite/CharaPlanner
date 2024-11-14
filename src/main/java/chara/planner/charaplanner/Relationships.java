package chara.planner.charaplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Relationships {
    private final StringProperty sexualOrientation;
    private final StringProperty romanticOrientation;
    private final StringProperty familyStatus;
    private final StringProperty relationshipStatus;
    private final StringProperty testCharacter;
    
    public Relationships(){
        this.sexualOrientation = new SimpleStringProperty("");
        this.romanticOrientation = new SimpleStringProperty("");
        this.familyStatus = new SimpleStringProperty("");
        this.relationshipStatus = new SimpleStringProperty("");
        this.testCharacter = new SimpleStringProperty("");
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

    public String getTestCharacter() { return testCharacter.get(); }
    public void setTestCharacter(String testCharacter) { this.testCharacter.set(testCharacter); }
    public StringProperty getTestCharacterProperty() { return testCharacter; }

}
