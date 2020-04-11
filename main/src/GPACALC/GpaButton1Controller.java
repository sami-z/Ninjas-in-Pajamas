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


public class GpaButton1Controller {
	
	
	private NumberOfCategoriesController controller;

	private static int numOfCategories;
	
    @FXML
    private TextField weightAssignment;
	
	@FXML
    private Text upcomingAssign;
	
	@FXML
    private Text displayWeight;
	
    @FXML
    private TextField typeA;
    
    @FXML
    private TextField numCate;

    @FXML
    private Button enterD;
    
    @FXML
    private Text displayResult;
    
    @FXML
    private Button buttonC;
    
    @FXML
    private TextField desiredG;
    
    @FXML
    private Text errorCat;
    
    @FXML
    private Text errorDG;
    
    
    
    
    

    @FXML
    void numCategories(ActionEvent event) {
    	int getNumCat = 0;
    	try {
    		getNumCat =Integer.parseInt(numCate.getText());
    		if(getNumCat >= 1) {
    			setNumOfCategories(getNumCat);
    			errorCat.setText("");
    		}else {
    			errorCat.setText("Number of categories must be a number >= 1");
    		}
    	}catch (Exception e) {
    		errorCat.setText("Number of categories must be a number >= 1");
    	}
    	

    }

    @FXML
    void enterData(ActionEvent event) throws IOException {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/GPACALC/NumberOfCategories.fxml"));
         Parent root = loader.load();
    	 controller = loader.<NumberOfCategoriesController>getController();
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.setScene(scene);
         stage.show();
         typeA.setDisable(false);
         weightAssignment.setDisable(false);
         desiredG.setDisable(false);
         buttonC.setDisable(false);
         
         
     }
    
    @FXML
    void getAsess(ActionEvent event) {
    	upcomingAssign.setText(typeA.getText());
    	getGPACalc().nameOfAssessment = typeA.getText();
    	typeA.clear();

    }
    
    
    @FXML
    void getWeightAssignment(ActionEvent event) {
    	double d = 0;
    	try {
    		d = Double.parseDouble(weightAssignment.getText());
    		if (d >= 1 && d <= 99) {
    			displayWeight.setText(weightAssignment.getText());
    			getGPACalc().neededCategoryWeight = Double.parseDouble(weightAssignment.getText());
    			weightAssignment.clear();
    		}else {
    			displayWeight.setText("Weight must be between 1 and 99");
    		}
    	}catch(Exception e) {
    		displayWeight.setText("Weight must be between 1 and 99");
    	}
    	
    }

	public static int getNumOfCategories() {
		return numOfCategories;
	}

	public void setNumOfCategories(int numOfCategories) {
		GpaButton1Controller.numOfCategories = numOfCategories;
	}
	
	public GPACalculator getGPACalc() {
		return controller.calc1;
		
	}
	
	
	@FXML
    void calculateGrade(ActionEvent event) {
		
		displayResult.setText(getGPACalc().calculatePercentNeeded());

    }
	
	

    @FXML
    void getDesiredG(ActionEvent event) {
    	double d = 0;
    	try {
    		d = Double.parseDouble(desiredG.getText());
    		if ( d>= 0 && d <= 100) {
    			getGPACalc().desiredCourseGrade = Double.parseDouble(desiredG.getText());
    			errorDG.setText("");
    			
    		}else {
    			errorDG.setText("Desired grade must be between 0 and 100");
    			
    		}
    		
    	}catch (Exception e) {
    		errorDG.setText("Desired grade must be between 0 and 100");
    	}
    	
    }
	
	

	

}

	
	
	
	
	
	
	
	



