package charaplanner.data;

import jakarta.xml.bind.annotation.XmlElement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record BasicInfos(
        StringProperty firstName,
        StringProperty lastName,
        StringProperty birthDate, //String and not LocalDate object because depending on the user's universe, it might not be a usual date format
        StringProperty gender,
        StringProperty pronouns,
        StringProperty age, //String and not integer depending on the user's desired metric/unknown age
        StringProperty job,
        StringProperty jobPosition,
        StringProperty nicknames,
        StringProperty birthPlace,
        StringProperty nationality,
        StringProperty specie,
        StringProperty affiliation,
        StringProperty religion
) {
    public BasicInfos() {
        this("", "", "", "", "", "", "");
    }

    // For testing purposes
    public BasicInfos(String firstName, String lastName, String birthDate, String gender, String age, String job, String jobPosition) {
        this(
                new SimpleStringProperty(firstName),
                new SimpleStringProperty(lastName),
                new SimpleStringProperty(birthDate),
                new SimpleStringProperty(gender),
                new SimpleStringProperty(""),
                new SimpleStringProperty(age),
                new SimpleStringProperty(job),
                new SimpleStringProperty(jobPosition),
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
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    @XmlElement
    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    @XmlElement
    public String getBirthDate() {
        return birthDate.get();
    }

    public void setBirthDate(String birthDate) {
        this.birthDate.set(birthDate);
    }

    @XmlElement
    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    @XmlElement
    public String getPronouns() {
        return pronouns.get();
    }

    public void setPronouns(String pronouns) {
        this.pronouns.set(pronouns);
    }

    @XmlElement
    public String getAge() {
        return age.get();
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    @XmlElement
    public String getJob() {
        return job.get();
    }

    public void setJob(String job) {
        this.job.set(job);
    }

    @XmlElement
    public String getJobPosition() {
        return jobPosition.get();
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition.set(jobPosition);
    }

    @XmlElement
    public String getNicknames() {
        return nicknames.get();
    }

    public void setNicknames(String nicknames) {
        this.nicknames.set(nicknames);
    }

    @XmlElement
    public String getBirthPlace() {
        return birthPlace.get();
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace.set(birthPlace);
    }

    @XmlElement
    public String getNationality() {
        return nationality.get();
    }

    public void setNationality(String nationality) {
        this.nationality.set(nationality);
    }

    @XmlElement
    public String getSpecie() {
        return specie.get();
    }

    public void setSpecie(String specie) {
        this.specie.set(specie);
    }

    @XmlElement
    public String getAffiliation() {
        return affiliation.get();
    }

    public void setAffiliation(String affiliation) {
        this.affiliation.set(affiliation);
    }

    @XmlElement
    public String getReligion() {
        return religion.get();
    }

    public void setReligion(String religion) {
        this.religion.set(religion);
    }

}