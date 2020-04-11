package PROFILE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import PROFILE.ProfileController;
import FNCECALC.FinanceCalculatorController;
import java.util.ArrayList;

import Backend.FinancePerson;
import Backend.MasterPerson;

public class FinanceProfileController {

    @FXML
    private TextField monthExpInput;

    @FXML
    private Button finishedButton;

    @FXML
    private TextField longAmountInput;

    @FXML
    private TextField weekIncomeInput;

    @FXML
    private TextField weekExpInput;

    @FXML
    private TextField longMonthInput;

    @FXML
    private TextField savingsInput;

    @FXML
    private TextField weekBudInput;

    @FXML
    private TextField tuitionInput;
    
    MasterPerson p1;
    

    FinancePerson p3;
	ArrayList<Double> allWeeklyExpenses = new ArrayList<Double>();
	ArrayList<Double> allMonthlyExpenses = new ArrayList<Double>();

    @FXML
    public double tuitionInputPressed(ActionEvent event) {
    	
    	double tuition = Double.parseDouble(tuitionInput.getText());
    	return tuition;
    }

    @FXML
    void savingsInputPressed(ActionEvent event) {

    }
    
    
    public void setMasterPerson(MasterPerson person) 
    {
    	p1 = new MasterPerson(person);
    }
    

    @FXML
    void weekExpInputPressed(ActionEvent event) {

    	ArrayList<Double> allWeeklyExpense = new ArrayList<Double>();
    	String weekExp = weekExpInput.getText();
    	String[] weekExpArray = weekExp.split(",");
    	
    	for (String exp : weekExpArray) {
    		String exp1 = exp.trim();
    		Double expDouble = Double.parseDouble(exp1);
    		allWeeklyExpense.add(expDouble);
    	}
    	allWeeklyExpenses = allWeeklyExpense;
    }

    @FXML
    void monthExpInputPressed(ActionEvent event) {

    	ArrayList<Double> allMonthlyExpense = new ArrayList<Double>();
    	String monthExp = monthExpInput.getText();
    	String[] monthExpArray = monthExp.split(",");
    	
    	for (String exp : monthExpArray) {
    		String exp1 = exp.trim();
    		Double expDouble = Double.parseDouble(exp1);
    		allMonthlyExpense.add(expDouble);
    	}
    	allMonthlyExpenses = allMonthlyExpense;
    }

    @FXML
    void weekIncomeInputPressed(ActionEvent event) {

    }

    @FXML
    void weekBudInputPressed(ActionEvent event) {

    }

    @FXML
    void longAmountInputPressed(ActionEvent event) {

    }

    @FXML
    void longMonthInputPressed(ActionEvent event) {

    }

    @FXML
    void finishedButtonOnClick(ActionEvent event) {

    	
    }
    
    public FinancePerson getFinancePerson() 
    {
    	return new FinancePerson(p1.getName(), p1.getYOS(), p1.getMajor(), p1.getMinor(), Double.parseDouble(tuitionInput.getText()), Double.parseDouble(savingsInput.getText()), allWeeklyExpenses, allMonthlyExpenses, Double.parseDouble(longAmountInput.getText()), Integer.parseInt(longMonthInput.getText()), Double.parseDouble(weekIncomeInput.getText()), Double.parseDouble(weekBudInput.getText()));
    }

}

