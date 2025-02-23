package charaplanner.data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;

public record Stats(
        IntegerProperty physicalStrength,
        IntegerProperty mindStrength,
        IntegerProperty perception,
        IntegerProperty speed,
        IntegerProperty dexterity,
        IntegerProperty combat,
        IntegerProperty persuasion,
        IntegerProperty charisma,
        IntegerProperty health,
        IntegerProperty socialSkills,
        IntegerProperty bravery,
        IntegerProperty intelligence,
        IntegerProperty confidence,
        IntegerProperty selfEsteem,
        IntegerProperty views,
        IntegerProperty humor,
        IntegerProperty wisdom,
        IntegerProperty empathy,
        IntegerProperty sensitivity,
        IntegerProperty creativity
) {
    public Stats() {
        this(
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5),
                new SimpleIntegerProperty(5)
        );
    }
}