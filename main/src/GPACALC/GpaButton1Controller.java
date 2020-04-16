package GPACALC;

import Backend.GPACalculator;
import ClubFinder.ClubMainInterfaceController;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import GPACALC.NumberOfCategoriesController;

/**
 * The GpaButton1Controller class is the controller for the GPABUTTON1.fxml file.
 * This class sets the information to be sent to calculate the percent needed to maintain a grade
 */
public class GpaButton1Controller {
	
	//Controller to access NumberOfCategoriesController
	private NumberOfCategoriesController controller;
	
	//Store number of categories to be used by NumberOfCategoriesController.java
	private static int numOfCategories;
	
	//weightAssignment, is the TextField in the GPABUTTON1.fxml file where the user inputs the weight of an upcoming assessment
    @FXML
    private TextField weightAssignment;
	
    //upcomingAssign, is the text in the GPABUTTON1.fxml where the upcoming assignment entered in typeA is displayed
	@FXML
    private Text upcomingAssign;
	
	//displayWeight, is the text in the GPABUTTON1.fxml where the weight entered in weightAssign is displayed
	@FXML
    private Text displayWeight;
	
	//typeA, is the text field in the GPABUTTON1.fxml file where the user inputs the type of assesment they wish to calculate for
    @FXML
    private TextField typeA;
    
    //numcCate, is the textField in the GPABUTTON1.fxml file where the user inputs the number of grade categories in their course
    @FXML
    private TextField numCate;
    
    //enterD, is the button in the GPABUTTON1.fxml file that the user presses to display NumberOfCategories.fxml,
    //and enter information for each category
    @FXML
    private Button enterD;
    
    //displayResult, is the text in the GPABUTTON1.fxml file that displays the percent needed to maintain on an upcoming assessment
    //to maintain a grade
    @FXML
    private Text displayResult;
    
    //buttonC, is the button in the GPABUTTON1.fxml file that is pressed to calculate the percent needed to maintain on an upcoming
    //assessment to maintain a grade. Once pressed, result is displayed in the text displayResult
    @FXML
    private Button buttonC;
    
    //desiredG, is the textfield in the GPABUTTON1.fxml file where the user inputs their desired grade for the class
    @FXML
    private TextField desiredG;
    
    //errorCat, is the text in the GPABUTTON1.fxml file that displays the number of categories the user has entered in numCate
    @FXML
    private Text errorCat;
    
    //errorDG, is the text in the GPABUTTON1.fxml file that displays the desired grade the user has entered in desiredG
    @FXML
    private Text errorDG;
    
    //name of the assessment
    private String assesmentName = "";
    
     
    
    /**
     * This method stores the number entered in numCate as the variable
     * getNumCat to be accessed later
     * 
     * @param event - An action event that is triggered when something is entered in numCate
     */
    @FXML
    public void numCategories(ActionEvent event) {
    	//Initialize getNumCat to 0
    	int getNumCat = 0;
    	try {
    		//Get the input from numCate and store is as getNumCat
    		getNumCat =Integer.parseInt(numCate.getText());
    		if(getNumCat >= 1) {
    			//Send getNumCat to method setNumOfCategories if getNumCat >=1
    			setNumOfCategories(getNumCat);
    			errorCat.setText("");
    			
    		//If getNumCat is not >=1, display an error message
    		}else {
    			errorCat.setText("Number of categories must be a number >= 1");
    		}
    	
    	//If getNumCat is not an integer, display an error message
    	}catch (Exception e) {
    		errorCat.setText("Number of categories must be a number >= 1");
    	}
    	

    }
    
    /**
     * This method loads the scene NumberOfCategories.fxml 
     * 
     * @param event - An action event that is triggered when the button enterD is pressed
     */
    @FXML
    public void enterData(ActionEvent event) throws IOException {
    	//Load scene
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/GPACALC/NumberOfCategories.fxml"));
         Parent root = loader.load();
    	 controller = loader.<NumberOfCategoriesController>getController();
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.setScene(scene);
         stage.show();
         
         //Re-enables textfields after button enterD is pressed
         typeA.setDisable(false);
         weightAssignment.setDisable(false);
         desiredG.setDisable(false);
         buttonC.setDisable(false);         
     }
    
