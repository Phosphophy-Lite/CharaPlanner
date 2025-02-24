package charaplanner.data;

import jakarta.xml.bind.annotation.XmlElement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public record Trivia(
        StringProperty nativeLanguages,
        StringProperty learntLanguages,
        StringProperty speech,
        StringProperty voiceclaim,
        StringProperty themeSongs,
        StringProperty animal,
        StringProperty plant,
        StringProperty gemstone,
        StringProperty season,
        StringProperty place,
        StringProperty food,
        StringProperty drink,
        StringProperty aesthetic,
        StringProperty likes,
        StringProperty dislikes
) {
    public Trivia() {
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
                new SimpleStringProperty("")
        );
    }

    // DO NOT REMOVE : These Getters & Setters are necessary for JAXB to serialize/unserialize data to/from XML files
    // JAXB needs methods returning simple types, so we provide these

    @XmlElement
    public String getNativeLanguages() {
        return nativeLanguages.get();
    }

    public void setNativeLanguages(String nativeLanguages) {
        this.nativeLanguages.set(nativeLanguages);
    }

    @XmlElement
    public String getLearntLanguages() {
        return learntLanguages.get();
    }

    public void setLearntLanguages(String learntLanguages) {
        this.learntLanguages.set(learntLanguages);
    }

    @XmlElement
    public String getSpeech() {
        return speech.get();
    }

    public void setSpeech(String speech) {
        this.speech.set(speech);
    }

    @XmlElement
    public String getVoiceclaim() {
        return voiceclaim.get();
    }

    public void setVoiceclaim(String voiceclaim) {
        this.voiceclaim.set(voiceclaim);
    }

    @XmlElement
    public String getThemeSongs() {
        return themeSongs.get();
    }

    public void setThemeSongs(String themeSongs) {
        this.themeSongs.set(themeSongs);
    }

    @XmlElement
    public String getAnimal() {
        return animal.get();
    }

    public void setAnimal(String animal) {
        this.animal.set(animal);
    }

    @XmlElement
    public String getPlant() {
        return plant.get();
    }

    public void setPlant(String plant) {
        this.plant.set(plant);
    }

    @XmlElement
    public String getGemstone() {
        return gemstone.get();
    }

    public void setGemstone(String gemstone) {
        this.gemstone.set(gemstone);
    }

    @XmlElement
    public String getSeason() {
        return season.get();
    }

    public void setSeason(String season) {
        this.season.set(season);
    }

    @XmlElement
    public String getPlace() {
        return place.get();
    }

    public void setPlace(String place) {
        this.place.set(place);
    }

    @XmlElement
    public String getFood() {
        return food.get();
    }

    public void setFood(String food) {
        this.food.set(food);
    }

    @XmlElement
    public String getDrink() {
        return drink.get();
    }

    public void setDrink(String drink) {
        this.drink.set(drink);
    }

    @XmlElement
    public String getAesthetic() {
        return aesthetic.get();
    }

    public void setAesthetic(String aesthetic) {
        this.aesthetic.set(aesthetic);
    }

    @XmlElement
    public String getLikes() {
        return likes.get();
    }

    public void setLikes(String likes) {
        this.likes.set(likes);
    }

    @XmlElement
    public String getDislikes() {
        return dislikes.get();
    }

    public void setDislikes(String dislikes) {
        this.dislikes.set(dislikes);
    }

}
