package com.jdc.fx.day3.ep4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Sample2 extends Application implements Initializable{
	
	private static final String FXML = "Sample2.fxml";

	@FXML
	private ImageView image;
	
	private Timeline timeLine;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		image.setOnMouseClicked(a -> {
			
			if(null == timeLine) {
				timeLine = new Timeline();
				
				Rotate rotate = Transform.rotate(-65, 120, 23);
				image.getTransforms().add(rotate);
				
				KeyFrame frame1 = new KeyFrame(Duration.ZERO, 
						new KeyValue(rotate.angleProperty(), -60));
				KeyFrame frame2 = new KeyFrame(Duration.millis(1000), 
						new KeyValue(rotate.angleProperty(), 60));
				
				timeLine.getKeyFrames().addAll(frame1, frame2);
				
				timeLine.setAutoReverse(true);
				timeLine.setCycleCount(Timeline.INDEFINITE);
				
				timeLine.play();
				
			} else {
				if(timeLine.getStatus().equals(Status.RUNNING)) {
					timeLine.pause();
				} else {
					// play
					timeLine.play();
				}
			}
			
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
