package charaplanner.data;

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
}