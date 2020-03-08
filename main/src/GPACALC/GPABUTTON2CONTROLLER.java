package GPACALC;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class GPABUTTON2CONTROLLER {

    @FXML
    private TextField maintainG;

    @FXML
    private TextField neededG;

    @FXML
    private TextField finalG;

    @FXML
    private TextField desiredG;

    @FXML
    private TextField enrolledC;
    
    @FXML
    private Button buttonC;
    
    
    private int numOfClasses;
    private ArrayList<Double> finalClassGrades = new ArrayList<Double>();
	private double desiredGPA;
	private double gradeNeeded;

    @FXML
    void getEC(ActionEvent event) {
    	this.numOfClasses = Integer.parseInt(enrolledC.getText());
    	enrolledC.clear();

    }

    @FXML
    void getFG(ActionEvent event) {
    	if(!finalG.getText().equals("")) {
	    	double savedValue = Double.parseDouble(finalG.getText());
	    	finalClassGrades.add(savedValue);
	    	finalG.clear();
    	}

    }

    @FXML
    void getDG(ActionEvent event) {
    	this.desiredGPA = Double.parseDouble(desiredG.getText());
    }

    
    @FXML
    void clickC(ActionEvent event) {
    	
    	GPACalculator calc = new GPACalculator(numOfClasses, finalClassGrades, desiredGPA);
    	gradeNeeded = calc.CalculateGPA();
    	
    	String str1 = Double.toString(desiredGPA);
    	String str2 = Double.toString(gradeNeeded);
    	
    	maintainG.setText(str1);
    	neededG.setText(str2);

    }

}
