package com.jdc.duke;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Duration;


public class DukeAnimation extends Application implements Initializable {
	
	private static final String FXML_FILE = "DukeAnimation.fxml";
	@FXML
	private Group duke;
	@FXML
	private Path rightBody;
	@FXML
	private Path leftBody;
	@FXML
	private Path head;
	@FXML
	private Circle tail;
	@FXML
	private Circle nose;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tail.setOnMouseClicked(a -> {
			TranslateTransition t = new TranslateTransition(Duration.millis(100), tail);
			t.setFromX(-40);
			t.setToX(0);
			t.setAutoReverse(true);
			t.setCycleCount(5);
			t.play();
		});
		
		nose.setOnMouseClicked(a -> {
			ScaleTransition t = new ScaleTransition(Duration.millis(100), nose);
			t.setFromX(1.2);
			t.setToX(1);
			t.setFromY(1.2);
			t.setToY(1);
			t.setAutoReverse(true);
			t.setCycleCount(5);
			t.play();
		});
		
		head.setOnMouseClicked(a -> {
			
			// up
			TranslateTransition tUp = new TranslateTransition(Duration.millis(300), duke);
			tUp.setFromY(0);
			tUp.setToY(-180);
			tUp.setInterpolator(Interpolator.EASE_OUT);
			
			// down
			TranslateTransition tDown = new TranslateTransition(Duration.millis(300), duke);
			tDown.setFromY(-180);
			tDown.setToY(0);
			tDown.setInterpolator(Interpolator.EASE_IN);
			
			// small
			ScaleTransition tSmall = new ScaleTransition(Duration.millis(10), duke);
			tSmall.setFromX(1.0);
			tSmall.setToX(1.3);
			tSmall.setFromY(1.);
			tSmall.setToY(0.7);
			
			// big
			ScaleTransition tBig = new ScaleTransition(Duration.millis(10), duke);
			tBig.setFromX(1.3);
			tBig.setToX(1.0);
			tBig.setFromY(1.3);
			tBig.setToY(1.0);
			
			SequentialTransition trans1 = new SequentialTransition(tBig, tUp, tDown, tSmall);
			trans1.setCycleCount(3);

			SequentialTransition trans2 = new SequentialTransition(trans1, tBig);
			trans2.play();
		});
		
		duke.setOnDragDetected(a -> {
			Rotate rl = Transform.rotate(-5, 0, 0);
			Rotate rr = Transform.rotate(5, 0, 0);
			rightBody.getTransforms().add(rl);
			leftBody.getTransforms().add(rr);
			
			Timeline time = new Timeline(
					new KeyFrame(Duration.ZERO, 
							new KeyValue(rl.angleProperty(), -5)),
					new KeyFrame(Duration.millis(300), 
							new KeyValue(rr.angleProperty(), 5)),
					new KeyFrame(Duration.millis(600), 
							new KeyValue(rl.angleProperty(), 0)),
					new KeyFrame(Duration.millis(900), 
							new KeyValue(rr.angleProperty(), 0))
				);
			
			time.setAutoReverse(true);
			time.setCycleCount(5);
			
			// move
			TranslateTransition move = new TranslateTransition(Duration.seconds(5), duke);
			move.setToX(300);
			move.setToY(-200);
			
			ParallelTransition ani = new ParallelTransition(time, move);
			ani.play();
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(FXML_FILE));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
