package com.jdc.fx.day3.ep2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.Bloom;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sample2 extends Application implements Initializable{

	private static final String FXML = "Sample2.fxml";
	
	@FXML
	private Text text;
	@FXML
	private Slider slide;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Bloom b = new Bloom(1.0);
		text.setEffect(b);
		b.thresholdProperty().bind(slide.valueProperty());
		
//		slide.valueProperty().addListener((a, b, c) -> {
//			Bloom bloom = new Bloom();
//			bloom.setThreshold(c.doubleValue());
//			text.setEffect(bloom);
//		});
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
