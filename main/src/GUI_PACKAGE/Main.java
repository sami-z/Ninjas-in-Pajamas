package GUI_PACKAGE;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("GUI.fxml"));
			//Scene scene = new Scene(root,400,400);
			primaryStage.setScene(new Scene (mainPane));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			// mackenzie is awesome
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
