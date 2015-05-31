package com.jdc.fx.day2.ep1;

import java.time.LocalDate;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

public class Sample1 {

	public static Scene getScene() {
		return new Scene(new Sample1().getComponents());
	}
	
	private VBox getComponents() {
		
		// VBox
		VBox box = new VBox();
		box.setPrefHeight(580);
		box.setPrefWidth(780);
		
		// title
		HBox header = new HBox();
		header.setPrefHeight(100);
		header.setAlignment(Pos.CENTER);
		
		Text text = new Text("Input & Output Controls");
		text.setFont(Font.font(36));
		header.getChildren().add(text);

		
		HBox body = this.getBody();
		
		box.getChildren().addAll(header, body);
		return box;
	}

	private HBox getBody() {
		HBox box = new HBox();
		box.setPrefHeight(480);
		box.setSpacing(20);
		box.setPadding(new Insets(40));
		
		box.getChildren().add(getLeft());
		box.getChildren().add(getRight());
		
		return box;
	}

	private Node getRight() {
		VBox box = new VBox(10);
		box.setMaxWidth(340);
		
		// text field
		TextField textField = new TextField();
		textField.setPromptText("Text Field");
		box.getChildren().add(textField);
		
		// password field
		PasswordField pass = new PasswordField();
		pass.setPromptText("Password Field");
		box.getChildren().add(pass);
		
		// text area
		TextArea textArea = new TextArea();
		textArea.setPrefHeight(80);
		box.getChildren().add(textArea);
		
		// radio button
		HBox radioGroup = new HBox(10);
		ToggleGroup group = new ToggleGroup();
		
		RadioButton male = new RadioButton("Male");
		RadioButton female = new RadioButton("Female");
		male.setSelected(true);
		male.setToggleGroup(group);
		female.setToggleGroup(group);
		
		radioGroup.getChildren().addAll(male, female);
		
		box.getChildren().add(radioGroup);
		
		
		// check box
		HBox checkBoxes = new HBox(10);
		checkBoxes.getChildren().addAll(FXCollections
			.observableArrayList(
				new CheckBox("Java SE"),
				new CheckBox("Java EE"),
				new CheckBox("Java FX")));
		box.getChildren().add(checkBoxes);
		
		// choice box
		ChoiceBox<Object> choice = new ChoiceBox<>();
		choice.setItems(FXCollections.observableArrayList(
				"Java SE",
				"JavaFX",
				new Separator(),
				"Java EE",
				"Spring Framework",
				new Separator(),
				"Android",
				new Separator(),
				"Java Developer Course for Japan"
				));
		choice.setPrefWidth(340);
		
		box.getChildren().add(choice);
		
		// date picker
		DatePicker dp = new DatePicker();
		dp.setValue(LocalDate.now());
		
		
		// color picker
		ColorPicker cp = new ColorPicker();
		cp.setValue(Color.BROWN);
		
		box.getChildren().addAll(dp, cp);
		
		// slider
		Slider slider = new Slider(0, 100, 30);
		slider.setMajorTickUnit(25);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setBlockIncrement(5);
		
		box.getChildren().add(slider);
		
		Label result = new Label();
		Bindings.bindBidirectional(
				result.textProperty(), 
				slider.valueProperty(), 
				new NumberStringConverter());
		box.getChildren().add(result);
		
		return box;
	}

	private Node getLeft() {
		VBox box = new VBox(20);
		box.setPrefWidth(340);
		
		// label
		Label label1 = new Label("Label With Only Text");
		
		Label label2 = new Label("Label With Big Text");
		label2.setFont(new Font(24));
		
		Label label3 = new Label("Label with color");
		label3.setStyle("-fx-text-fill:blue;-fx-font-size:36;");
		box.getChildren().addAll(label1, label2, label3);
		
		// label with graphic and text
		ImageView imgView = new ImageView(
			new Image(getClass()
				.getResourceAsStream("Web-b-icon.png")));
		imgView.setPreserveRatio(true);
		imgView.setFitWidth(30);
		
		Label iconText = new Label("Web Icon", imgView);
		iconText.setFont(Font.font(24));

		box.getChildren().add(iconText);
		
		// label with graphics
		HBox labelBar = new HBox(10);
		box.getChildren().add(labelBar);
		
		// firefox
		ImageView firefox = new ImageView(new Image(getClass().getResourceAsStream("firefox.png")));
		firefox.setFitWidth(30);
		firefox.setPreserveRatio(true);
		labelBar.getChildren().add(new Label("",firefox));
		
		// chrome
		ImageView chrome = new ImageView(new Image(getClass().getResourceAsStream("chrome.png")));
		chrome.setFitWidth(30);
		chrome.setPreserveRatio(true);
		labelBar.getChildren().add(new Label("",chrome));
		
		// ie
		ImageView ie = new ImageView(new Image(getClass().getResourceAsStream("ie.png")));
		ie.setFitWidth(30);
		ie.setPreserveRatio(true);
		labelBar.getChildren().add(new Label("",ie));
		
		// opera
		ImageView opera = new ImageView(new Image(getClass().getResourceAsStream("Opera.png")));
		opera.setFitWidth(30);
		opera.setPreserveRatio(true);
		labelBar.getChildren().add(new Label("",opera));
		
		// safari
		ImageView safari = new ImageView(new Image(getClass().getResourceAsStream("safari.png")));
		safari.setFitWidth(30);
		safari.setPreserveRatio(true);
		labelBar.getChildren().add(new Label("",safari));

		// label get text wrapping
		Label wrap = new Label();
		wrap.setFont(Font.font(16));
		wrap.setPrefWidth(240);
		wrap.setWrapText(true);
		wrap.setText("Hello Java FX. "
				+"This is the course of JavaFX "
				+"in 4 Days. Have a fun!");
		box.getChildren().add(wrap);
		
		
		// label with effect
		Label effect = new Label("Effect");
		effect.setFont(Font.font(20));
		effect.setRotate(270);
		effect.setTranslateY(20);
		box.getChildren().add(effect);
		
		return box;
	}

}
