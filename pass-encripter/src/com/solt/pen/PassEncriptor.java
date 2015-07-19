package com.solt.pen;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

public class PassEncriptor extends Application {
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Label textPass;
	@FXML
	private Label encript;
	
	public void encript() {
		
		String pass = password.getText();
		textPass.setText(pass);
		
		try {
			MessageDigest message = MessageDigest.getInstance("SHA-256");
			byte [] hash = message.digest(pass.getBytes());
			String encPass = Base64.getEncoder().encodeToString(hash);
			encript.setText(encPass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
	public void copy() {
		if(!password.getText().isEmpty() && encript.getText().isEmpty()) {
			this.encript();
		}
		
		Clipboard clip = Clipboard.getSystemClipboard();
		ClipboardContent content = new ClipboardContent();
		content.putString(encript.getText());
		clip.setContent(content);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// get fxml name
		String fxml = String.format("%s.fxml", getClass().getSimpleName());

		// load fxml
		Parent p = FXMLLoader.load(getClass().getResource(fxml));

		// create scene
		Scene s = new Scene(p);

		// set scene to stage
		primaryStage.setScene(s);

		// show stage
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
