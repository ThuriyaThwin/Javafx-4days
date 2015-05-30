package com.jdc.fx.day2.ep3;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.jdc.fx.day2.ep1.Course;
import com.jdc.fx.day2.ep1.Sample;

public class Sample4 extends Application implements Initializable{

	private static final String FXML_FILE = "Sample4.fxml";
	@FXML
	private TextField name;
	@FXML
	private TableView<Course> table;
	@FXML
	private TableColumn<Course, String> colName;
	@FXML
	private TableColumn<Course, String> colFees;
	@FXML
	private TableColumn<Course, String> colDuration;
	
	private List<Course> courses;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		courses = Sample.getCourses();
		
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colFees.setCellValueFactory(param -> {
			if(null != param)
				return new SimpleStringProperty(param.getValue().getPrice() + " MMK");
			return null;
		});
		colDuration.setCellValueFactory(param -> {
			if(null != param)
				return new SimpleStringProperty(param.getValue().getDuration() + " Months");
			
			return null;
		});
		
		table.getItems().addAll(courses);
		
		// add listener
		name.textProperty().addListener((a, b, c) -> {
			table.getItems().clear();
			table.getItems().addAll(courses.stream()
					.filter(course -> course.getName().startsWith(c))
					.collect(Collectors.toList()));
		});
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
