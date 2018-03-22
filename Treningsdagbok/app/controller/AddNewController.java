package app.controller;

import java.sql.SQLException;

import app.database.DBConnect;
import app.database.DBStatements;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddNewController extends ControllerParent{
	
	@FXML TextField exerciseNameField, exerciseDescField, apparatNameField, apparatDescField, groupNameField;
	@FXML ChoiceBox<String> apparatPicker, groupPicker;
	
	
	public void initialize() {
		
	}
	
	@FXML 
	private void handleAddExercise() throws SQLException {
		if (apparatPicker.getSelectionModel().getSelectedItem() != null) {
			String apparatId = apparatPicker.getSelectionModel().getSelectedItem();
		} else {
			int apparatId = -1;
		}
		DBConnect con = new DBConnect();
		String query = DBStatements.newExercise(exerciseNameField.getText(), exerciseDescField.getText(), apparatId)
		
	}
	
	@FXML 
	private void handleAddApparat() throws SQLException {
		DBConnect con = new DBConnect();
		String query = DBStatements.newApparat(exerciseNameField.getText(), exerciseDescField.getText());
		con.updateRecords(query);
		con.close();
	}
	
	@FXML 
	private void handleAddGroup() throws SQLException {
		DBConnect con = new DBConnect();
		String query = DBStatements.newGroup(groupNameField.getText());
		con.updateRecords(query);
		con.close();
	}


}
