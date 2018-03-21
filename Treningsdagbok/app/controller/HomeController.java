package app.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
	
	private void initialize() {
		
	}
	
	@FXML
	public void handleStartTraining(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		FXMLLoader logLoader = new FXMLLoader(getClass().getResource("/app/resources/Log.fxml")); 
		Parent root = logLoader.load();
		LogController logController = logLoader.getController();
		Scene log = new Scene(root);
		stage.setScene(log);

		
	}
	
	@FXML
	public void handleStatistics(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		FXMLLoader statLoader = new FXMLLoader(getClass().getResource("/app/resources/Stats.fxml")); 
		Parent root = statLoader.load();
		StatController statController = statLoader.getController();
		Scene stat = new Scene(root);
		stage.setScene(stat);

			
	}
	
	@FXML
	public void handleNew(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		FXMLLoader addNewLoader = new FXMLLoader(getClass().getResource("/app/resources/AddNew.fxml")); 
	    Parent root = addNewLoader.load();
	    AddNewController addNewController = addNewLoader.getController();
	    Scene log = new Scene(root);  
	    stage.setScene(log);
		
	}
}
