package PROFILE;

/**
 * This class is the controller for the FinanceProfile.fxml scene and it
 *  validates and stores the user input, this class also contains methods
 * that allow the ProfileController class to extract information from this controller
 */
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

	// A double containing the year tuition of the user
	private double tuitionInputFinal;
	
	// A double savings of the user
	private double savingsInputFinal;
	
	// A double containing the weekly income of the user
	private double weekIncomeInputFinal;
	
	// A double containing the weekly budget of the user
	private double weeklyBuget;
	
	// A double containing the long term amount of the user
	private double longAmountInputFinal;
	
	// Integer representing the number of months to reach the long term goal
	private int months;
	
	// The Scene object which contains the previous scene
	private Scene previousScene;
	
	// The Stage object of the currentStage the scene is on
	private Stage currentStage;
	
	// The TextField where the user input their monthly expenditure
    @FXML
    private TextField monthExpInput;

    //  The button where the user clicks once they are done inputting information
    @FXML
    private Button finishedButton;

    // The TextField where the user input their long term goal amount
    @FXML
    private TextField longAmountInput;

    // The TextField where the user input their weekly income amount
    @FXML
    private TextField weekIncomeInput;

    // The TextField where the user input their weekly expenditure amount
    @FXML
    private TextField weekExpInput;

    // The TextField where the user input the amount of time they want to reach there long term goal in 
    @FXML
    private TextField longMonthInput;

    // The TextField where the user inputs their savings amount
    @FXML
    private TextField savingsInput;

    // The TextField where the user inputs their weekly budget
    @FXML
    private TextField weekBudInput;

    // The TextField where the user inputs their tuition
    @FXML
    private TextField tuitionInput;
    
    // Text which displays input that the had user entered for their income
    @FXML
    private Text incomeText;
    
    // Text which displays input that the had user entered for the number of months
    @FXML
    private Text monthsText;
    
     // Text which displays input that the had user entered for their long term goal amount
    @FXML
    private Text longTermGoalText;
    
    // Text which displays input that the had user entered for their weekly budget
    @FXML
    private Text weeklyBudgetText;
    
    // Text which displays input that the had user entered for their weekly expenses
    @FXML
    private Text WeeklyCommasText;
    
    // Text which displays input that the had user entered for the monthly expenses
    @FXML
    private Text monthlyCommasText;
    
    // Text which displays input that the had user entered for tuition
    @FXML
    private Text tuitionText;
    
    // Text which displays input that the had user entered for their savings
    @FXML
    private Text savingText;
    
    // Master person object used to create a FinancePerson Object
    private MasterPerson p1;

    // ArrayList that contains the weekly expenses
	private ArrayList<Double> allWeeklyExpenses = new ArrayList<Double>();
	
	// ArrayList that contain the monthly expenses
	private ArrayList<Double> allMonthlyExpenses = new ArrayList<Double>();

	/**
	 * This method validates input for the tuition and saves the input only if the input is formatted correctly.
	 * 
	 * @param event - An action event that is triggered when the user presses enter after entering
     * input in the tuitionInput textfield
	 */
    @FXML
    void tuitionInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(tuitionInput.getText())) {
    		tuitionInputFinal = Double.parseDouble(tuitionInput.getText());
    		tuitionText.setText(" " + tuitionInputFinal);
    	}
    	else 
    		tuitionInput.setText("INVALID INPUT");
    }
    
	/**
	 * This method validates input for the tuition and saves the input only if the input is formatted correctly.
	 * 
	 * @param event - An action event that is triggered when the user presses enter after entering
     * input in the savingText textfield
	 */

    @FXML
    void savingsInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(savingsInput.getText())) {
    		savingsInputFinal = Double.parseDouble(savingsInput.getText());
    		savingText.setText(" " + savingsInputFinal);
    	}
    	
    	else 
    		savingsInput.setText("INVALID INPUT");
    }
    
    /**
     * This method sets an instance of MasterPerson to p1
     * @param person - The instance of MasterPerson that p1 is to be set to
     */
    
    public void setMasterPerson(MasterPerson person) 
    {
    	p1 = new MasterPerson(person);
    }
    
    
    /**
     * This method validates the input the user for the weekly expenses and checks if the input
     * is formatted so that each double is comma separated. Once the input is validated the method sets the value
     * allWeeklyExpenses ArrayList to the input entered
     * 
     * @param event - An action event that is triggered when the user presses enter after entering
     * input in the weekExpInput textfield
     */
    @FXML
    void weekExpInputPressed(ActionEvent event) {

    	try {
    		//Initializes values
	    	ArrayList<Double> allWeeklyExpense = new ArrayList<Double>();
	    	String weekExp = weekExpInput.getText();
	    	String[] weekExpArray = weekExp.split(",");
	    	
	    	// Checks if the input is valid
	    	for (String exp : weekExpArray) {
	    		String exp1 = exp.trim();
	    		Double expDouble = Double.parseDouble(exp1);
	    		if(expDouble<0)
	    			throw new NumberFormatException("Negative double");
	    		allWeeklyExpense.add(expDouble);
	    	}
	    	
	    	//Sets allWeeklyExpenses to allWeeklyExpense
	    	allWeeklyExpenses = allWeeklyExpense;
	    	
	    	// displays the ArrayList
	    	WeeklyCommasText.setText(allWeeklyExpenses.toString());
    	}
    	catch(Exception e) 
    	{
    		weekExpInput.setText("INVALID INPUT");
    	}
    }

    /**
     * This method validates the input the user for the monthly expenses and checks if the input
     * is formatted so that each double is comma separated. Once the input is validated the method sets the value
     * allMonthlyExpenses ArrayList to the input entered
     * 
     * @param event - An action event that is triggered when the user presses enter after entering
     * input in the weekExpInput textfield
     */
    @FXML
    void monthExpInputPressed(ActionEvent event) {
    	try {
    		//Initializes the values
	    	ArrayList<Double> allMonthlyExpense = new ArrayList<Double>();
	    	String monthExp = monthExpInput.getText();
	    	String[] monthExpArray = monthExp.split(",");
	    	
	    	// Validates the input
	    	for (String exp : monthExpArray) {
	    		String exp1 = exp.trim();
	    		Double expDouble = Double.parseDouble(exp1);
	    		if(expDouble<0)
	    			throw new NumberFormatException("Negative double");
	    		allMonthlyExpense.add(expDouble);
	    	}
	    	// displays the ArrayList and sets the value of allMonthlyExpenses
	    	allMonthlyExpenses = allMonthlyExpense;
	    	monthlyCommasText.setText(allMonthlyExpenses.toString());
    	}
    	catch(Exception e) 
    	{
    		monthExpInput.setText("INVALID INPUT");;
    	}
    }

	/**
	 * This method validates input for the weekly income amount and saves the input only if the input is formatted correctly.
	 * 
	 * @param event - An action event that is triggered when the user presses enter after entering
     * input in the incomeText textfield
	 */
    
    @FXML
    void weekIncomeInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(weekIncomeInput.getText())) {
    		weekIncomeInputFinal = Double.parseDouble(weekIncomeInput.getText());
    		incomeText.setText(" " + weekIncomeInputFinal);
    	}
    	
    	else 
    		weekIncomeInput.setText("INVALID INPUT");
    }

	/**
	 * This method validates input for the weekly budget amount and saves the input only if the input is formatted correctly.
	 * 
	 * @param event - An action event that is triggered when the user presses enter after entering
     * input in the weeklyBudgetText textfield
	 */
    @FXML
    void weekBudInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(weekBudInput.getText())) {
    		weeklyBuget = Double.parseDouble(weekBudInput.getText());
    		weeklyBudgetText.setText(" "+ weeklyBuget);
    	}
    	else 
    		weekBudInput.setText("INVALID INPUT");
    }

    
	/**
	 * This method validates input for the long term amount and saves the input only if the input is formatted correctly.
	 * 
	 * @param event - An action event that is triggered when the user presses enter after entering
     * input in the longTermGoalText textfield
	 */
    @FXML
    void longAmountInputPressed(ActionEvent event) {
    	if(ValidateFinanceInput(longAmountInput.getText())) {
    		longAmountInputFinal = Double.parseDouble(longAmountInput.getText());
    		longTermGoalText.setText(" " + longAmountInputFinal);
    	}
    	else 
    		longAmountInput.setText("INVALID INPUT");
    }

    /**
     * Once the user clicked enter this method validates the input for
     * the number of months for the long term goal. Once the input is validated
     * 
     * @param event - An action event that is triggered when the user presses enter after entering
     * input in the months textfield
     */
    @FXML
    void longMonthInputPressed(ActionEvent event) {
    	try 
    	{
    		int month = Integer.parseInt(longMonthInput.getText());
    		if(month<1)
    			throw new NumberFormatException("Negative Integer");
    		else {
    			// Stores user input and displays it on screen
    			months = month;
    			monthsText.setText(" " + months);
    		}
    			
    	}
    	catch(NumberFormatException nfe)
    	{
    		longMonthInput.setText("INVALID INPUT");
    	}
    }

    
    /**
     * This method brings the user back to the main menu once the information
     * for the finance scene has been entered
     * 
     * @param event - An ActionEvent object that is passed into the method
     * when the finish button is clicked
     */
    @FXML
    void finishedButtonOnClick(ActionEvent event) {

    	currentStage.setScene(previousScene);
    	currentStage.show();
    }
    
    /**
     * This method is used to return a FinancePerson Object that contains the information present
     * in this scene
     * 
     * @return - A FinancePerson object that contains all the information that
     * was present in this scene
     */
    public FinancePerson getFinancePerson() 
    {
    	return new FinancePerson(p1.getName(), p1.getYOS(), p1.getMajor(), p1.getMinor(), tuitionInputFinal, savingsInputFinal, allWeeklyExpenses, allMonthlyExpenses, longAmountInputFinal, months, weekIncomeInputFinal, weeklyBuget);
    }
    
	/** double validateFinanceInput(Scanner input, String error)
	 * This method checks if the String input can be parsed into a Double, then checks if 
	 * the input is negative, which then throws a NumberFormatException error
	 * @return ret - A double which represents the correct input 
	 */
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
	
    /**
     * Setter method that is used to pass in the previous stage
     * 
     * @param c - The stage that the caller is passing in to the controller
     */
	public void setStage(Stage c) 
	{
		currentStage = c;
	}
	
    /**
     * Setter method that is used to set the previousScene instance variable
     * 
     * @param c - The previous scene that you want to go back to
     */
	public void setPreviousScene(Scene c) 
	{
		previousScene = c;
	}

}

