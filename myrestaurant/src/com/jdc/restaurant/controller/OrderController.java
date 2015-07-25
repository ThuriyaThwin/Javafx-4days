package com.jdc.restaurant.controller;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import com.jdc.restaurant.entity.Category;
import com.jdc.restaurant.entity.MenuItem;
import com.jdc.restaurant.entity.OrderDetails;
import com.jdc.restaurant.service.CategoryService;
import com.jdc.restaurant.service.MenuItemService;

public class OrderController implements Initializable{
	
	private MenuItemService menuService;
	
	@FXML
	private TextField tableNumber;
	@FXML
	private ComboBox<Category> categories;
	@FXML
	private ComboBox<Integer> counts;
	@FXML
	private ListView<MenuItem> menus;
	@FXML
	private TableView<OrderDetails> orders;
	
	@FXML
	private TableColumn<OrderDetails, String> menu;
	@FXML
	private TableColumn<OrderDetails, String> price;
	@FXML
	private TableColumn<OrderDetails, String> unit;
	@FXML
	private TableColumn<OrderDetails, String> total;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		menuService = new MenuItemService();
		
		CategoryService cs = new CategoryService();
		categories.getItems().addAll(cs.getAllCategory());
		menus.getItems().addAll(menuService.getMenu(null));
		counts.getItems().addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		
		// menu
		menu.setCellValueFactory((param) -> {
				OrderDetails od = param.getValue();
				MenuItem menu = od.getMenu();
				return new SimpleStringProperty(menu.getMenu());
			}
		);
		
		// price
		price.setCellValueFactory((param) -> {
				OrderDetails od = param.getValue();
				MenuItem menu = od.getMenu();
				return new SimpleStringProperty(String.valueOf(menu.getPrice()));
			}
		);
		
		// unit
		unit.setCellValueFactory(new PropertyValueFactory<>("count"));
		
		// total
		total.setCellValueFactory((param) -> {
			OrderDetails od = param.getValue();
			MenuItem menu = od.getMenu();
			return new SimpleStringProperty(String.valueOf(menu.getPrice() * od.getCount()));
		}
	);
	}
	
	public void changeCategory() {
		// get selected category
		Category c = categories.getSelectionModel().getSelectedItem();
		
		List<MenuItem> list = menuService.getMenu(c);
		
		menus.getItems().clear();
		menus.getItems().addAll(list);
	}
	
	public void add() {
		// select menu
		MenuItem menu = menus.getSelectionModel().getSelectedItem();
		
		// count
		int count = counts.getSelectionModel().getSelectedItem();
		
		if(menu == null) {
			showMessage("Please select menu item.");
			return;
		}
		
		if(count <= 0) {
			showMessage("Please select count.");
			return;
		}
		
		OrderDetails od = new OrderDetails(count, menu);
		orders.getItems().add(od);
		
	}

	private void showMessage(String string) {
		System.out.println(string);
	}

}
