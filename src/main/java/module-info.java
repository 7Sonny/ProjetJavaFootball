module com.example.football2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires itextpdf;


    opens com.example.football2 to javafx.fxml;
    exports com.example.football2;
}