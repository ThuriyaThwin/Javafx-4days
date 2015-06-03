package com.jdc.fx.day3.ep4;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;


import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Sample1 extends Application implements Initializable{
	
	private static final String FXML = "Sample1.fxml";

	@FXML
	private ImageView bird;
	
	@FXML
	private VBox messageArea;
	
	@FXML
	private Text title;
	@FXML
	private Text clickHere;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		clickHere.setOnMouseClicked(a -> {
			// disaper click here
			FadeTransition clickAnimation = new FadeTransition(Duration.millis(500), clickHere);
			clickAnimation.toValueProperty().set(0.0);
			
			// appear title
			Timeline timeLine = getAnimatedString(title, "Flying Bird");
			
			// parallel animation
			ParallelTransition titleAnimation = new ParallelTransition(clickAnimation, timeLine);
			titleAnimation.setOnFinished(b -> {
				// play story
				playStory();
			});
			
			titleAnimation.play();
			
		});

	}
	
	
	private void playStory() {
		try {
			// flying
			Timeline fly = this.getFlying();
			
			// moving
			Transition move = this.getMoving();
			
			ParallelTransition animation = new ParallelTransition(fly, move);
			
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.setAutoReverse(true);
			animation.play();
			
			// Java Developer Class
			Text jdc = new Text();
			Text address = new Text();
			Text phone = new Text();
			messageArea.getChildren().addAll(jdc, address, phone);
			
			SequentialTransition textAnimation = new SequentialTransition(
					new PauseTransition(Duration.seconds(2)), 
					this.getAnimatedString(jdc, "Java Developer Class"),
					new PauseTransition(Duration.seconds(2)), 
					this.getAnimatedString(address, "19/20F West Side of Aung San Stadium, Mingalar Taungnyunt"),
					new PauseTransition(Duration.seconds(2)), 
					this.getAnimatedString(phone, "01-394-809, 01-394-820 ")
					);
			
			textAnimation.play();
			
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
	
	private Timeline getAnimatedString(Text text, String message) {
		// setting style text
		text.setStyle("-fx-font-size:24; -fx-fill:white;"); 
		
		// creating time line
		Timeline timeLine = new Timeline();
		StringBuffer sb = new StringBuffer();
		String [] array = message.split("");
		int time = 500;
		
		for(String s : array) {
			time += 150;
			sb.append(s);
			KeyFrame frame = new KeyFrame(Duration.millis(time), new KeyValue(text.textProperty(), sb.toString()));
			timeLine.getKeyFrames().add(frame);
		}
		
		return timeLine;
	}

}
