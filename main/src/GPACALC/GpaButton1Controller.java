package GPACALC;

import Backend.GPACalculator;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class GpaButton1Controller {
	
	
	@FXML
    private Text desiredGRADE;
	
	@FXML
	private Text weightA;
	
	@FXML
    private Text upCOMING;
	
	@FXML
	private Text compGRADE;
	
	@FXML
    private Text numGCAT;
	
    @FXML
    private Text wCAT;
    
    @FXML
    private Text catNUM;
	
	
	@FXML
    private Text output;
	
	@FXML
	private Text requiredG;
	
	@FXML
	private TextField weightAssesment;
	
	@FXML
	private TextField assesment;
	
	@FXML
	private TextField componentG;
	 
	@FXML
    private TextField components;

	@FXML
    private TextField weightC;

	@FXML
    private TextField numCat;
	
	@FXML
	private Button computeButton;
	
	@FXML
    private Text maintainOutput;

  
	
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
    
    
    private double desiredClassGrade;
    private double numCategory;
    GPACalculator calc1 = new GPACalculator();
    
    
    
	int numGradeCategories;
	ArrayList<Integer> numCategoryComponents = new ArrayList<Integer>();
	ArrayList<Double> allGrades = new ArrayList<Double>();
	ArrayList<Double> categoryWeights = new ArrayList<Double>();
	double neededCategoryWeight;
	double desiredCourseGrade;
	String nameOfAssessment;
	Double assesmentWeight;

    
    

    @FXML
    void getVal2(ActionEvent event) {
    	this.desiredClassGrade = Double.parseDouble(desiredG.getText());
    	calc1.desiredCourseGrade = this.desiredClassGrade;
    	desiredGRADE.setText(desiredG.getText());
    	

    }
    
    @FXML
    void weightCategory(ActionEvent event) {
    	double weight = Double.parseDouble(weightC.getText());
    	calc1.categoryWeights.add(weight);
    	weightC.clear();
    	wCAT.setText(calc1.categoryWeights.toString());
    	
    }

    @FXML
    void computeGrade(ActionEvent event) {
    	String res = calc1.calculatePercentNeeded();
    	output.setText(res);
    	
    }
    
    @FXML
    void getNumCat(ActionEvent event) {
    	this.numCategory = Double.parseDouble(numCat.getText());
    	numGCAT.setText(numCat.getText());
    
    }
    
    @FXML
    void numComponents(ActionEvent event) {
    	int component = Integer.parseInt(components.getText());
    	calc1.numCategoryComponents.add(component);
    	components.clear();
    	catNUM.setText(calc1.numCategoryComponents.toString());

    }
    
    
    @FXML
    void getComponentG(ActionEvent event) {
    	double cG = Double.parseDouble(componentG.getText());
    	calc1.allGrades.add(cG);
    	componentG.clear();
    	compGRADE.setText(calc1.allGrades.toString());
    }
    
    
    @FXML
    void getAssesment(ActionEvent event) {
    	String strAssesment= assesment.getText();
    	calc1.nameOfAssessment = strAssesment;
    	upCOMING.setText(strAssesment);
    	

    }
    
    @FXML
    void getWA(ActionEvent event) {
    	this.assesmentWeight = Double.parseDouble(weightAssesment.getText());
    	calc1.neededCategoryWeight = this.assesmentWeight;
    	weightA.setText(this.assesmentWeight.toString());
    }


}
