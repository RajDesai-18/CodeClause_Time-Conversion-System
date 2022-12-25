module com.time.timeconversion {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.time.timeconversion to javafx.fxml;
    exports com.time.timeconversion;
}