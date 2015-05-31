package com.jdc.fx.day2.ex1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Alert {

	@FXML
	private Label message;
	
	private void setMessage(String m) {
		message.setText(m);
	}
	
	public void close() {
		message.getScene().getWindow().hide();
	}

	public static void showMessage(String message) {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(Alert.class.getResource("Alert.fxml"));
			stage.setScene(new Scene(loader.load()));
			Alert alert = loader.getController();
			alert.setMessage(message);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} catch(Exception e) {
			
		}
	}

}
