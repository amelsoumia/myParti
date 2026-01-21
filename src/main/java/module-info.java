module com.example.mypartiapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens com.example.myPartiApplication to javafx.fxml;
    exports com.example.myPartiApplication;
}