package com.jdc.fx.day2.ep1;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sample2 implements Initializable {

	public static Scene getScene() {
		return new Sample2().getComponents();
	}

	private Scene getComponents() {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					String.format("%s.fxml", getClass().getSimpleName())));
			return new Scene(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@FXML
	private ComboBox<String> combo;
	@FXML
	private ChoiceBox<Object> choice;
	@FXML
	private ListView<Course> listView;

	@FXML
	private TableView<Course> table;
	@FXML
	private TableColumn<Course, String> colName;
	@FXML
	private TableColumn<Course, String> colPrice;
	@FXML
	private TableColumn<Course, String> colDuration;
	@FXML
	private TableColumn<Course, String> colDescription;

	@FXML
	private TreeView<String> tree;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// combo, choice, list view
		combo.getItems().addAll(getListString());
		choice.getItems().addAll(getListString());
		listView.getItems().addAll(Sample.getCourses());
		listView.setCellFactory(CourseCell::new);

		// table view
		colName.setCellValueFactory(
				new PropertyValueFactory<>("name"));
		
		colPrice.setCellValueFactory(a -> {
			if(null != a) {
				return new SimpleStringProperty(a.getValue().getPrice() + " MMK");
			}
			
			return null;
		});
		colDuration.setCellValueFactory(
				new PropertyValueFactory<>("duration"));
		colDescription.setCellValueFactory(
				new PropertyValueFactory<>("description"));

		table.getItems().clear();
		table.getItems().addAll(Sample.getCourses());

		// tree view
		ImageView imgView = new ImageView(
				new Image(getClass()
					.getResourceAsStream("Web-b-icon.png")));
			imgView.setPreserveRatio(true);
			imgView.setFitWidth(20);

		TreeItem<String> rootNode = new TreeItem<>("JDC Courses", imgView);
		rootNode.setExpanded(true);

		getMap().forEach((key, list) -> {
			TreeItem<String> leaf = new TreeItem<>(key);
			leaf.getChildren().addAll(list
					.stream()
					.map(a -> new TreeItem<>(a))
					.collect(Collectors.toList()));
			rootNode.getChildren().add(leaf);
		});
		
		tree.setRoot(rootNode);
	}

	public static List<String> getListString() {
		return Arrays.asList("Java SE", "JavaFX", "Java EE",
				"Spring Framework", "Android");
	}
	
	public static Map<String, List<String>> getMap() {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("Java SE", Arrays.asList("Language Basic", "OOP", "Java SE 5 Features", "Java SE 7 Features", "java SE 8 Features", "Collections", "I/O, NIO2", "JDBC", "Java FX"));
		map.put("Java EE", Arrays.asList("Overview", "JPA", "JSF", "EJB", "CDI", "JAX-RS", "Websockets", "JMS", "JAXB"));
		map.put("Spring Framework", Arrays.asList("DI", "CORE", "Spring MVC", "Interceptor", "Spring Security"));
		return map;
	}

}
