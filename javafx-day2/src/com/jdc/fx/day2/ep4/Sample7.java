package com.jdc.fx.day2.ep4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Sample7 extends Application implements Initializable{

	private static final String FXML_FILE = "Sample7.fxml";
	@FXML
	private TextField burmese;
	@FXML
	private TextField english;
	@FXML
	private TextField maths;
	@FXML
	private TextField physics;
	@FXML
	private TextField biology;
	@FXML
	private TextField chemistory;
	
	@FXML
	private TextField total;
	@FXML
	private TextField average;
	
	private Exam exam;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		exam = new Exam();
		
		exam.burmeseProperty().bind(getBinding(burmese));
		exam.englishProperty().bind(getBinding(english));
		exam.mathsProperty().bind(getBinding(maths));
		exam.physicsProperty().bind(getBinding(physics));
		exam.chemistryProperty().bind(getBinding(chemistory));
		exam.biologyProperty().bind(getBinding(biology));

		average.textProperty().bind(getBinding(exam.averageProperty()));
		total.textProperty().bind(getBinding(exam.totalProperty()));
	}
	
	private StringBinding getBinding(NumberBinding numb) {
		return new StringBinding() {
			
			{
				bind(numb);
			}
			
			@Override
			protected String computeValue() {
				return String.valueOf(numb.getValue());
			}
		};
	}
	
	private IntegerBinding getBinding(TextField field) {
		return new IntegerBinding() {
			
			{
				bind(field.textProperty());
			}
			
			@Override
			protected int computeValue() {
				try {
					return Integer.parseInt(burmese.textProperty().get());
				} catch (Exception e) {}
				return 0;
			}
		};
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
