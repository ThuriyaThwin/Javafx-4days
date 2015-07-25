package com.jdc.restaurant.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdc.restaurant.entity.OrderDetails;
import com.jdc.restaurant.entity.Table;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RestaurantHome implements Initializable{
	
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
