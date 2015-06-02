package com.jdc.fx.day3.ep3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Sample1 extends Application implements Initializable {

	private static final String FXML = "Sample1.fxml";

	private Transition trans;

	@FXML
	private Rectangle rec;
	@FXML
	private GridPane grid;

	public void startAnimation(String str) {
		
		stopTransition();

		switch (str) {
		case "FadeTransition":
			doFade();
			break;
		case "FillTransition":
			doFill();
			break;
		case "RotateTransition":
			doRotate();
			break;
		case "ScaleTransition":
			doScale();
			break;
		case "StrokeTransition":
			doStroke();
			break;
		case "TranslateTransition":
			doTranslate();
			break;
		default:
			break;
		}

	}

	private void doTranslate() {
		TranslateTransition ani = new TranslateTransition(Duration.millis(1000), rec);
		ani.fromXProperty().set(0);
		ani.toXProperty().set(100);
		
		ani.setAutoReverse(true);
		startTransition(ani);
	}

	private void doStroke() {
		StrokeTransition ani = new StrokeTransition(Duration.millis(1000), rec);
		ani.fromValueProperty().set(Color.BEIGE);
		ani.toValueProperty().set(Color.BROWN);
		
		ani.setAutoReverse(true);
		startTransition(ani);
	}

	private void doScale() {
		ScaleTransition ani = new ScaleTransition(Duration.millis(1000), rec);
		ani.fromXProperty().set(0.1);
		ani.toXProperty().set(1);
		ani.fromYProperty().set(0.1);
		ani.toYProperty().set(1);
		
		ani.setAutoReverse(true);
		startTransition(ani);
	}

	private void doRotate() {
		RotateTransition ani = new RotateTransition(Duration.millis(1000), rec);
		ani.fromAngleProperty().set(0);
		ani.toAngleProperty().set(360);
		startTransition(ani);
	}

	private void doFill() {
		FillTransition ani = new FillTransition(Duration.millis(1000), rec);
		ani.fromValueProperty().set(Color.AQUA);
		ani.toValueProperty().set(Color.BLUE);
		ani.setAutoReverse(true);
		startTransition(ani);
	}

	private void doFade() {
		FadeTransition ani = new FadeTransition(Duration.millis(1000), rec);
		ani.fromValueProperty().set(1);
		ani.toValueProperty().set(0.2);
		ani.setAutoReverse(true);
		startTransition(ani);
	}

	private void stopTransition() {
		if(null != trans) {
			if(trans.getStatus().equals(Status.RUNNING)) {
				trans.stop();
			}
		}
	}
	
	private void startTransition(Transition ani) {
		ani.interpolatorProperty().set(Interpolator.LINEAR);
		ani.setCycleCount(Timeline.INDEFINITE);
		
		trans = ani;
		trans.play();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		grid.getChildren().stream().filter(a -> a instanceof RadioButton)
				.forEach(a -> a.setOnMouseClicked(b -> {
					RadioButton rb = (RadioButton) b.getSource();
					startAnimation(rb.getText());
				}));
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
