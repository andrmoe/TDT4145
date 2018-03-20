package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
	
	@FXML
	public void handleStartTraining(ActionEvent event) throws IOException {
	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	FXMLLoader logLoader = new FXMLLoader(getClass().getResource("/resources/Log.fxml")); 
    Parent root = logLoader.load();
    LogController logController = logLoader.getController();
    Scene log = new Scene(root);
    
    stage.setScene(log);

		
	}
	
	@FXML
	public void handleStatistics(ActionEvent event) throws IOException {
	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	FXMLLoader statLoader = new FXMLLoader(getClass().getResource("/resources/Stats.fxml")); 
	Parent root = statLoader.load();
	StatController statController = statLoader.getController();
	Scene stat = new Scene(root);
	    
	stage.setScene(stat);

			
	}
	
	@FXML
	public void handleNewExercise() {
		
	}
	
	@FXML
	public void handleNewApparat() {
		
	}
	
	@FXML
	public void handleNewGroup() {
		
	}

}
