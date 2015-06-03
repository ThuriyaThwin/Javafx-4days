package com.jdc.fx.day3.ep2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sample4 extends Application implements Initializable{
	
	private static final String FXML = "Sample4.fxml";
	
	@FXML
	private Text dropText;
	@FXML
	private Circle circle;
	@FXML
	private Slider dOffsetX;
	@FXML
	private Slider dOffsetY;
	@FXML
	private ColorPicker colorPicker;
	
	@FXML
	private Text innerText;
	@FXML
	private Rectangle rec;
	@FXML
	private Slider iOffxetX;
	@FXML
	private Slider iOffsetY;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		DropShadow drop = new DropShadow();
		drop.colorProperty().bind(colorPicker.valueProperty());
		drop.offsetXProperty().bind(dOffsetX.valueProperty());
		drop.offsetYProperty().bind(dOffsetY.valueProperty());
		
		circle.setEffect(drop);
		dropText.setEffect(drop);
		
		InnerShadow inner = new InnerShadow();
		inner.offsetXProperty().bind(iOffxetX.valueProperty());
		inner.offsetYProperty().bind(iOffsetY.valueProperty());
		inner.setColor(Color.BROWN);
		
		rec.setEffect(inner);
		innerText.setEffect(inner);
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
