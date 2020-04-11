package PROFILE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import PROFILE.ProfileController;
import FNCECALC.FinanceCalculatorController;
import java.util.ArrayList;
import java.util.Scanner;

import Backend.FinancePerson;
import Backend.MasterPerson;

public class FinanceProfileController {

	private double tuitionInputFinal;
	private double savingsInputFinal;
	private double weekIncomeInputFinal;
	private double weeklyBuget;
	private double longAmountInputFinal;
	private int months;
	
	Scene previousScene;
	
	Stage currentStage;
	
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
    
    @FXML
    private Text incomeText;
    
    @FXML
    private Text monthsText;

    @FXML
    private Text longTermGoalText;
    
    @FXML
    private Text weeklyBudgetText;
    
    @FXML
    private Text WeeklyCommasText;

    @FXML
    private Text monthlyCommasText;

    @FXML
    private Text tuitionText;
    
    @FXML
    private Text savingText;
    
    MasterPerson p1;
    

    FinancePerson p3;
	ArrayList<Double> allWeeklyExpenses = new ArrayList<Double>();
	ArrayList<Double> allMonthlyExpenses = new ArrayList<Double>();

    @FXML
    void tuitionInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(tuitionInput.getText())) {
    		tuitionInputFinal = Double.parseDouble(tuitionInput.getText());
    		tuitionText.setText(" " + tuitionInputFinal);
    	}
    	else 
    		tuitionInput.setText("INVALID INPUT");
    }
    

    @FXML
    void savingsInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(savingsInput.getText())) {
    		savingsInputFinal = Double.parseDouble(savingsInput.getText());
    		savingText.setText(" " + savingsInputFinal);
    	}
    	
    	else 
    		savingsInput.setText("INVALID INPUT");
    }
    
    
    public void setMasterPerson(MasterPerson person) 
    {
    	p1 = new MasterPerson(person);
    }
    

    @FXML
    void weekExpInputPressed(ActionEvent event) {

    	try {
	    	ArrayList<Double> allWeeklyExpense = new ArrayList<Double>();
	    	String weekExp = weekExpInput.getText();
	    	String[] weekExpArray = weekExp.split(",");
	    	
	    	for (String exp : weekExpArray) {
	    		String exp1 = exp.trim();
	    		Double expDouble = Double.parseDouble(exp1);
	    		if(expDouble<0)
	    			throw new NumberFormatException("Negative double");
	    		allWeeklyExpense.add(expDouble);
	    	}
	    	allWeeklyExpenses = allWeeklyExpense;
	    	WeeklyCommasText.setText(allWeeklyExpenses.toString());
    	}
    	catch(Exception e) 
    	{
    		weekExpInput.setText("INVALID INPUT");
    	}
    }

    @FXML
    void monthExpInputPressed(ActionEvent event) {
    	try {
	    	ArrayList<Double> allMonthlyExpense = new ArrayList<Double>();
	    	String monthExp = monthExpInput.getText();
	    	String[] monthExpArray = monthExp.split(",");
	    	
	    	for (String exp : monthExpArray) {
	    		String exp1 = exp.trim();
	    		Double expDouble = Double.parseDouble(exp1);
	    		if(expDouble<0)
	    			throw new NumberFormatException("Negative double");
	    		allMonthlyExpense.add(expDouble);
	    	}
	    	allMonthlyExpenses = allMonthlyExpense;
    	}
    	catch(Exception e) 
    	{
    		monthExpInput.setText("INVALID INPUT");;
    	}
    }

    @FXML
    void weekIncomeInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(weekIncomeInput.getText())) {
    		weekIncomeInputFinal = Double.parseDouble(weekIncomeInput.getText());
    		incomeText.setText(" " + weekIncomeInputFinal);
    	}
    	
    	else 
    		weekIncomeInput.setText("INVALID INPUT");
    }

    @FXML
    void weekBudInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(weekBudInput.getText())) {
    		weeklyBuget = Double.parseDouble(weekBudInput.getText());
    		weeklyBudgetText.setText(" "+ weeklyBuget);
    	}
    	else 
    		weekBudInput.setText("INVALID INPUT");
    }

    @FXML
    void longAmountInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(longAmountInput.getText())) {
    		longAmountInputFinal = Double.parseDouble(longAmountInput.getText());
    		longTermGoalText.setText(" " + longAmountInputFinal);
    	}
    	else 
    		longAmountInput.setText("INVALID INPUT");
    }

    @FXML
    void longMonthInputPressed(ActionEvent event) {
    	try 
    	{
    		int month = Integer.parseInt(longMonthInput.getText());
    		if(month<1)
    			throw new NumberFormatException("Negative Integer");
    		else {
    			months = month;
    			monthsText.setText(" " + months);
    		}
    			
    	}
    	catch(NumberFormatException nfe)
    	{
    		longMonthInput.setText("INVALID INPUT");
    	}
    }

    @FXML
    void finishedButtonOnClick(ActionEvent event) {

    	currentStage.setScene(previousScene);
    	currentStage.show();
    }
    
    public FinancePerson getFinancePerson() 
    {
    	return new FinancePerson(p1.getName(), p1.getYOS(), p1.getMajor(), p1.getMinor(), tuitionInputFinal, savingsInputFinal, allWeeklyExpenses, allMonthlyExpenses, longAmountInputFinal, months, weekIncomeInputFinal, weeklyBuget);
    }
    
	private boolean ValidateFinanceInput(String input) 
	{
		double ret = -1;
		try {
			ret = Double.parseDouble(input);
			if(ret<0)
				throw new NumberFormatException("Negative double");
			return true;
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
	}
	
	public void setStage(Stage c) 
	{
		currentStage = c;
	}
	
	public void setPreviousScene(Scene c) 
	{
		previousScene = c;
	}

}

