package GPACALC;
import Backend.GPACalculator;
import GPACALC.GpaButton2Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The AddCoursesController class is the controller for the AddCourses.fxml file.
 * This class sets the information to be sent to calculate the required GPA needed to maintain
 */

public class AddCoursesController {
	
	//Instance of GPACalculator used for calculations  
	public GPACalculator calc = new GPACalculator();			 ////PRIVACY LEAK!!!!

	//Number used to loop through each enrolled course
	private int num1 = 1;
	
	//Number used to display required GPA in num2 classes
	private int num2 = 1;
	
	//nextC, is the button in the AddCourses.fxml file which lets you input grades for the next class
	@FXML
    private Button nextC;
	
	//gpaAchieved, is the text field in the AddCourses.fxml file which takes the user input for their GPA
    @FXML
    private TextField gpaAchieved;
    
    //displayGPA, is the text in the AddCourses.fxml file which displays the GPA entered in gpaAchieved to the user
    @FXML
    private Text displayGPA;
    
    //result, is the text in the AddCourses.fxml file which displays the GPA required to maintain user's desired GPA
    @FXML
    private Text result;
    
    //courseNum, is the text in the AddCourses.fxml file which display what course you are entering information for
	@FXML
	private Text courseNum;

	/**
     * This method takes in an event as a parameter and either closes the window or proceeds to the next course
     * based on the amount of courses enrolled in
     * 
     * @param event - An action event that is triggered when the button nextC is pressed
     */
    @FXML
    void nextButton(ActionEvent event) {
    	//Stored value of number of courses enrolled in
    	int a = GpaButton2Controller.getNumEnrolled();
    	
    	//Close the stage when button nextC is clicked one course away from number of courses enrolled
    	if( num1 == a -1) {
    		nextC.setText("Finish");
    		Stage stage = (Stage)nextC.getScene().getWindow();
    		stage.close();
    	}
    	
    	//Increment num1 by 1 if it is less than the number of enrolled courses, and set text courseNum to num1
    	if (num1 < a) {
    		num1 = num1 +1;
    		courseNum.setText(Integer.toString(num1));
    	}
    	
    	//Set the nextC text to "Finish" if num1 = number of enrolled courses -1
    	if (num1 == a-1) {
    		nextC.setText("Finish");
    		
    	}
    	
    	
    	//resets the text and textfield for the next event
    	result.setText(null);
    	gpaAchieved.clear();
    	displayGPA.setText(null);
    }
    
 	
    /**
     * This method takes in an event as a parameter and calculates the GPA required to maintain the user's desired GPA,
     * then displays it for the user to see
     * 
     * @param event - An action event that is triggered when a GPA is entered in the textfield gpaAchieved
     */  
    @FXML
    void getGPAAcheived(ActionEvent event) {
    	//Intialize variable GPA to 0
    	double GPA = 0;
    	
    	//Initialize variable gradeNeeded to 0
    	double gradeNeeded = 0;
    	
    	//Take input from GUI to send to calc (instance of GPACalculator) and
    	//calculates the required GPA needed to maintain desired GPA, which is then displayed for the user to see.
    	//If not possible to attain, user is shown message stating such
    	try {
    		//Store input entered by user 
    		GPA = Double.parseDouble(gpaAchieved.getText());
    		if (GPA >= 0.0 && GPA <= 4.0) {
    			if (GpaButton2Controller.getNumEnrolled() == 2) {
    	    		nextC.setText("Finish");	
    	    	}
    			//add GPA to ArrayList addGrade in calc
    			calc.addGrade(GPA);
    			
    			//Display message in text displayGPA stating what GPA you have achieved
    			displayGPA.setText("You achieved a GPA of  " + GPA);
    			//Calculate the grade needed
    			gradeNeeded = calc.gradeNeededToMaintain( GpaButton2Controller.getNumEnrolled(), GpaButton2Controller.getNewDesiredGrade());
    			nextC.setDisable(false);
    			if(gradeNeeded == -1) {
	    				result.setText("You cannot get that grade from " + (GpaButton2Controller.getNumEnrolled()- num2) + " classes");
	    		}else {
	    			result.setText(("The GPA in your course required to maintain a " + GpaButton2Controller.getNewDesiredGrade()+ " is " + gradeNeeded  + " in " + (GpaButton2Controller.getNumEnrolled()-num2) + " classes"));
	    		}
    			num2+=1;
    		}
    	
    		//If GPA entered is not between 0.0 and 4.0, display an error message	
    		else {
    			displayGPA.setText("GPA must be a number between 0.0 and 4.0");
    		}
    	
    	// If GPA entered is a string, display an error message
    	}catch(Exception e) {
    		displayGPA.setText("GPA must be a number between 0.0 and 4.0");
    	}

    }
}
    
    


