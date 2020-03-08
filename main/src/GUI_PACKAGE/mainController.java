package GUI_PACKAGE;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import GUI_PACKAGE.Main;


public class mainController {

    @FXML
    public Button gpaClick; //private?????????
    
/*
    @FXML
    private AnchorPane topBar;

    @FXML
    void a12525(ActionEvent event) {

    }

   // @FXML
   // void 070707(ActionEvent event) {

  //  }
*/
    
    @FXML
   public void displayGPA(ActionEvent event) throws IOException {	
            Parent root = FXMLLoader.load(getClass().getResource("/GPACALC/GPA.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GPA CALCULATOR");
            stage.setScene(scene);
            stage.show();
            
        }
    	
    }

