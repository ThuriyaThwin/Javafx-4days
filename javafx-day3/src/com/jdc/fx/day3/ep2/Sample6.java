package com.jdc.fx.day3.ep2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.stage.Stage;

public class Sample6 extends Application implements Initializable{
	
	private static final String FXML = "Sample6.fxml";
	@FXML
	private Group text;
	@FXML
	private Slider slider;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Distant light = new Distant();
		light.setAzimuth(-135);

		Lighting effect = new Lighting();
		effect.setLight(light);
		effect.surfaceScaleProperty().bind(slider.valueProperty());
		
		text.setEffect(effect);
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
