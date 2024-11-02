package chara.planner.charaplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BasicInfos {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty birthDate; //String and not LocalDate object because depending on the user's universe, it might not be a usual date format
    private final StringProperty gender;
    private final StringProperty age; //String and not integer depending on the user's desired metric/unknown age
    private final StringProperty job;
    private final StringProperty jobPosition;

    private final StringProperty nicknames;
    private final StringProperty birthPlace;
    private final StringProperty nationality;
    private final StringProperty specie;
    private final StringProperty affiliation;
    private final StringProperty religion;

    public BasicInfos() {
        this(null, null, null, null, null, null, null);
    }

    public BasicInfos(String firstName, String lastName, String birthDate, String gender, String age, String job, String jobPosition) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthDate = new SimpleStringProperty(birthDate);
        this.gender = new SimpleStringProperty(gender);
        this.age = new SimpleStringProperty(age);
        this.job = new SimpleStringProperty(job);
        this.jobPosition = new SimpleStringProperty(jobPosition);

        this.nicknames = new SimpleStringProperty("");
        this.birthPlace = new SimpleStringProperty("");
        this.nationality = new SimpleStringProperty("");
        this.specie = new SimpleStringProperty("");
        this.affiliation = new SimpleStringProperty("");
        this.religion = new SimpleStringProperty("");
    }

    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String fN){
        this.firstName.set(fN);
    }
    public StringProperty getFirstNameProperty(){
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String lN){
        this.lastName.set(lN);
    }
    public StringProperty getLastNameProperty(){
        return lastName;
    }

    public String getGender() {
        return gender.get();
    }
    public void setGender(String gen){
        this.gender.set(gen);
    }
    public StringProperty getGenderProperty(){
        return gender;
    }

    public String getBirthDate() {
        return birthDate.get();
    }
    public void setBirthDate(String bD){
        this.birthDate.set(bD);
    }
    public StringProperty getBirthDateProperty(){
        return birthDate;
    }

    public String getAge() {
        return age.get();
    }
    public void setAge(String age){
        this.age.set(age);
    }
    public StringProperty getAgeProperty(){
        return age;
    }

    public String getJob() { return job.get(); }
    public void setJob(String job){ this.job.set(job); }
    public StringProperty getJobProperty(){ return job; }

    public String getJobPosition() {
        return jobPosition.get();
    }
    public void setJobPosition(String jobPosition){
        this.jobPosition.set(jobPosition);
    }
    public StringProperty getJobPositionProperty(){
        return jobPosition;
    }

    public String getNicknames() { return nicknames.get(); }
    public void setNicknames(String nicknames){ this.nicknames.set(nicknames); }
    public StringProperty getNicknamesProperty(){ return nicknames; }

    public String getBirthPlace() { return birthPlace.get(); }
    public void setBirthPlace(String birthPlace){ this.birthPlace.set(birthPlace); }
    public StringProperty getBirthPlaceProperty(){ return birthPlace; }

    public String getNationality() { return nationality.get(); }
    public void setNationality(String nationality){ this.nationality.set(nationality); }
    public StringProperty getNationalityProperty(){ return nationality; }

    public String getSpecie() { return specie.get(); }
    public void setSpecie(String specie){ this.specie.set(specie); }
    public StringProperty getSpecieProperty(){ return specie; }

    public String getAffiliation() { return affiliation.get(); }
    public void setAffiliation(String affiliation){ this.affiliation.set(affiliation); }
    public StringProperty getAffiliationProperty(){ return affiliation; }

    public String getReligion() { return religion.get(); }
    public void setReligion(String religion){ this.religion.set(religion); }
    public StringProperty getReligionProperty(){ return religion; }
}
