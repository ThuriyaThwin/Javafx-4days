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
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Sample3 extends Application implements Initializable{

	private static final String FXML = "Sample3.fxml";
	
	@FXML
	private Polygon boxBlur;
	@FXML
	private Slider boxWidth;
	@FXML
	private Slider boxHeight;
	@FXML
	private Slider boxIteration;
	
	
	@FXML
	private Circle motionBlur;
	@FXML
	private Slider motionAngle;
	@FXML
	private Slider motionRadius;
	
	@FXML
	private Rectangle gaussian;
	@FXML
	private Slider radius;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// box blur
		BoxBlur boxBlurEffect = new BoxBlur();
		boxBlurEffect.widthProperty().bind(boxWidth.valueProperty());
		boxBlurEffect.heightProperty().bind(boxHeight.valueProperty());
		boxBlurEffect.iterationsProperty().bind(boxIteration.valueProperty());
		
		boxBlur.effectProperty().set(boxBlurEffect);
		
		// motion blur
		MotionBlur motionBlurEffect = new MotionBlur();
		motionBlurEffect.angleProperty().bind(motionAngle.valueProperty());
		motionBlurEffect.radiusProperty().bind(motionRadius.valueProperty());
		
		motionBlur.effectProperty().set(motionBlurEffect);
		
		// gaussian blur
		GaussianBlur gaussainEffect = new GaussianBlur();
		gaussainEffect.radiusProperty().bind(radius.valueProperty());
		
		gaussian.setEffect(gaussainEffect);
		
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
