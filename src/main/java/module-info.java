module com.example.pratikassignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.pratikassignment1 to javafx.fxml;
    exports com.example.pratikassignment1;
}