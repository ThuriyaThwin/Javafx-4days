package com.jdc.fx.day2.ep1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Sample3 implements Initializable {
	
	@FXML
	private ListView<Course> list;
	@FXML
	private TextField name;
	@FXML
	private TextField fees;
	@FXML
	private TextField duration;
	@FXML
	private TextArea description;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.setCellFactory(CourseCell::new);
		list.getItems().addAll(Sample.getCourses());
		
		list.getSelectionModel().selectedItemProperty().addListener(a -> {
			Course c = list.getSelectionModel().getSelectedItem();
			name.setText(c.getName());
			fees.setText(c.getPrice() + " MMK");
			duration.setText(c.getDuration() + " Months");
			description.setText(c.getDescription());
		});
	}
	
	public static Scene getScene() {
		
		try {
			Parent root = FXMLLoader.load(Sample3.class.getResource("Sample3.fxml"));
			return new Scene(root);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return null;
	}

}
