package com.jdc.fx.day2.ep2;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sample2 extends Application implements Initializable{
	
	private static final String FXML_FILE = "Sample2.fxml";
	
	@FXML
	private ChoiceBox<Browser> choice;
	@FXML
	private ImageView img;
	@FXML
	private Text text;
	
	public static List<Browser> browsers() {
		return Arrays.asList(new Browser("Firefox", "firefox.png"),
				new Browser("Chrome", "chrome.png"),
				new Browser("Internet Explore", "ie.png"),
				new Browser("Opera", "Opera.png"),
				new Browser("Safari", "safari.png"));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choice.getItems().addAll(browsers());
		
		choice.valueProperty().addListener((a, b, c) -> {
			Image image = new Image(getClass()
					.getResourceAsStream(c.getImgPath()));
			img.setImage(image);
		});
		
		img.setOnMouseClicked(a -> 
			text.setText(choice.getSelectionModel()
					.getSelectedItem().getName()));
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
