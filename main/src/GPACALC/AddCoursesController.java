package GPACALC;

import Backend.GPACalculator;
import GPACALC.GpaButton2Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddCoursesController {
	
	public GPACalculator calc = new GPACalculator();

	
	private int num1 = 1;
	private int num2 = 1;
	
	@FXML
    private Button nextC;
	

    @FXML
    private TextField gpaAchieved;
    
    @FXML
    private Text displayGPA;
    
    @FXML
    private Text result;
    
	@FXML
	private Text courseNum;

    @FXML
    void nextButton(ActionEvent event) {
    	int a = GpaButton2Controller.getNumEnrolled();
    	
    	if( num1 == a -1) {
    		nextC.setText("Finish");
    		Stage stage = (Stage)nextC.getScene().getWindow();
    		stage.close();
    	}
    	
    	if (num1 < a) {
    		num1 = num1 +1;
    		courseNum.setText(Integer.toString(num1));
    	}
    	
    	if (num1 == a-1) {
    		nextC.setText("Finish");
    		
    	}
    	
    	
    	
    	result.setText(null);
    	gpaAchieved.clear();
    	displayGPA.setText(null);
    	

    }
    

    	
    
    
    @FXML
    void getGPAAcheived(ActionEvent event) {
    	double GPA = 0;
    	double gradeNeeded = 0;
    	try {
    		GPA = Double.parseDouble(gpaAchieved.getText());
    		if (GPA >= 0.0 && GPA <= 4.0) {
    			if (GpaButton2Controller.getNumEnrolled() == 2) {
    	    		nextC.setText("Finish");	
    	    	}
    			calc.addGrade(GPA);
    			displayGPA.setText("You achieved a GPA of  " + GPA);
    			gradeNeeded = calc.gradeNeededToMaintain( GpaButton2Controller.getNumEnrolled(), GpaButton2Controller.getNewDesiredGrade());
    			nextC.setDisable(false);
    			if(gradeNeeded == -1) {
	    				result.setText("You cannot get that grade from " + (GpaButton2Controller.getNumEnrolled()- num2) + " classes");
	    		}else {
	    			result.setText(("The GPA in your course required to maintain a " + GpaButton2Controller.getNewDesiredGrade()+ " is " + gradeNeeded  + " in " + (GpaButton2Controller.getNumEnrolled()-num2) + " classes"));
	    		}
    			num2+=1;
    		}
    	
    			
    		else {
    			displayGPA.setText("GPA must be a number between 0.0 and 4.0");
    		}
    	}catch(Exception e) {
    		displayGPA.setText("GPA must be a number between 0.0 and 4.0");
    	}

    }
}
    
    


