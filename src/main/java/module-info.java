module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.sql;

    opens com.example.gestorganadero to javafx.fxml;
    exports com.example.gestorganadero;
}