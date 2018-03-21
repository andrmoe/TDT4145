package app.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

public class StatController extends ControllerParent{
	
	@FXML Spinner<Integer> workoutsSpinner;
	@FXML ChoiceBox<String> exerciseChoiceBox;
	@FXML DatePicker startDatePicker, endDatePicker;
	@FXML Button lastWorkoutsButton, resultsButton;
	
	
	@FXML 
	public void handleLastWorkouts(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		FXMLLoader workoutsLoader = new FXMLLoader(getClass().getResource("/app/resources/WorkoutHistory.fxml")); 
		Parent root = workoutsLoader.load();
		WorkoutHistoryController workoutsController = workoutsLoader.getController();
		Scene workouts = new Scene(root);
		stage.setScene(workouts);

		
	}
	
	@FXML
	public void handleResults(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		FXMLLoader resultsLoader = new FXMLLoader(getClass().getResource("/app/resources/ResultsHistory.fxml")); 
		Parent root = resultsLoader.load();
		ResultsHistoryController resultsController = resultsLoader.getController();
		Scene results = new Scene(root);
		stage.setScene(results);
		
	}
	


}
