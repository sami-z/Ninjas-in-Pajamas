	package GPACALC;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * The GpaButtonController class is the controller for the GPA.fxml file.
 * This class allows the user to choose what feature of the GPA calculator they would like
 * to use
 */

public class GpaController {

	//gpa1, is the button in the GpaController.fxml file that the user can press to calculate the grade they need
	//on an assessment 
    @FXML
    private Button gpa1;
    
    //gpa2, is the button in the GpaController.fxml file that the user can press to calculate the grade they need 
    //in a course
    @FXML
    private Button gpa2;

    
    /**
     * This method loads the scene GPABUTTON1.fxml 
     * 
     * @param event - An action event that is triggered when the button gpa1 is pressed
     */
    @FXML
    void display1(ActionEvent event) throws IOException {
    	//Load the scene
        Parent root = FXMLLoader.load(getClass().getResource("/GPACALC/GPABUTTON1.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Calculating grade needed on assessment....");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method loads the scene GPABUTTON2.fxml 
     * 
     * @param event - An action event that is triggered when the button gpa2 is pressed
     */
    @FXML
    void display2(ActionEvent event) throws IOException {
    	//Load the scene
        Parent root = FXMLLoader.load(getClass().getResource("/GPACALC/GPABUTTON2.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Calculating grade needed in course....");
        stage.setScene(scene);
        stage.show();
    }

}