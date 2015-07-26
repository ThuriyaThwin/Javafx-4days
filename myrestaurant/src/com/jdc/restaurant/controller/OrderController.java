package com.jdc.restaurant.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.jdc.restaurant.model.Category;
import com.jdc.restaurant.model.MenuItem;
import com.jdc.restaurant.model.OrderDetails;
import com.jdc.restaurant.model.Table;
import com.jdc.restaurant.service.CategoryService;
import com.jdc.restaurant.service.MenuItemService;
import com.jdc.restaurant.service.OrderService;

public class OrderController implements Initializable{
	
	private MenuItemService menuService;
	private OrderService oderService;
	private Table table;
	private Reloadable parent;
	
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
	

	@FXML
	private TextField totalPrice;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		menuService = new MenuItemService();
		oderService = new OrderService();
		
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
		
		int total = orders.getItems().stream()
			.mapToInt(a -> a.getCount() * a.getMenu().getPrice())
			.sum();
		
		totalPrice.setText(String.valueOf(total));
		
	}
	
	
	public void doOrder() {
		// get view data
		oderService.doOrder(table, orders.getItems());
		
		// refresh home
		parent.reload(table);
		
		// close window
		categories.getScene().getWindow().hide();
	}

	private void showMessage(String string) {
		System.out.println(string);
	}
	
	void setTable(Table t) {
		this.table = t;
		this.tableNumber.setText(table.getTableNumber());
	}
	
	void setReloadable(Reloadable parent) {
		this.parent = parent;
	}

	
	public static void showOrderView(Table table, Reloadable reload) {
		
		try {
			FXMLLoader loader = new FXMLLoader(OrderController.class.getResource("OrderController.fxml"));
			Parent p = loader.load();
			OrderController oc = loader.getController();
			oc.setTable(table);
			oc.setReloadable(reload);
			
			Stage stage = new Stage();
			stage.setScene(new Scene(p));
			stage.initModality(Modality.APPLICATION_MODAL);
			
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void clear() {
		orders.getItems().clear();
	}
}
