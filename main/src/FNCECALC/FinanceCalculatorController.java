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

public class FinanceCalculatorController {
	
	FinancialCalculator c1;
	public String s;
	
	public Stage main;
	FinancePerson person;
	
	@FXML
	private Button weekExpButton;
	
	@FXML
	private Button weekSavButton;
	
	@FXML
	private Button weekBudButton;
	
	@FXML
	private Button longButton;
	
	@FXML
	private Button backButton;
	
	@FXML
    private Text displayResult1;
	
	@FXML
	void weekExpButtonOnClick(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FNCECALC/WeeklyExpend.fxml"));
		Parent root = loader.load();
		weeklyExpenditureController c2 = loader.<weeklyExpenditureController>getController();
		Scene scene1 = new Scene(root);
		s = c1.displayWeeklyExpenditure();
		c2.setText(s);
		main.setScene(scene1);
		main.show();
		
	}
	
	@FXML
	void weekSavButtonOnClick(ActionEvent event) {

	}

	@FXML
	void weekBudButtonOnClick(ActionEvent event) {

	}

	@FXML
	void longButtonOnClick(ActionEvent event) {

	}

	@FXML
	void backButtonOnClick(ActionEvent event) {

	}
	
	public void createFinancialCalculator()
	{
		c1 = new FinancialCalculator(person);
	}
	
	public void setFinancePerson(FinancePerson person) 
	{
		this.person = person;
	}
	
	public void setStage(Stage or) {
    	main = or;
    }
	
	
}
