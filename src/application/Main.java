package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {
	public static Button btImport;
	@Override
	public void start(Stage primaryStage) {
		try {
			RootBorderPane root = new RootBorderPane();
			Scene scene = new Scene(root,400,400);
//			primaryStage.setAlwaysOnTop(true);
			primaryStage.setTitle("Rechner");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showAlert(String message) {
		Alert alert = new Alert(AlertType.WARNING,message);
		alert.setHeaderText(null);
		alert.setTitle(null);
		alert.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
