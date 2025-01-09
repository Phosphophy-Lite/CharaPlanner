package charaplanner;

import javafx.scene.control.Slider;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        initialize();
    }

    // Initialization common to both constructors
    private void initialize() {
        slider.setDisable(true);        // disable by default
        slider.setOpacity(1.0);        // full opacity even when disabled
    }

    public void enable(){
        slider.setDisable(false);
    }

    public void setValue(int value){
        slider.setValue((double) value);
    }

    public int getValue(){
        return (int) slider.getValue();
    }

    // Set custom tick labels from an array of strings
    public void setCustomLabels(String... labels) {
        // String... : varargs will automatically wrap each string passed into the function a String Array

        List<Double> tickValues = new ArrayList<>(); //List to store major tick values


        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if(!tickValues.contains(n)){
                    tickValues.add(n);
                }
                int index = tickValues.indexOf(n);
                if (index < labels.length) {
                    return labels[index];
                } else {
                    return ""; //Return empty if out of bounds
                }
            }

            @Override
            public Double fromString(String string) {
                for (int i = 0; i < labels.length; i++) {
                    if (labels[i].equals(string)) {
                        return tickValues.get(i);
                    }
                }
                return 0.0;
            }
        });
    }
}
