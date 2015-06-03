package com.jdc.fx.day3.ep2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.effect.BlendMode;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Sample1 extends Application implements Initializable{
	
	private static final String FXML = "Sample1.fxml";

	@FXML
	private Circle circle;
	
	@FXML
	private ListView<BlendMode> blends;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		blends.getItems().addAll(BlendMode.values());
		blends.getSelectionModel().selectedItemProperty().addListener((a, b, c) -> {
			circle.setBlendMode(c);
		});
	}

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
