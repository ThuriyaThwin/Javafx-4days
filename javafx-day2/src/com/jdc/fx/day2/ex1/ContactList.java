package com.jdc.fx.day2.ex1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContactList implements Initializable{
	
	@FXML
	private TableView<Contact> contacts;
	
	@FXML
	private TableColumn<Contact, String> colName;
	@FXML
	private TableColumn<Contact, String> colMobile;
	@FXML
	private TableColumn<Contact, String> colHome;
	
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		colHome.setCellValueFactory(new PropertyValueFactory<>("home"));
		
		contacts.getItems().addAll(ContactModel.getModel().getAll());
	}

}
