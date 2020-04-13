package GUI_PACKAGE;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * The Main.java class loads the main page of the application through the fxml file GUI.fxml
 *  
 */


public class Main extends Application {
	/**
     * This method loads the scene
     * 
     * @param primaryStage - Stage that is passed as an argument
     */
	@Override
	public void start(Stage primaryStage) {
		//load the scene
		try {
			AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("GUI.fxml"));
			primaryStage.setScene(new Scene (mainPane));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * This method launches the application
     * 
     * @param args - command line argument that is passed
     */
	public static void main(String[] args) {
		launch(args);
	}

	
}
