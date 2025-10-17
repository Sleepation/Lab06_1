module Lab6One {
    requires javafx.controls;
    requires javafx.fxml;



    opens Lab6One to javafx.fxml;
    exports Lab6One;
}