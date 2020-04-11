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
    void numCategories(ActionEvent event) {
    	int getNumCat = Integer.parseInt(numCate.getText());
    	setNumOfCategories(getNumCat);
    	

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
         
         
     }
    
    @FXML
    void getAsess(ActionEvent event) {
    	upcomingAssign.setText(typeA.getText());
    	getGPACalc().nameOfAssessment = typeA.getText();
    	typeA.clear();

    }
    
    
    @FXML
    void getWeightAssignment(ActionEvent event) {
    	displayWeight.setText(weightAssignment.getText());
    	getGPACalc().neededCategoryWeight = Double.parseDouble(weightAssignment.getText());
    	weightAssignment.clear();
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
    	getGPACalc().desiredCourseGrade = Double.parseDouble(desiredG.getText());
    }
	
	

	

}

	
	
	
	
	
	
	
	



