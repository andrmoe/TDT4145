package app.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerParent {

	@FXML public void handleBack(ActionEvent e) throws IOException{
		FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/app/resources/Home.fxml")); 
        Parent root = homeLoader.load();
        Scene home = new Scene(root);
		Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();

        stage.setScene(home);
        stage.show();
	}
}
