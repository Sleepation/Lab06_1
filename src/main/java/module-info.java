module org.example.lab06_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab06_1 to javafx.fxml;
    exports org.example.lab06_1;
}