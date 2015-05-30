package com.jdc.fx.day2.ep1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Sample extends Application{
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// box
		VBox box = new VBox();
		// header
		HBox head = new HBox();
		head.getStyleClass().add("heading");
		head.getChildren().add(new Text("About Controls"));
		
		// Hbox
		HBox body = new HBox(10);
		body.getStyleClass().add("body-box");
		
		// button1
		Button btn1 = new Button("Inputs / Outputs");
		btn1.getStyleClass().add("round-btn");
		btn1.setOnAction(a -> {
			showSub(Sample1.getScene());
		});
		
		// button2
		Button btn2 = new Button("Using Collections");
		btn2.getStyleClass().add("round-btn");
		btn2.setOnAction(a -> {
			showSub(Sample2.getScene());
		});
		
		// button3
		Button btn3 = new Button("Event Handling");
		btn3.getStyleClass().add("round-btn");
		
		btn3.setOnAction(a -> {
			showSub(Sample3.getScene());
		});
		
		body.getChildren().addAll(btn1, btn2, btn3);
		
		// footer
		VBox footer = new VBox(20);
		footer.setAlignment(Pos.CENTER);
		footer.getStyleClass().add("footer");
		
		Text text = new Text("JavaFX in 4 Days");
		text.getStyleClass().add("title");
		
		Text name = new Text("Zaw Min Lwin");
		name.getStyleClass().add("name");
		
		Text company = new Text("SOLT Engineering Co.,Ltd.");
		company.getStyleClass().add("company");
		
		footer.getChildren().addAll(text, name, company);
		
		box.getChildren().addAll(head, body, footer);
		Scene scene = new Scene(box);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void showSub(Scene scene) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static List<Course> getCourses() {
		try {
			return Files.readAllLines(Paths.get("course.txt")).stream()
					.map(Course::new).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	

}
