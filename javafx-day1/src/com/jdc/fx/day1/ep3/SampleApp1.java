package com.jdc.fx.day1.ep3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SampleApp1 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = this.getView();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Parent getView() {
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.setPrefHeight(453);
		box.setPrefWidth(660);
		
		// heading
		HBox box1 = new HBox();
		box1.setAlignment(Pos.CENTER);
		box1.setPrefHeight(154);
		
		Text text1 = new Text("JavaFX in 4 Days");
		text1.setFont(Font.font("Marion", 78));
		box1.getChildren().add(text1);
		
		// name
		HBox box2 = new HBox();
		box2.setAlignment(Pos.CENTER);
		box2.setPrefHeight(69);
		
		Text text2 = new Text("Zaw Min Lwin");
		text2.setFont(new Font("PT Serif", 37));
		text2.setStyle("-fx-font-weight:bold");
		box2.getChildren().add(text2);
		
		// company
		HBox box3 = new HBox();
		box3.setAlignment(Pos.CENTER);
		box3.setPrefHeight(45);
		
		Text text3 = new Text("SOLT Engineering Co,.Ltd.");
		text3.setFont(new Font("PT Serif", 28));
		box3.getChildren().add(text3);
		
		box.getChildren().addAll(box1, box2, box3);

		return box;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
