package chara.planner.charaplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class BasicInfos {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty birthDate; //String and not LocalDate object because depending on the user's universe, it might not be a usual date format
    private final StringProperty gender;
    private final StringProperty age; //String and not integer depending on the user's desired metric/unknown age
    private final StringProperty job;
    private final StringProperty jobPosition;

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

}
