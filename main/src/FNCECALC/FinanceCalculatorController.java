package FNCECALC;

import Backend.FinancePerson;
import Backend.FinancialCalculator;
import PROFILE.ProfileController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.*;
import java.io.IOException;

/**
 * This class is the controller for the FNCE.fxml file. This class checks whether the user has clicked one of the five buttons,
 * and depending on the button is displays results based on what the user entered for their finances  
 */
public class FinanceCalculatorController {
	
	// The instance variable of the FinancialCalculator Object used to perform the calculations
	private FinancialCalculator c1;
	
	// The string that stores the calculated result
	private  String s;
	
	//The current stage the Scene is displayed on
	private Stage main;
	
	// The FinancePerson instance that is used to compute the calculations
	private FinancePerson person;
	
	
	// The Button Object used to change the Scene to display weekly expenditure calculation
	@FXML
	private Button weekExpButton;
	
	// The Button Object used to change the Scene to display weekly savings calculation
	@FXML
	private Button weekSavButton;
	
	// The Button Object used to change the Scene to display weekly budget calculation
	@FXML
	private Button weekBudButton;
	
	// The Button Object used to change the Scene to display long term goal calculation
	@FXML
	private Button longButton;
	
	// The Button object used to exit the FinanceCalculator
	@FXML
	private Button backButton;
	
	
	/**
	 * This method creates a Scene and changes the current Stage to that scene, the new scene
	 * contains information about the weekly expenditure calculation
	 * 
	 * @param event -  ActionEvent object that is passed when the weekExpButton is clicked
	 * @throws IOException - Potential IOException from loading the WeeklyExpend.fxml file
	 */
	@FXML
	public void weekExpButtonOnClick(ActionEvent event) throws IOException {
		
		// Loads the fxml scene
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FNCECALC/WeeklyExpend.fxml"));
		Parent root = loader.load();
		
		// creates an instance of the controller
		weeklyExpenditureController weeklyExpenditureControllerIn = loader.<weeklyExpenditureController>getController();
		
		Scene scene1 = new Scene(root);
		
		// Gets the weekly expenditure calculation
		s = c1.displayWeeklyExpenditure();
		
		// Set the text/stage/previous scene instance variables in the new scene
		weeklyExpenditureControllerIn.setText(s);
		weeklyExpenditureControllerIn.setStage(main);
		weeklyExpenditureControllerIn.setPreviousScene(weekBudButton.getScene());
		
		// Shows the scene
		main.setScene(scene1);
		main.show();
		
	}
	
	
	/**
	 * This method creates a Scene and changes the current Stage to that scene, the new scene
	 * contains information about the weekly savings calculation
	 * 
	 * @param event -  ActionEvent object that is passed when the weekExpButton is clicked
	 * @throws IOException - Potential IOException from loading the WeeklyExpend.fxml file
	 */
	@FXML
	public void weekSavButtonOnClick(ActionEvent event) throws IOException {
		// Loads the fxml scene
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FNCECALC/WeeklySavings.fxml"));
		Parent root = loader.load();
		
		// creates an instance of the controller for the WeeklySavings scene
		weeklySavingsController weeklySavingsControllerIn = loader.<weeklySavingsController>getController();
		Scene scene1 = new Scene(root);
		
		// Calculates the weekly savings
		s = c1.displayWeeklySavings();
		
		// Set the text/stage/previous scene instance variables in the new scene
		weeklySavingsControllerIn.setText(s);
		weeklySavingsControllerIn.setStage(main);
		weeklySavingsControllerIn.setPreviousScene(weekBudButton.getScene());
		
		// Shows the scene
		main.setScene(scene1);
		main.show();
		
	}

	
	/**
	 * This method creates a Scene and changes the current Stage to that scene, the new scene
	 * contains information about the weekly budget calculation
	 * 
	 * @param event -  ActionEvent object that is passed when the weekExpButton is clicked
	 * @throws IOException - Potential IOException from loading the WeeklyExpend.fxml file
	 */
	@FXML
	public void weekBudButtonOnClick(ActionEvent event) throws IOException {
		// Loads the fxml scene
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FNCECALC/WeeklyBudget.fxml"));
		Parent root = loader.load();
		
		// creates an instance of the controller for the weeklyBudget scene
		weeklyBudgetController weeklyBudgetControllerIn = loader.<weeklyBudgetController>getController();
		Scene scene1 = new Scene(root);
		
		// Calculates the weekly budget difference
		s = c1.displayWeeklyBudgetDiff();
		System.out.println(s);
		
		// Set the text/stage/previous scene instance variables in the new scene
		weeklyBudgetControllerIn.setText(s);
		weeklyBudgetControllerIn.setStage(main);
		weeklyBudgetControllerIn.setPreviousScene(weekBudButton.getScene());
		
		// Shows the scene
		main.setScene(scene1);
		main.show();
	}

	/**
	 * This method creates a Scene and changes the current Stage to that scene, the new scene
	 * contains information about the long term button calculation
	 * 
	 * @param event -  ActionEvent object that is passed when the weekExpButton is clicked
	 * @throws IOException - Potential IOException from loading the WeeklyExpend.fxml file
	 */
	@FXML
	public void longButtonOnClick(ActionEvent event) throws IOException {
		// Loads the fxml scene
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FNCECALC/LongtermGoal.fxml"));
		Parent root = loader.load();
		
		// creates an instance of the controller for the LongtermGoal scene
		longtermController longTermControllerIn = loader.<longtermController>getController();
		Scene scene1 = new Scene(root);
		
		// Calculates the how long it will take to reach the long term goal
		s = c1.displayLongTermGoalInfo();
		
		// Set the text/stage/previous scene instance variables in the new scene
		longTermControllerIn.setText(s);
		longTermControllerIn.setStage(main);
		longTermControllerIn.setPreviousScene(weekBudButton.getScene());
		
		// Shows the scene
		main.setScene(scene1);
		main.show();
	}

	
	/**
     * This method handles the event when the back button is clicked, it closes the stage
     * 
     * @param event - An ActionEvent object that is passed into the method when the BackButton is clicked
     */	
	
	@FXML
	public void backButtonOnClick(ActionEvent event) {
		main.close();
	}
	
	
	/**
	 * Precondition: setFinancePerson has been called
	 * This method is used to initialize the FinanceCalculator after the finance person has been set
	 */
	public void createFinancialCalculator()
	{
		c1 = new FinancialCalculator(person);
	}
	
	/**
	 * This method is used to pass the FinancePerson Object that the FinanceCalculator will operate
	 * on
	 * 
	 * @param person -  The FinancePerson that the FinanceCalculator gets the information for
	 */
	public void setFinancePerson(FinancePerson person) 
	{
		this.person = person;
	}
	
    /**
     * Setter method that is used to pass in the previous stage
     * 
     * @param currentStage - The stage that the caller is passing in to the controller
     */
	
	public void setStage(Stage currentStage) {
		// We do not create a new stage because we want to reference of the stage being passed in
    	main = currentStage;
    }
	
	
}
