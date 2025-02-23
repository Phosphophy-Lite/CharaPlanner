package charaplanner.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Story {

    private final StringProperty plotRole;
    private final StringProperty backstory;
    private final StringProperty goals;
    private final StringProperty achievements;
    private final StringProperty failures;
    private final StringProperty traumas;
    private final StringProperty crimes;
    private final StringProperty secrets;
    private final StringProperty powers;
    private final StringProperty education;
    private final StringProperty expertise;
    private final StringProperty socialStatus;
    private final StringProperty wealth;


    public Story() {
        this.plotRole = new SimpleStringProperty("");
        this.backstory = new SimpleStringProperty("");
        this.goals = new SimpleStringProperty("");
        this.achievements = new SimpleStringProperty("");
        this.failures = new SimpleStringProperty("");
        this.traumas = new SimpleStringProperty("");
        this.crimes = new SimpleStringProperty("");
        this.secrets = new SimpleStringProperty("");
        this.powers = new SimpleStringProperty("");
        this.education = new SimpleStringProperty("");
        this.expertise = new SimpleStringProperty("");
        this.socialStatus = new SimpleStringProperty("");
        this.wealth = new SimpleStringProperty("");
    }

    public String getPlotRole() { return plotRole.get(); }
    public void setPlotRole(String plotRole) { this.plotRole.set(plotRole); }
    public StringProperty getPlotRoleProperty() { return plotRole; }

    public String getBackstory() { return backstory.get(); }
    public void setBackstory(String backstory) { this.backstory.set(backstory); }
    public StringProperty getBackstoryProperty() { return backstory; }

    public String getGoals() { return goals.get(); }
    public void setGoals(String goals) { this.goals.set(goals); }
    public StringProperty getGoalsProperty() { return goals; }

    public String getAchievements() { return achievements.get(); }
    public void setAchievements(String achievements) { this.achievements.set(achievements); }
    public StringProperty getAchievementsProperty() { return achievements; }

    public String getFailures() { return failures.get(); }
    public void setFailures(String failures) { this.failures.set(failures); }
    public StringProperty getFailuresProperty() { return failures; }

    public String getTraumas() { return traumas.get(); }
    public void setTraumas(String traumas) { this.traumas.set(traumas); }
    public StringProperty getTraumasProperty() { return traumas; }

    public String getCrimes() { return crimes.get(); }
    public void setCrimes(String crimes) { this.crimes.set(crimes); }
    public StringProperty getCrimesProperty() { return crimes; }

    public String getSecrets() { return secrets.get(); }
    public void setSecrets(String secrets) { this.secrets.set(secrets); }
    public StringProperty secretsProperty() { return secrets; }

    public String getPowers() { return powers.get(); }
    public void setPowers(String powers) { this.powers.set(powers); }
    public StringProperty getPowersProperty() { return powers; }

    public String getEducation() { return education.get(); }
    public void setEducation(String education) { this.education.set(education); }
    public StringProperty getEducationProperty() { return education; }

    public String getExpertise() { return expertise.get(); }
    public void setExpertise(String expertise) { this.expertise.set(expertise); }
    public StringProperty getExpertiseProperty() { return expertise; }

    public String getSocialStatus() { return socialStatus.get(); }
    public void setSocialStatus(String socialStatus) { this.socialStatus.set(socialStatus); }
    public StringProperty getSocialStatusProperty() { return socialStatus; }

    public String getWealth() { return wealth.get(); }
    public void setWealth(String wealth) { this.wealth.set(wealth); }
    public StringProperty getWealthProperty() { return wealth; }


}
