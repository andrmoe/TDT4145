package app.controller;

import app.database.DBStatements;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class LogController extends ControllerParent {
	
	@FXML DatePicker workoutDatePicker;
	@FXML ChoiceBox<String> groupChoiceBox, exerciseChoiceBox;
	@FXML TextField kiloText, settText;
	@FXML Button addExerciseButton, completeWorkoutButton;
	
	@FXML
	public void handleAddExercise() {
	
	}
	
	@FXML
	public void handleCompleteWorkout() {
		
	}
}
