package app;

import app.controller.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TreningsdagbokApp extends Application {

	Stage stage;
	Scene home, logTraining, statistics, newExerciseScene, addApparat, addGroup;
	
	@Override
    public void start(Stage stage) throws Exception{
		
		//Home
		
		FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/app/resources/Home.fxml")); 
        Parent root = homeLoader.load();
        HomeController homeController = homeLoader.getController();
        Scene home = new Scene(root);
        stage.setScene(home);
        stage.show();
    }
	

	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}