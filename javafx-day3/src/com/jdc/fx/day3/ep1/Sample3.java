package com.jdc.fx.day3.ep1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Sample3 extends Application {

	private static final String FXML = "Sample3.fxml";

	@Override
	public void start(Stage primaryStage) throws Exception {
		// load fxml
		Parent root = FXMLLoader.load(getClass().getResource(FXML));

		// create scene
		Scene scene = new Scene(root);

		// set scene to stage
		primaryStage.setScene(scene);
		
		// show stage
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
