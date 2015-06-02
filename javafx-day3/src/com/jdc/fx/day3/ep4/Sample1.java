package com.jdc.fx.day3.ep4;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Sample1 extends Application implements Initializable{
	
	private static final String FXML = "Sample1.fxml";

	@FXML
	private ImageView bird;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			// flying
			Timeline fly = this.getFlying();
			
			// moving
			Transition move = this.getMoving();
			
			ParallelTransition animation = new ParallelTransition(fly, move);
			
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.setAutoReverse(true);
			animation.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Transition getMoving() {
		TranslateTransition move = new TranslateTransition(Duration.millis(3000), bird);
		move.fromXProperty().set(800);
		move.toXProperty().set(-350);
		move.setCycleCount(Timeline.INDEFINITE);
		return move;
	}
	
	private Timeline getFlying() throws IOException {
		Image b1Image = new Image(Files.newInputStream(Paths.get("bird1.png"), StandardOpenOption.READ));
		Image b2Image = new Image(Files.newInputStream(Paths.get("bird2.png"), StandardOpenOption.READ));
		
		KeyFrame frame1 = new KeyFrame(Duration.ZERO, new KeyValue(bird.imageProperty(), b1Image));
		KeyFrame frame2 = new KeyFrame(Duration.millis(50), new KeyValue(bird.imageProperty(), b2Image));
		KeyFrame frame3 = new KeyFrame(Duration.millis(100), new KeyValue(bird.imageProperty(), b1Image));
		
		Timeline flying = new Timeline(frame1, frame2, frame3);
		
		flying.setRate(0.7);
		flying.setAutoReverse(true);
		flying.setCycleCount(Timeline.INDEFINITE);
		
		return flying;
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

}
