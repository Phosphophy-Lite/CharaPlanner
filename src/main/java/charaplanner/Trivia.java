package charaplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Trivia {
    private final StringProperty nativeLanguages;
    private final StringProperty learntLanguages;
    private final StringProperty speech;
    private final StringProperty voiceclaim;
    private final StringProperty themeSongs;
    private final StringProperty animal;
    private final StringProperty plant;
    private final StringProperty gemstone;
    private final StringProperty season;
    private final StringProperty place;
    private final StringProperty food;
    private final StringProperty drink;
    private final StringProperty likes;
    private final StringProperty dislikes;

    public Trivia(){
        this.nativeLanguages = new SimpleStringProperty("");
        this.learntLanguages = new SimpleStringProperty("");
        this.speech = new SimpleStringProperty("");
        this.voiceclaim = new SimpleStringProperty("");
        this.themeSongs = new SimpleStringProperty("");
        this.animal = new SimpleStringProperty("");
        this.plant = new SimpleStringProperty("");
        this.gemstone = new SimpleStringProperty("");
        this.season = new SimpleStringProperty("");
        this.place = new SimpleStringProperty("");
        this.food = new SimpleStringProperty("");
        this.drink = new SimpleStringProperty("");
        this.likes = new SimpleStringProperty("");
        this.dislikes = new SimpleStringProperty("");

    }

    public String getNativeLanguages() { return nativeLanguages.get(); }
    public void setNativeLanguages(String nativeLanguages) { this.nativeLanguages.set(nativeLanguages); }
    public StringProperty getNativeLanguagesProperty() { return nativeLanguages; }

    public String getLearntLanguages() { return learntLanguages.get(); }
    public void setLearntLanguages(String learntLanguages) { this.learntLanguages.set(learntLanguages); }
    public StringProperty getLearntLanguagesProperty() { return learntLanguages; }

    public String getSpeech() { return speech.get(); }
    public void setSpeech(String speech) { this.speech.set(speech); }
    public StringProperty getSpeechProperty() { return speech; }

    public String getVoiceclaim() { return voiceclaim.get(); }
    public void setVoiceclaim(String voiceclaim) { this.voiceclaim.set(voiceclaim); }
    public StringProperty getVoiceclaimProperty() { return voiceclaim; }

    public String getThemeSongs() { return themeSongs.get(); }
    public void setThemeSongs(String themeSongs) { this.themeSongs.set(themeSongs); }
    public StringProperty getThemeSongsProperty() { return themeSongs; }

    public String getAnimal() { return animal.get(); }
    public void setAnimal(String animal) { this.animal.set(animal); }
    public StringProperty getAnimalProperty() { return animal; }

    public String getPlant() { return plant.get(); }
    public void setPlant(String plant) { this.plant.set(plant); }
    public StringProperty getPlantProperty() { return plant; }

    public String getGemstone() { return gemstone.get(); }
    public void setGemstone(String gemstone) { this.gemstone.set(gemstone); }
    public StringProperty getGemstoneProperty() { return gemstone; }

    public String getSeason() { return season.get(); }
    public void setSeason(String season) { this.season.set(season); }
    public StringProperty getSeasonProperty() { return season; }

    public String getPlace() { return place.get(); }
    public void setPlace(String place) { this.place.set(place); }
    public StringProperty getPlaceProperty() { return place; }

    public String getFood() { return food.get(); }
    public void setFood(String food) { this.food.set(food); }
    public StringProperty getFoodProperty() { return food; }

    public String getDrink() { return drink.get(); }
    public void setDrink(String drink) { this.drink.set(drink); }
    public StringProperty getDrinkProperty() { return drink; }

    public String getLikes() { return likes.get(); }
    public void setLikes(String likes) { this.likes.set(likes); }
    public StringProperty getLikesProperty() { return likes; }

    public String getDislikes() { return dislikes.get(); }
    public void setDislikes(String dislikes) { this.dislikes.set(dislikes); }
    public StringProperty getDislikesProperty() { return dislikes; }


}
