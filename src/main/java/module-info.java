module com.example.mypartiapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens com.example.mypartiapplication to javafx.fxml;
    exports com.example.mypartiapplication;
}