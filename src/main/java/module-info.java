module charaplanner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.prefs;
    requires jakarta.xml.bind;
    requires jakarta.activation;
    requires java.desktop;

    opens charaplanner to javafx.fxml, jakarta.xml.bind;
    exports charaplanner;
}