package com.jdc.fx.day3.ep2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Sample5 extends Application implements Initializable{

	private static final String FXML = "Sample5.fxml";
	@FXML
	private ImageView image;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		image.setOnMouseEntered(a -> {
			// reflection effect
			Reflection effect = new Reflection();
			effect.setTopOffset(3);
			effect.setTopOpacity(0.9);
			
			image.setEffect(effect);
		});
		
		image.setOnMouseExited(a -> {
			image.setEffect(null);
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
