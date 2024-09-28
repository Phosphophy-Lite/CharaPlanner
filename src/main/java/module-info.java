module chara.planner.charaplanner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens chara.planner.charaplanner to javafx.fxml;
    exports chara.planner.charaplanner;
}