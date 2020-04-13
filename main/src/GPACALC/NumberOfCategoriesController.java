package GPACALC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import Backend.GPACalculator;
import GPACALC.GpaButton1Controller;


/**
 * The NumberOfCategoriesController class is the controller for the NumberOfCategories.fxml file.
 * This class allows the user to enter the weight, number of components, and grade of each component
 * for each category 
 */

public class NumberOfCategoriesController {
		//Create a new ArrayList to store grades for use in calculation
		public ArrayList <Double> newGrades = new ArrayList<Double>();   ///PRIVACY LEAK!!!
		
		//Create instance of GPACalculator for use in calculations
	 	public GPACalculator calc1 = new GPACalculator();				//PRIVACY LEAK!!!
	 	
	 	//Number used to loop through categories
		private int num1 = 1;
		
		//displayWeight, is the text in the NumberOfCategoriesController.fxml file where the input entered in weightCategory
		//is displayed
		@FXML
		private Text displayWeight;
		
		//weightCategory, is the textfield in the NumberOfCategoriesController.fxml file where the user inputs the weight
		//of the category
		@FXML
	    private TextField weightCategory;
	
		//inputGrades, is the textfield in the NumberOfCategoriesController.fxml file where the user inputs the grades of each
		//component
		@FXML
		private TextField inputGrades;
	
		//inputComponent, is the textfield in the NumberOfCategoriesController.fxml file where the user inputs the number of 
		//components for the category
		@FXML
	    private TextField inputComponent;
	
		//numComp, is the text in the NumberOfCategoriesController.fxml file where the input entered in inputComponent is
		//displayed
		@FXML
		private Text numComp;
		
		//gradesArray, is the text in the NumberOfCategoriesController.fxml file where the input entered in inputGrades is 
		//displayed
		@FXML
		private Text gradesArray;

		//numCat, is the text in the NumberOfCategoriesController.fxml file where the number of the category for which the info
		//is being inputed is displayed 
	    @FXML
	    private Text numCat;
	    
	    //buttonA, is the button in the NumberOfCategoriesController.fxml file that the user presses to move on to the next
	    //category
	    @FXML
	    private Button buttonA;
	    
	    

	    /**
	     * This method allows the user to press a button and enter info for a new category
	     * 
	     * @param event - An action event that is triggered when the button buttonA is pressed
	     */ 
	    @FXML
	    void buttonADD(ActionEvent event) {
	    	//Get the number of categories from GpaButton1Controller
	    	int num0 = GpaButton1Controller.getNumOfCategories();
	    	if (num1 == num0) {
	    		buttonA.setText("Finish");
	    		Stage stage = (Stage)buttonA.getScene().getWindow();
	    		stage.close();
	    	}
	    	
	    	if (num1 < num0) {
	    		num1 = num1+1;
	    		numCat.setText(Integer.toString(num1));
	    	}
	    	
	    	if (num1 == num0) {
	    		buttonA.setText("Finish");
	    	}
	    	
	    	//Clear text and textfields
	    	weightCategory.clear();
	    	displayWeight.setText(null);
	    	inputComponent.clear();
	    	numComp.setText(null);
	    	inputGrades.clear();
	    	gradesArray.setText(null);
	    	newGrades.clear();
	    	
	    	
	    	
	    }
	    
	    /**
	     * This method displays the input entered in textfield inputGrades in
	     * text gradesArray
	     * 
	     * @param event - An action event that is triggered when input is entered in textfield inputGrades
	     */
	    @FXML
	    void displayGrades(ActionEvent event) {
	    	//Initialize grade to 0
	    	double grade = 0;
	    	try {
	    	//Get the input from inputGrades and store is as grade
	    	grade = Double.parseDouble(inputGrades.getText());
	    	if (grade >= 0 && grade <= 100) {
	    		//add grade to allGrades
	    		calc1.allGrades.add(grade);
	    		newGrades.add(grade);
	    		//set text of gradesArray
		    	gradesArray.setText(newGrades.toString());
		    	inputGrades.clear();
		    	
		    //if grade is not between 0 and 100 (inclusive), display error message in gradesArray
	    	}else {
	    		gradesArray.setText("Grade must be a value between 0 and 100");
	    	}
	    	
	    	//if grade is not a number, display error message in gradesArray
	    	}catch (Exception e) {
	    		gradesArray.setText("Grade must be a value between 0 and 100");
	    	}
	    	

	    }
	    
	    /**
	     * This method displays the input entered in textfield inputComponent in
	     * text numComp
	     * 
	     * @param event - An action event that is triggered when input is entered in textfield inputComponent
	     */
	    @FXML
	    void displayComponent(ActionEvent event) {
	    	//Initialize comp to 0
	    	int comp = 0;
	    	try {
	    		//Get the input from inputComponent and store it as comp
	    		comp =Integer.parseInt(inputComponent.getText()); 
		    	if (comp >= 1) {
		    		//add comp to numCategoryComponents
		    		calc1.numCategoryComponents.add(comp);
			    	numComp.setText(inputComponent.getText());
			    	inputComponent.clear();
			    	
			    //If comp is not >=1, display error message in numComp
		    	}else {
		    		numComp.setText("Invalid input: must be a number greater than or equal to 1");
		    		inputComponent.clear();
		    	}

	    	//If comp is not a number, display error message in numComp
	    	}catch (Exception e) {
	    		numComp.setText("Invalid input: must be a number greater than or equal to 1");
	    		
	    	}
	    	

	    }
	    
	    
	    /**
	     * This method displays the input entered in textfield weightCategory in
	     * text displayWeight
	     * 
	     * @param event - An action event that is triggered when input is entered in textfield weightCategory
	     */
	    @FXML
	    void displayWeight(ActionEvent event) {
	    	//Initialize weight to 0
	    	double weight = 0;
	    	try {
	    		//Get the input from weightCategory and store it as weight
	    		 weight = Double.parseDouble(weightCategory.getText());
	    		 if (weight >= 1 && weight <=99) {
	    			 //set text of displayWeight
	 	    		displayWeight.setText(weightCategory.getText());
	 	    		//add weight to ArrayList categoryWeights
	 		    	calc1.categoryWeights.add(weight);
	 		    	weightCategory.clear();
	 		
	 		//If weight is not between 1 and 99 (inclusive), display error message in displayWeight
	 	    }else {
	 	    	displayWeight.setText("Invalid weight: must be a number between 1 and 99");
	 	    }
	    	
	    	//If weight is not a number, display error message in displayWeight
	    	}catch( Exception e) {
	    		displayWeight.setText("Invalid weight: must be a number between 1 and 99");
	    	}
	    	
	    
	   



	    }
	}