    /**
     * This method displays the assessment entered in textfield typeA in
     * text upcomingAssign
     * 
     * @param event - An action event that is triggered when input is entered in textfield typeA
     */
    @FXML
    public void getAsess(ActionEvent event) {
    	//set text upcomingAssign to entered value of typeA
    	upcomingAssign.setText(typeA.getText());
    	
    	assesmentName = typeA.getText();
    	
    	//store typeA as nameOfAssesment in calc1
    	
    	//clear the textfield 
    	typeA.clear();

    }
    
    /**
     * This method displays the weight of the assessment entered in textfield weightAssignment in
     * text displayWeight
     * 
     * @param event - An action event that is triggered when input is entered in textfield weightAssignment
     */
    @FXML
    public void getWeightAssignment(ActionEvent event) {
    	//Initialize d to 0
    	double d = 0;
    	try {
    		
    		//Get the input from weightAssignment and store it as d
    		d = Double.parseDouble(weightAssignment.getText());
    		if (d >= 1 && d <= 99) {
    			
    			//set the text for displayWeight
    			displayWeight.setText(weightAssignment.getText());
    			
    			//store neededCategoryWeight as input of weightAssignment
    			getGPACalc().setNeededCategoryWeight(Double.parseDouble(weightAssignment.getText()));
    			weightAssignment.clear();
    		
    		//If weight (d) is not between 1 and 99 (inclusive), display error message in displayWeight
    		}else {
    			displayWeight.setText("Weight must be between 1 and 99");
    		}
    	
    		//If weight (d) is a string, display error message in displayWeight
    	}catch(Exception e) {
    		displayWeight.setText("Weight must be between 1 and 99");
    	}
    	
    }
    
    /**
     * This method returns the instance variable numOfCategories
     * 
     * @return numOfCategories - returns the number of categories 
     */
	public static int getNumOfCategories() {
		return numOfCategories;
	}

	/**
     * This method sets the instance variable numOfCategories
     * 
     * @param numOfCategories - the number of categories currently enrolled in
     */
	public void setNumOfCategories(int numOfCategories) {
		GpaButton1Controller.numOfCategories = numOfCategories;
	}
	
	/**
     * This method returns the instance of GPACalculator
     * 
     * @return controller.calc1 - returns the instance of GPACalculator
     */
	public GPACalculator getGPACalc() {
		return controller.getGPACalc();
		
	}
	
	/**
     * This method displays the percent needed to maintain a grade in text displayResult
     * when button buttonC is pressed
     * 
     * @param event - An action event that is triggered when button buttonC is pressed
     */	
	@FXML
    public void calculateGrade(ActionEvent event) {
		//Set text displayResult to result of calculation
		getGPACalc().setNameOfAssessment(assesmentName);
		displayResult.setText(getGPACalc().calculatePercentNeeded());

    }
	
	
	/**
     * This method displays the desired grade entered in textfield desiredG in
     * text errorDG
     * 
     * @param event - An action event that is triggered when input is entered in textfield desiredG
     */
    @FXML
    public void getDesiredG(ActionEvent event) {
    	//Initialize d to 0
    	double d = 0;
    	
    	try {
    		//Set d to input entered in desiredG
    		d = Double.parseDouble(desiredG.getText());
    		if ( d>= 0 && d <= 100) {
    			getGPACalc().setDesiredCourseGrade(Double.parseDouble(desiredG.getText()));
    			errorDG.setText("");
    		
    		//Display error message if d is not between 0 and 100
    		}else {
    			errorDG.setText("Desired grade must be a number between 0 and 100");
    			
    		}
    	//If d is not a number, display an error message	
    	}catch (Exception e) {
    		errorDG.setText("Desired grade must be a number between 0 and 100");
    	}
    	
    }
	
	

	

}

	
	
	
	
	
	
	
	



