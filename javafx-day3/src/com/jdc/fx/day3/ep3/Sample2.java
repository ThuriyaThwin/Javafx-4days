package com.jdc.fx.day3.ep3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Sample2 extends Application implements Initializable{
	
	private static final String FXML = "Sample2.fxml";
	
	@FXML
	private Rectangle node;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// move left and right 4 times
		TranslateTransition move = new TranslateTransition(Duration.seconds(1), node);
		move.fromXProperty().set(-200);
		move.toXProperty().set(200);
		move.setAutoReverse(true);
		move.setCycleCount(4);
		
		// move to center
		TranslateTransition move2 = new TranslateTransition(Duration.seconds(1), node);
		move2.toXProperty().set(0);

		// rotate
		RotateTransition rotate = new RotateTransition(Duration.seconds(1), node);
		rotate.fromAngleProperty().set(0);
		rotate.toAngleProperty().set(360);;
		rotate.setCycleCount(Timeline.INDEFINITE);
		rotate.setInterpolator(Interpolator.LINEAR);
		
		SequentialTransition seq = new SequentialTransition(move, move2, rotate);
		seq.play();
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
