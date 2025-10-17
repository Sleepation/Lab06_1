package Lab6One;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

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

        Text salaryResults = new Text();


        btAddSalary.setOnAction(e -> {
            if(textField.getText().matches("\\d+")){
                FileInteractor.retriever(Integer.parseInt(textField.getText()));
                numberOfSalariesAdded.setText(++i + " Salary added to your file");
            }
        });

        btDone.setOnAction(e -> {
            List<Integer> salaries = FileInteractor.returner();

            salaryResults.setText("Salaries: " + salaries.toString()
            + "\nCount: " + i
            + "\nTotal: " + sum(salaries)
            + "\nAverage: " + average(salaries));
        });

        vBox.getChildren().addAll(numberOfSalariesAdded, btDone, salaryResults);

        primaryStage.setScene(new Scene(vBox, 200, 200));
        primaryStage.setTitle("Salary Saver");
        primaryStage.show();
    }
    
    public int sum(List<Integer> salaries) {
        int sum = 0;
            for (int value: salaries) {
            sum += value;
            }

        return sum;
    }

    public int average(List<Integer> salaries) {
        return sum(salaries)/salaries.size();
    }
}
