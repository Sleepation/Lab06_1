/**
 * Santiago A. Bejarano P., 2430065
 * Thomas A., 2430853
 */

package Lab6One;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class SalarySaver extends Application {
    private int i = 0;

    /**
     * This start method creates a vbox with salaries to add in a .dat file with an add button.
     * When the user is done, they press the done button and the results from the .dat file are shown on a text in the UI
     * @param primaryStage is Stage representing the main stage that shows the result
     */
    @Override
    public void start(Stage primaryStage){
        //VBox
        VBox vBox = new VBox();
        vBox.setSpacing(10);

        //Adding Enter Salary text
        vBox.getChildren().add(new Text("Enter Salary:"));

        //Add textField for User Input
        TextField textField = new TextField();
        vBox.getChildren().add(textField);

        //Create an add btAddSalary (add button)
        Button btAddSalary = new Button("Add Salary");
        vBox.getChildren().add(btAddSalary);

        //Text showing the amount of salaries added in the session
        Text numberOfSalariesAdded = new Text();

        //Button Done to show the result
        Button btDone = new Button("Done");

        //Result text
        Text salaryResults = new Text();

        //Add button action event
        btAddSalary.setOnAction(e -> {
            //Input validation to only get integers
            if(textField.getText().matches("\\d+")){
                FileInteractor.retriever(Integer.parseInt(textField.getText()));
                numberOfSalariesAdded.setText(++i + " Salary added to your file");
            }
        });

        //Done button action event
        btDone.setOnAction(e -> {
            //Get all salaries
            List<Integer> salaries = FileInteractor.returner(i);

            //Set the beginning of the text
            salaryResults.setText("Salaries: ");

            //Add all salaries from the .dat file to the text
            for(int i = 0; i < salaries.size() - 1; i++){
                salaryResults.setText(salaryResults.getText() + salaries.get(i) + ", ");
            }
            salaryResults.setText(salaryResults.getText() + salaries.getLast());

            //Add the count, total, and average of the salaries
            salaryResults.setText(salaryResults.getText()
            + "\nCount: " + salaries.size()
            + "\nTotal: " + sum(salaries)
            + "\nAverage: " + average(salaries));
        });

        //Add number of salaries, done button, and result text to the vBox
        vBox.getChildren().addAll(numberOfSalariesAdded, btDone, salaryResults);

        primaryStage.setScene(new Scene(vBox, 200, 220)); //Create and set scene to stage
        primaryStage.setTitle("Salary Saver"); //Set title of stage
        primaryStage.show(); //Show stage
    }

    /**
     * This sum method adds the salaries together
     * @param salaries are the salaries in integer
     * @return integer representing the sum of the salaries
     */
    public int sum(List<Integer> salaries) {
        int sum = 0;
            for (int value: salaries) {
            sum += value;
            }

        return sum;
    }

    /**
     * This average method adds the salaries together with the sum method and then divides it by the number of salaries added
     * @param salaries are the salaries in integer
     * @return integer representing the average of the salaries
     */
    public int average(List<Integer> salaries) {
        return sum(salaries)/salaries.size();
    }

    //Main method that launches the application
    public static void main(String[] args){
        launch();
    }
}
