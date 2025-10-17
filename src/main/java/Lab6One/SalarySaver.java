package Lab6One;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SalarySaver extends Application {
    private int i = 0;

    @Override
    public void start(Stage primaryStage){
        VBox vBox = new VBox();
        vBox.setSpacing(10);

        vBox.getChildren().add(new Text("Enter Salary:"));

        TextField textField = new TextField();
        vBox.getChildren().add(textField);

        Button btAddSalary = new Button("Add Salary");


        vBox.getChildren().add(btAddSalary);

        Text numberOfSalariesAdded = new Text();

        Button btDone = new Button("Done");

        Text salaryResult = new Text();


        btAddSalary.setOnAction(e -> {
            if(textField.getText().matches("\\d+")){
                FileInteractor.retrieve(Integer.parseInt(textField.getText()));
                numberOfSalariesAdded.setText(++i + " Salary added to your file");
            }
        });

        btDone.setOnAction(e -> {

        });

        vBox.getChildren().addAll(numberOfSalariesAdded, btDone, salaryResult);

        primaryStage.setScene(new Scene(vBox, 200, 200));
        primaryStage.setTitle("Salary Saver");
        primaryStage.show();
    }
}
