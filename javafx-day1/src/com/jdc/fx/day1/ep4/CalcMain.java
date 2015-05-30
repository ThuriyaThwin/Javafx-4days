package com.jdc.fx.day1.ep4;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CalcMain extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Calculator.fxml"))));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
