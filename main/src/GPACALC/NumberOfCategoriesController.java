package GPACALC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import Backend.GPACalculator;
import GPACALC.GpaButton1Controller;




public class NumberOfCategoriesController {
	
		
	 	GPACalculator calc1 = new GPACalculator();
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
	    	
	    	
	    	weightCategory.clear();
	    	displayWeight.setText(null);
	    	inputComponent.clear();
	    	numComp.setText(null);
	    	inputGrades.clear();
	    	gradesArray.setText(null);
	    	
	    	
	    	
	    }
	    
	    @FXML
	    void displayGrades(ActionEvent event) {
	    	double grade = Double.parseDouble(inputGrades.getText());
	    	calc1.allGrades.add(grade);
	    	gradesArray.setText(calc1.allGrades.toString());
	    	inputGrades.clear();

	    }
	    
	    
	    @FXML
	    void displayComponent(ActionEvent event) {
	    	int comp = Integer.parseInt(inputComponent.getText()); // not necessary?
	    	calc1.numCategoryComponents.add(comp);
	    	numComp.setText(inputComponent.getText());
	    	inputComponent.clear();

	    }
	    
	    @FXML
	    void displayWeight(ActionEvent event) {
	    	double weight = Double.parseDouble(weightCategory.getText());
	    	displayWeight.setText(weightCategory.getText());
	    	calc1.categoryWeights.add(weight);
	    	weightCategory.clear();

	    }


	}


