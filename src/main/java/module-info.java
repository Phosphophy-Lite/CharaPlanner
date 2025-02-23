module charaplanner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.prefs;
    requires jakarta.xml.bind;
    requires jakarta.activation;
    requires java.desktop;
    requires static lombok;

    opens charaplanner to javafx.fxml, jakarta.xml.bind;
    exports charaplanner;
    exports charaplanner.data;
    opens charaplanner.data to jakarta.xml.bind, javafx.fxml;
    exports charaplanner.ui;
    opens charaplanner.ui to jakarta.xml.bind, javafx.fxml;
}