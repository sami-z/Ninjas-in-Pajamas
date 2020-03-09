package GPACALC;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class GPABUTTON2CONTROLLER {

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
    
    
    private ArrayList<Double> allGrade = new ArrayList<Double>();
    private int numGradeCategories;
	private double desiredGPA;
	private double gradeNeeded;

    @FXML
    void getEC(ActionEvent event) {
    	this.numGradeCategories = Integer.parseInt(enrolledC.getText());
    	enrolledC.clear();
    	
    }

    @FXML
    void getFG(ActionEvent event) {
    	if(!finalG.getText().equals("")) {
    		double initialV = Double.parseDouble(finalG.getText());
	    	allGrade.add(initialV);
	    	finalG.clear();
    	}

    }

    @FXML
    void getDG(ActionEvent event) {
    	this.desiredGPA = Double.parseDouble(desiredG.getText());
    }

    
    @FXML
    void clickC(ActionEvent event) {
    
    //////////////////////////////////////////
    	
    	GPACalculator calc = new GPACalculator();
    	
    	double average = 0;
		for(int i = 0; i<allGrade.size();i++) 
		{
			average+=allGrade.get(i);
		}
		
		double newAve = average/allGrade.size();

    	
    	double gradeNeeded = (desiredGPA* (allGrade.size()+1))-(newAve*allGrade.size());    	
    	
    	String str1 = Double.toString(desiredGPA);
    	String str2 = Double.toString(gradeNeeded);
    	
    	maintainG.setText(str1);
    	if (gradeNeeded >4.0) {
    		neededG.setText("You cannot get that grade from one class");
    	}else {
    	neededG.setText(str2);
    	}

    }
	}


