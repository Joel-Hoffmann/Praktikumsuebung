package main;

import guiTeeladen.TeeladenControl;
import guiWarenuebersicht.WarenuebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new TeeladenControl(primaryStage);
		Stage warenuebersicht = new Stage();
		new WarenuebersichtControl(warenuebersicht);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
