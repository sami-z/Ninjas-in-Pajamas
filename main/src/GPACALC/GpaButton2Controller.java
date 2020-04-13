package GPACALC;

import java.io.IOException;

import Backend.GPACalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The GpaButton2Controller class is the controller for the GPABUTTON2.fxml file.
 * This class allows the user to input the amount of courses they're in and their desired GPA
 * to be used for calculations
 */


public class GpaButton2Controller {
	
	//Store the number of enrolled courses
	private static int numberOfEnrolled;
	
	//Store the desired grade
	private static double newDesiredGrade;
	
	//numEnroll, is the textfield in the GpaButton2Controller.fxml file where the user inputs the amount of enrolled courses
    @FXML
    private TextField numEnroll;

    //displayCourse, is the text in the GpaButton2Controller.fxml file where the input from numEnroll is displayed
    @FXML
    private Text displayCourse;
    
    //addButton, is the button in the GpaButton2Controller.fxml file that the user presses to display AddCourses.fxml,
    //and enter information for each course 
    @FXML
    private Button addButton;
    
    //displayDesiredG, is the text in the GpaButton2Controller.fxml file where the input from desiredG is displayed
    @FXML
    private Text displayDesiredG;
    
    //desiredG, is the textfield in the GpaButon2Controller.fxml file where the user inputs their desired grade
    @FXML
    private TextField desiredG;
    
    
    /**
     * This method displays the input entered in textfield numEnroll in
     * text displayCourse
     * 
     * @param event - An action event that is triggered when input is entered in textfield numEnroll
     */
    @FXML
    void getNumEnroll(ActionEvent event) {
    	//Initialize d to 0
    	int d = 0;
    	try {
    		//Get the input from numEnroll and store it as d
    		d = Integer.parseInt(numEnroll.getText());
    		if (d >= 2) {
    			//set the text for displayCourse
    			displayCourse.setText("You are enrolled in " + numEnroll.getText() + " courses");
    			numberOfEnrolled = d;
    		}
    		//If number of enrolled (d) is not >= 2, display error message in displayCourse
    		else {
    			displayCourse.setText("Number of courses must be an integer >= 2");
    		}
    	//If number of enrolled is not a number, display error message in displayCourse
    	}catch(Exception e) {
    		displayCourse.setText("Number of courses must be an integer >= 2");
    	}
    }
    
    
    /**
     * This method loads the scene AddCourses.fxml 
     * 
     * @param event - An action event that is triggered when the button addButton is pressed
     */
    @FXML
    void goAddButton(ActionEvent event) throws IOException {
    	//Load scene
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/GPACALC/AddCourses.fxml"));
         Parent root = loader.load();
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.setScene(scene);
         stage.show();
    }
    
    /**
     * This method sets the instance variable numberOfEnrolled
     * 
     * @param numOfE - the number of enrolled courses
     */
    public void setNumOfEnrolled(int numOfE) {
    	GpaButton2Controller.numberOfEnrolled = numOfE;
    }
    
    /**
     * This method returns the instance variable numberOfEnrolled
     * 
     * @return numberOfEnrolled - returns the instance variable numberOfEnrolled
     */
    public static int getNumEnrolled() {
    	return numberOfEnrolled;
    }
    
    /**
     * This method returns the instance variable newDesiredGrade
     * 
     * @return newDesiredGrade - returns the instance variable newDesiredGrade
     */
    public static double getNewDesiredGrade() {
    	return newDesiredGrade;
    }
    
    
    /**
     * This method displays the input entered in textfield desiredG in
     * text displayDesiredG
     * 
     * @param event - An action event that is triggered when input is entered in textfield desiredG
     */
    @FXML
    void getDesiredG(ActionEvent event) {
    	//Initialize d to 0
    	double d = 0;
    	try {
    		//Get the input from desiredG and store it as d
    		d = Double.parseDouble(desiredG.getText());
    		if (d >= 0.0 && d<= 4.0) {
    			//set the text for displayDesiredG
    			displayDesiredG.setText("You wish to acheive a " + d);
    			newDesiredGrade = d;
    			addButton.setDisable(false);
    		
    		//If d is not  between 0.0 and 4.0 (inclusive), display error message in displayDesiredG
    		}else {
    			displayDesiredG.setText("Desired grade must be between 0.0 and 4.0");
    		}
    		
    	//If d is not a number display error message in displayDesiredG
    	}catch(Exception e) {
    		displayDesiredG.setText("Desired grade must be between 0.0 and 4.0");	
    	}
    	
    	
    }

}

