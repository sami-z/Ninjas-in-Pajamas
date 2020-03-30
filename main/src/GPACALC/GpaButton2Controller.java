package GPACALC;

import java.util.ArrayList;
import Backend.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class GpaButton2Controller {
	
	

	@FXML
	private Text dGPA;
	
    @FXML
    private Text textGPA;
	
	@FXML
	private Text numCourses;

    @FXML
    private Text maintainG;

    @FXML
    private Text neededG;

    @FXML
    private TextField finalG;

    @FXML
    private TextField desiredG;

    @FXML
    private TextField enrolledC;
    
    @FXML
    private Button buttonC;
    
    GPACalculator calc = new GPACalculator();
    
    private ArrayList<Double> allGrade = new ArrayList<Double>();
    private int numGradeCategories;
	private double desiredGPA;
	private double gradeNeeded;

    @FXML
    void getEC(ActionEvent event) {
    	this.numGradeCategories = Integer.parseInt(enrolledC.getText());
    	numCourses.setText(enrolledC.getText());
    	enrolledC.clear();
    	
    }

    @FXML
    void getFG(ActionEvent event) {
    	if(!finalG.getText().equals("")) {
    		double initialV = Double.parseDouble(finalG.getText());
	    	calc.allGrade.add(initialV);
	    	finalG.clear();  
	    	textGPA.setText(calc.allGrade.toString());
	    
    	}
    	
    }

    @FXML
    void getDG(ActionEvent event) {
    	this.desiredGPA = Double.parseDouble(desiredG.getText());
    	dGPA.setText(desiredG.getText());
    }

    
    @FXML
    void clickC(ActionEvent event) {
    
    //////////////////////////////////////////
    	
    	maintainG.setText(""+this.desiredGPA);
    	double gradeNeeded = calc.gradeNeededToMaintain(numGradeCategories,this.desiredGPA);
    	if(gradeNeeded==-1.0)
    		neededG.setText("You cannot obtain that GPA");
    	else
    		neededG.setText(""+gradeNeeded);
    }
	}


