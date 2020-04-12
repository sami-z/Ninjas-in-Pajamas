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

public class GpaButton2Controller {
	
	private AddCoursesController controller;
	
	private static int numberOfEnrolled;
	
	private static double newDesiredGrade;
	
	
    @FXML
    private TextField numEnroll;

    @FXML
    private Text displayCourse;
    
    @FXML
    private Button addButton;
    
    @FXML
    private Text displayDesiredG;
    
    @FXML
    private TextField desiredG;
    
    

    @FXML
    void getNumEnroll(ActionEvent event) {
    	int d = 0;
    	try {
    		d = Integer.parseInt(numEnroll.getText());
    		if (d >= 2) {
    			displayCourse.setText("You are enrolled in " + numEnroll.getText() + " courses");
    			numberOfEnrolled = d;
    		}
    		else {
    			displayCourse.setText("Number of courses must be an integer >= 2");
    		}
    	}catch(Exception e) {
    		displayCourse.setText("Number of courses must be an integer >= 2");
    	}
    }
    
    

    @FXML
    void goAddButton(ActionEvent event) throws IOException {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/GPACALC/AddCourses.fxml"));
         Parent root = loader.load();
    	 controller = loader.<AddCoursesController>getController();
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.setScene(scene);
         stage.show();
    }
    
    
    public void setNumOfEnrolled(int numOfE) {
    	GpaButton2Controller.numberOfEnrolled = numOfE;
    }
    
    public static int getNumEnrolled() {
    	return numberOfEnrolled;
    }
    
    public static double getNewDesiredGrade() {
    	return newDesiredGrade;
    }
    
    
    @FXML
    void getDesiredG(ActionEvent event) {
    	double d = 0;
    	try {
    		d = Double.parseDouble(desiredG.getText());
    		if (d >= 0.0 && d<= 4.0) {
    			displayDesiredG.setText("You wish to acheive a " + d);
    			newDesiredGrade = d;
    			addButton.setDisable(false);
    		}else {
    			displayDesiredG.setText("Desired grade must be between 0.0 and 4.0");
    		}
    	}catch(Exception e) {
    		displayDesiredG.setText("Desired grade must be between 0.0 and 4.0");	
    	}
    	
    	
    }

}

