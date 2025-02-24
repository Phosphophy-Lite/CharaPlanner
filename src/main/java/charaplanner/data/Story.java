package charaplanner.data;

import jakarta.xml.bind.annotation.XmlElement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Story(
        StringProperty plotRole,
        StringProperty backstory,
        StringProperty goals,
        StringProperty achievements,
        StringProperty failures,
        StringProperty traumas,
        StringProperty crimes,
        StringProperty secrets,
        StringProperty powers,
        StringProperty education,
        StringProperty expertise,
        StringProperty socialStatus,
        StringProperty wealth
) {
    public Story() {
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
                new SimpleStringProperty("")
        );
    }

    // DO NOT REMOVE : These Getters & Setters are necessary for JAXB to serialize/unserialize data to/from XML files
    // JAXB needs methods returning simple types, so we provide these

    @XmlElement
    public String getPlotRole() {
        return plotRole.get();
    }

    public void setPlotRole(String plotRole) {
        this.plotRole.set(plotRole);
    }

    @XmlElement
    public String getBackstory() {
        return backstory.get();
    }

    public void setBackstory(String backstory) {
        this.backstory.set(backstory);
    }

    @XmlElement
    public String getGoals() {
        return goals.get();
    }

    public void setGoals(String goals) {
        this.goals.set(goals);
    }

    @XmlElement
    public String getAchievements() {
        return achievements.get();
    }

    public void setAchievements(String achievements) {
        this.achievements.set(achievements);
    }

    @XmlElement
    public String getFailures() {
        return failures.get();
    }

    public void setFailures(String failures) {
        this.failures.set(failures);
    }

    @XmlElement
    public String getTraumas() {
        return traumas.get();
    }

    public void setTraumas(String traumas) {
        this.traumas.set(traumas);
    }

    @XmlElement
    public String getCrimes() {
        return crimes.get();
    }

    public void setCrimes(String crimes) {
        this.crimes.set(crimes);
    }

    @XmlElement
    public String getSecrets() {
        return secrets.get();
    }

    public void setSecrets(String secrets) {
        this.secrets.set(secrets);
    }

    @XmlElement
    public String getPowers() {
        return powers.get();
    }

    public void setPowers(String powers) {
        this.powers.set(powers);
    }

    @XmlElement
    public String getEducation() {
        return education.get();
    }

    public void setEducation(String education) {
        this.education.set(education);
    }

    @XmlElement
    public String getExpertise() {
        return expertise.get();
    }

    public void setExpertise(String expertise) {
        this.expertise.set(expertise);
    }

    @XmlElement
    public String getSocialStatus() {
        return socialStatus.get();
    }

    public void setSocialStatus(String socialStatus) {
        this.socialStatus.set(socialStatus);
    }

    @XmlElement
    public String getWealth() {
        return wealth.get();
    }

    public void setWealth(String wealth) {
        this.wealth.set(wealth);
    }

}