package com.jdc.restaurant.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import com.jdc.restaurant.model.OrderDetails;
import com.jdc.restaurant.model.Table;
import com.jdc.restaurant.service.OrderService;
import com.jdc.restaurant.service.TableService;

public class RestaurantHome implements Initializable, Reloadable{
	
	@FXML
	private ListView<Table> list;
	@FXML
	private TableView<OrderDetails> orders;
	@FXML
	private TableColumn<OrderDetails, String> dateTime;
	@FXML
	private TableColumn<OrderDetails, String> menu;
	@FXML
	private TableColumn<OrderDetails, String> count;
	@FXML
	private TableColumn<OrderDetails, String> total;
	
	@FXML
	private TextField subTotal;
	@FXML
	private TextField tax;
	@FXML
	private TextField totalPrice;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
		
		list.setOnMouseClicked(a -> {
			selectTable();
		});
		
		dateTime.setCellValueFactory(a -> {
			OrderDetails od = a.getValue();
			
			if(null != od) {
				return new SimpleStringProperty(od.getOrder().getOdTime().toString());
			}
			
			return null;
		});
		
		menu.setCellValueFactory(a -> {
			
			OrderDetails od = a.getValue();
			
			if(null != od) {
				return new SimpleStringProperty(od.getMenu().toString());
			}
			return null;
		});
		
		count.setCellValueFactory(new PropertyValueFactory<>("count"));
		
		total.setCellValueFactory(a -> {
			OrderDetails od = a.getValue();
			
			if(null != od) {
				int count = od.getCount();
				int price = od.getMenu().getPrice();
				return new SimpleStringProperty(String.valueOf(count * price));
			}
			
			return null;
		});
	}
	
	public void init() {
		TableService service = new TableService();
		// init table list
		list.getItems().clear();
		list.getItems().addAll(service.getAllTable());
		
		// clear order table
		orders.getItems().clear();
	}
	
	public void selectTable() {
		// get select table
		Table table = list.getSelectionModel().getSelectedItem();
		
		OrderService oderService = new OrderService();
		List<OrderDetails> detailsList = oderService.getOrdersForTable(table);
		
		orders.getItems().clear();
		orders.getItems().addAll(detailsList);
		
		setTotalPrice();
	}
	
	private void setTotalPrice() {
		subTotal.clear();
		totalPrice.clear();
		tax.clear();
		
		if(orders.getItems().size() > 0) {
			int tmp = orders.getItems().stream()
					.mapToInt(a -> a.getCount() * a.getMenu().getPrice())
					.sum();
			
			double taxValue = tmp * 0.05;
			
			subTotal.setText(String.valueOf(tmp));
			tax.setText(String.valueOf(taxValue));
			totalPrice.setText(String.valueOf(tmp + taxValue));
		}
	}

	public void doOrder() {
		Table table = list.getSelectionModel().getSelectedItem();
		if(null == table) {
			System.out.println("Please select table");
		} else {
			OrderController.showOrderView(table, this);
		}
	}
	
	public void checkOut() {
		Table table = list.getSelectionModel().getSelectedItem();
		if(null != table) {
			OrderService svc = new OrderService();
			svc.checkOut(table);
		}
		
		reload(table);
	}

	@Override
	public void reload(Table table) {
		list.getSelectionModel().select(table);
		this.selectTable();
	}
	
}
