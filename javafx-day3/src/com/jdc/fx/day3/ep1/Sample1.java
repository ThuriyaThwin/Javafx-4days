package com.jdc.fx.day3.ep1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sample1 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// frame
		VBox frame = new VBox();
		frame.setPrefWidth(480);
		frame.setStyle("-fx-background-color:silver");
		
		// header
		HBox header = getHeader();
		
		// body
		VBox body = getBody();
		
		frame.getChildren().addAll(header, body);
		
		primaryStage.setScene(new Scene(frame));
		primaryStage.show();
	}
	
	private HBox getHeader() {
		
		HBox box = new HBox();
		box.setPrefHeight(73);
		box.setAlignment(Pos.CENTER_LEFT);
		box.setPadding(new Insets(0, 0, 0, 20));
		box.setStyle("-fx-background-color:brown");
		
		Text text = new Text("Login Form");
		text.setFont(Font.font(30));
		text.setFill(Paint.valueOf("white"));
		box.getChildren().add(text);
		
		return box;
	}

	private VBox getBody() {
		VBox box = new VBox(20);
		box.setPadding(new Insets(20, 40, 40, 40));
		
		// login id
		VBox loginBox = new VBox(10);
		loginBox.getChildren().add(new Label("Login Id"));
		loginBox.getChildren().add(new TextField());
		
		// password
		VBox passBox = new VBox(10);
		passBox.getChildren().add(new Label("Password"));
		passBox.getChildren().add(new PasswordField());
		
		// buttons
		HBox buttons = new HBox(10);
		buttons.getChildren().add(new Button("CLEAR"));
		buttons.getChildren().add(new Button("LOGIN"));
		
		box.getChildren().addAll(loginBox, passBox, buttons);
		
		return box;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
