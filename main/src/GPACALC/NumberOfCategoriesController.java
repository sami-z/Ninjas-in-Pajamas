package GPACALC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

import Backend.GPACalculator;
import GPACALC.GpaButton1Controller;




public class NumberOfCategoriesController {
	
		public ArrayList <Double> newGrades = new ArrayList<Double>();
	 	public GPACalculator calc1 = new GPACalculator();
	 	
		private int num1 = 1;
		
		@FXML
		private Text displayWeight;
		
		@FXML
	    private TextField weightCategory;
	

		@FXML
		private TextField inputGrades;
	
		@FXML
	    private TextField inputComponent;
	
		@FXML
		private Text numComp;
		
		@FXML
		private Text gradesArray;

	    @FXML
	    private Text numCat;

	    @FXML
	    private Button buttonA;
	    
	    

	    @FXML
	    void buttonADD(ActionEvent event) {
	    	int num0 = GpaButton1Controller.getNumOfCategories();
	    	if (num1 < num0) {
	    		num1 = num1+1;
	    		numCat.setText(Integer.toString(num1));
	    	}
	    	
	    	if (num1 == num0) {
	    		buttonA.setText("Finish");
	    	}
	    	
	    	
	    	weightCategory.clear();
	    	displayWeight.setText(null);
	    	inputComponent.clear();
	    	numComp.setText(null);
	    	inputGrades.clear();
	    	gradesArray.setText(null);
	    	newGrades.clear();
	    	
	    	
	    	
	    }
	    
	    @FXML
	    void displayGrades(ActionEvent event) {
	    	double grade = Double.parseDouble(inputGrades.getText());
	    	if (grade >= 0 && grade <= 100) {
	    		calc1.allGrades.add(grade);
	    		newGrades.add(grade);
		    	gradesArray.setText(newGrades.toString());
		    	inputGrades.clear();	
	    	}else {
	    		gradesArray.setText("Grade must be between 0 and 100");
	    	}
	    	

	    }
	    
	    
	    @FXML
	    void displayComponent(ActionEvent event) {
	    	int comp = Integer.parseInt(inputComponent.getText()); // not necessary?
	    	if (comp >= 1) {
	    		calc1.numCategoryComponents.add(comp);
		    	numComp.setText(inputComponent.getText());
		    	inputComponent.clear();
	    	}else {
	    		numComp.setText("Invalid input: must have at least 1 component");
	    		inputComponent.clear();
	    	}

	    }
	    
	    @FXML
	    void displayWeight(ActionEvent event) {
	    	double weight = 0;
	    	try {
	    		 weight = Double.parseDouble(weightCategory.getText());
	    		 if (weight >= 1 && weight <=99) {
	 	    		displayWeight.setText(weightCategory.getText());
	 		    	calc1.categoryWeights.add(weight);
	 		    	weightCategory.clear();
	 	    }else {
	 	    	displayWeight.setText("Invalid weight: must be a number between 1 and 99");
	 	    }
	    	}catch( Exception e) {
	    		displayWeight.setText("Invalid weight: must be a number between 1 and 99");
	    	}
	    	
	    
	   



	    }
	}


