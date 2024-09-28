package chara.planner.charaplanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class Character {
    private StringProperty firstName;
    private StringProperty lastName;
    private ObjectProperty<LocalDate> birthDate;
    private StringProperty gender;
    private IntegerProperty age;


    public Character() {
        this(null, null, null, null, null);
    }

    public Character(String firstName, String lastName, LocalDate birthDate, String gender, Integer age) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthDate = new SimpleObjectProperty<LocalDate>(birthDate);
        this.gender = new SimpleStringProperty(gender);
        this.age = new SimpleIntegerProperty(age);
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

    public LocalDate getBirthDate() {
        return birthDate.get();
    }

    public void setBirthDate(LocalDate bD){
        this.birthDate.set(bD);
    }

    public String getFormattedDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.birthDate.get().format(formatter);
    }

    public ObjectProperty<LocalDate> getBirthDateProperty(){
        return birthDate;
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age){
        this.age.set(age); //age won't be calculated and left to the user to pick, depending on their story's timeline
    }

    public IntegerProperty getAgeProperty(){
        return age;
    }


}
