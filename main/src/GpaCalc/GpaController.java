	package GpaCalc;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GpaController {

    @FXML
    private Button gpa1;

    @FXML
    private Button gpa2;

    @FXML
    void display1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GpaCalc/GPABUTTON1.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Calculating grade needed on assessment....");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void display2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GpaCalc/GPABUTTON2.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Calculating grade needed in course....");
        stage.setScene(scene);
        stage.show();
    }

}