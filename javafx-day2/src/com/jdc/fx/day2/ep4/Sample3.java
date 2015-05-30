package com.jdc.fx.day2.ep4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Sample3 extends Application implements Initializable{
	
	private static final String FXML_FILE = "Sample3.fxml";
	@FXML
	private Rectangle rec;
	@FXML
	private Slider sliderY;
	@FXML
	private Slider sliderX;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sliderY.valueProperty().bindBidirectional(rec.heightProperty());
		sliderX.valueProperty().bindBidirectional(rec.widthProperty());
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
