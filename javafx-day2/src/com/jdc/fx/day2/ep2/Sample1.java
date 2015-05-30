package com.jdc.fx.day2.ep2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sample1 extends Application implements Initializable{
	
	private static final String FXML_FILE = "Sample1.fxml";
	
	@FXML
	private Text message;
	@FXML
	private TextField textInput;
	@FXML
	private Button btn;

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
	
	public void showMessage() {
		message.setText(textInput.getText());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				showMessage();
			}
		});
	}

}
