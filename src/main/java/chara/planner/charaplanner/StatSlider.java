package chara.planner.charaplanner;

import javafx.scene.control.Slider;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import java.io.IOException;

public class StatSlider extends VBox {

    @FXML private Slider slider;

    public StatSlider() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("statslider.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try{
            fxmlLoader.load();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        initialize(); //Disable by default
    }

    // Initialization common to both constructors
    private void initialize() {
        slider.setDisable(true);        //Disable by default
        slider.setOpacity(1.0);        // Maintain full opacity even when disabled
    }

    public void enable(){
        slider.setDisable(false);
    }

    // Method to set custom tick labels from an array of strings
    public void setCustomLabels(String... labels) { //String... : varargs will automatically wrap each string passed into the function a String Array
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                int index = n.intValue();
                if (index >= 0 && index < labels.length) {
                    return labels[index];
                } else {
                    return ""; // Return empty if out of bounds
                }
            }

            @Override
            public Double fromString(String string) {
                for (int i = 0; i < labels.length; i++) {
                    if (labels[i].equals(string)) {
                        return (double) i;
                    }
                }
                return 0.0;
            }
        });
    }
}
