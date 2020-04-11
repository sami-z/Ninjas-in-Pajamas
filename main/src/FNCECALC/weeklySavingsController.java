package FNCECALC;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class weeklySavingsController {

	@FXML
    private Text displayResult2;

    public void setText(String s)
    {
    	displayResult2.setText(s);
    }
}
