package GPACALC;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class GPABUTTON1CONTROLLER {
	
	
	@FXML
	private Button computeButton;
	
	@FXML
    private TextField maintainOutput;

    @FXML
    private TextField neededGrade;
	
    @FXML
    private TextField upcomingAssign;

    @FXML
    private Button clearButton;
    
    @FXML
    private Button clearButton2;

    @FXML
    private TextField desiredG;

    @FXML
    private TextField previousAssign;

    @FXML
    private TextField weightAssign;
    
    
    private ArrayList<Double> previousAssignmentWeights = new ArrayList<Double>();
    private ArrayList<Double> previousAssignmentGrades = new ArrayList<Double>();
    private double assignmentWeight;
    private double desiredClassGrade;
    private double gradeNeeded;
  
    @FXML
    void clear1(ActionEvent event) {
    	if(!previousAssign.getText().equals("")) {
	    	double savedValue = Double.parseDouble(previousAssign.getText());
	    	previousAssignmentGrades.add(savedValue);
	    	previousAssign.clear();
    	}
    	
    }

    @FXML
    void clear2(ActionEvent event) {
    	if(!weightAssign.getText().equals("")) {
	    	double savedValue = Double.parseDouble(weightAssign.getText());
	    	previousAssignmentWeights.add(savedValue);
	    	weightAssign.clear();
	    }
    }

    @FXML
    void getVal1(ActionEvent event) {
    	this.assignmentWeight = Double.parseDouble(upcomingAssign.getText());
    	
    }

    @FXML
    void getVal2(ActionEvent event) {
    	this.desiredClassGrade = Double.parseDouble(desiredG.getText());
    	

    }

    
    @FXML
    void computeGrade(ActionEvent event) {
    	GPACalculator calc = new GPACalculator(previousAssignmentGrades, previousAssignmentWeights, assignmentWeight, desiredClassGrade);
    	
    	gradeNeeded = calc.CalculateAssignmentGradeNeeded();
    	
    	String str = Double.toString(gradeNeeded);
    	String str2 = Double.toString(desiredClassGrade);
    	
    	maintainOutput.setText(str2);
    	neededGrade.setText(str);
    	
    	
    }

}
