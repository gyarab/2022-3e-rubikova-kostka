module com.Projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.yaml.snakeyaml;


    opens com.Projekt.MainGui to javafx.fxml;
    exports com.Projekt.MainGui;
    exports com.Projekt.SolvingPetr;
    opens com.Projekt.SolvingPetr to javafx.fxml;
    exports com.Projekt.Animace;
    opens com.Projekt.Animace to javafx.fxml;
    exports com.Projekt.Cube;
    opens com.Projekt.Cube to javafx.fxml;
}
