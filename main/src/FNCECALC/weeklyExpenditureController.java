package FNCECALC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import FNCECALC.FinanceCalculatorController;

/**
 * This class is the controller for the WeeklyExpend.fxml scene, it takes in the information about
 * weekly expenditure from FinanceCalculatorController and displays it in the scene.
 */
public class weeklyExpenditureController {

	// Instance variable that contains the previous scene
	private Scene previousScene;
	
	// Instance variable that contains the current stage
	private Stage currentStage;
	
	// The text that will display the calculated result
	@FXML
    private Text WeeklExpResult;

	/**
	 * This method sets the sets the text in WeeklExpResult to the calculation that we want
	 * to display
	 * 
	 * @param s - The string containing the weekly expenditure calculation
	 */
	
    public void setText(String s)
    {
    	WeeklExpResult.setText(s);
    }
    
    /**
     * Setter method that is used to pass in the previous stage
     * 
     * @param currentStage - The stage that the caller is passing in to the controller
     */
    
	public void setStage(Stage currStage) 
	{
		// We do not create a new stage because we want to reference of the stage being passed in
		currentStage = currStage;
	}
	
    /**
     * Setter method that is used to set the previousScene instance variable
     * 
     * @param scene - The previous scene that you want to go back to
     */
	public void setPreviousScene(Scene scene) 
	{
		// Note we do not create a new previous scene, because we want to save the state of the previous scene
		previousScene = scene;
	}

	/**
     * This method handles the event when the back button is clicked, it returns to the previous scene
     * 
     * @param event - An ActionEvent object that is passed into the method when the BackButton is clicked
     */	
	
    @FXML
    public void buttonOnClick(ActionEvent event) {
    	currentStage.setScene(previousScene);
    	currentStage.show();
    }
}