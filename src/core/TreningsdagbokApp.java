package database;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TreningsdagbokApp extends Application {

	Stage stage;
	Scene home, logTraining, statistics, newExerciseScene, addApparat, addGroup;
	
	@Override
    public void start(Stage stage) throws Exception{
		
		//Home
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
		home = new Scene(root, 500, 500);
        stage.setTitle("Treningsdagbok");
        
        //newExercise
        VBox newExerciseRoot = new VBox();
        newExerciseRoot.setAlignment(Pos.CENTER);
        newExerciseRoot.setSpacing(10);
        newExerciseScene = new Scene(newExerciseRoot, 500, 500);
        
        
        Button startTrening = new Button("Start trening");
        Button statistikk = new Button("Statistikk");
        Button newExercise = new Button("Ny øvelse");
        Button newApparat = new Button("Nytt apparat");
        Button newGroup = new Button("Ny øvelsesgruppe");
        
        
        root.getChildren().addAll(startTrening, statistikk, newExercise, newApparat, newGroup);
        
        newExercise.setOnAction(new EventHandler <ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		switchScene(newExerciseScene);
        	}
        });
             
        
        stage.setScene(home);
        stage.show();
    }
	
	private void switchScene(Scene scene) {
		this.stage.setScene(scene);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
