package PROFILE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    @FXML
    void tuitionInputPressed(ActionEvent event) {
    	
    	double tuition = Double.parseDouble(tuitionInput.getText());
    }

    @FXML
    void savingsInputPressed(ActionEvent event) {

    }

    @FXML
    void weekExpInputPressed(ActionEvent event) {

    }

    @FXML
    void monthExpInputPressed(ActionEvent event) {

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

}

