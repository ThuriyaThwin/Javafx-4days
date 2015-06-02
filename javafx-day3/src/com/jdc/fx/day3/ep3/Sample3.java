package com.jdc.fx.day3.ep3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Sample3 extends Application implements Initializable {

	private static final String FXML = "Sample3.fxml";
	
	@FXML
	private Circle node;
	
	private Transition animation;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		node.setOnMouseClicked(a -> {
			doAmimation();
		});
	}
	
	private void doAmimation() {
		
		if(null == animation) {
			animation = getAnimation();
			animation.play();
		} else {
			if(animation.getStatus().equals(Status.RUNNING)) {
				animation.pause();
			} else {
				animation.play();
			}
		}
		
	}
	
	private Transition getAnimation() {
		// move up
		TranslateTransition moveUp = new TranslateTransition(Duration.seconds(1), node);
		moveUp.setFromY(0);
		moveUp.setToY(-300);
		moveUp.setInterpolator(Interpolator.EASE_OUT);
		
		// move down
		TranslateTransition moveDown = new TranslateTransition(Duration.seconds(1), node);
		moveDown.setToY(0);
		moveDown.setInterpolator(Interpolator.EASE_IN);
		
		ScaleTransition scaleSmall = new ScaleTransition(Duration.millis(50), node);
		scaleSmall.toYProperty().set(0.5);
		scaleSmall.setInterpolator(Interpolator.EASE_IN);
		
		TranslateTransition dip = new TranslateTransition(Duration.millis(50), node);
		dip.setFromY(0);
		dip.setToY(node.getRadius());

		ParallelTransition parallel = new ParallelTransition(scaleSmall, dip);
		
		ScaleTransition scaleLarge = new ScaleTransition(Duration.millis(50), node);
		scaleLarge.toYProperty().set(1.0);
		scaleLarge.setInterpolator(Interpolator.EASE_OUT);
		
		SequentialTransition upDown = new SequentialTransition(scaleLarge, moveUp, moveDown, parallel);
		upDown.setAutoReverse(true);
		upDown.setCycleCount(Timeline.INDEFINITE);
	
		return upDown;
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
