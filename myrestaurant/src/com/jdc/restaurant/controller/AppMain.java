package com.jdc.restaurant.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// get fxml name
		String fxml = String.format("%s.fxml", OrderController.class.getSimpleName());

		// load fxml
		Parent p = FXMLLoader.load(getClass().getResource(fxml));

		// create scene
		Scene s = new Scene(p);

		// set scene to stage
		primaryStage.setScene(s);

		// show stage
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
