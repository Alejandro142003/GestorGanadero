module com.example.gestorganadero {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.sql;
    opens com.example.gestorganadero.domain to javafx.base;
    opens com.example.gestorganadero.connections;

    opens com.example.gestorganadero to javafx.fxml;
    exports com.example.gestorganadero;
    opens com.example.gestorganadero.controllers to javafx.fxml;
    exports com.example.gestorganadero.controllers to javafx.fxml;
}