package com.jdc.fx.day2.ex1;

import java.io.IOException;

import com.jdc.contact.Contact;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ContactForm {
	
	@FXML
	private TextField name;
	@FXML
	private TextField mobile;
	@FXML
	private TextField office;
	@FXML
	private TextField home;
	@FXML
	private TextArea address;
	

	public void clear() {
		name.clear();
		mobile.clear();
		office.clear();
		home.clear();
		address.clear();
	}
	
	public void save() {
		
		try {
			
			// check single item
			this.checkSingle();
			
			// check relative items
			this.checkRelativeItems();
			
			// get view data
			Contact c = getViewData();
			
			// save
			ContactModel.getModel().add(c);
			
			// clear
			clear();
			
			// show list view
			this.showListView();
			
		} catch(NeedToAlert e) {
			Alert.showMessage(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void showListView() throws IOException {
		Stage stage = new Stage();
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ContactList.fxml")));
		stage.setScene(scene);
		
		stage.initModality(Modality.APPLICATION_MODAL);
		
		stage.show();
	}

	private Contact getViewData() {
		Contact c = new Contact();
		c.setName(name.getText());
		c.setAddress(address.getText());
		c.setPhone(home.getText());
		c.setMobile(mobile.getText());
		return c;
	}

	private void checkRelativeItems() {
		if(mobile.getText().isEmpty() && 
				home.getText().isEmpty() &&
				office.getText().isEmpty()) {
			throw new NeedToAlert("Please enter any phone number!");
		}
	}

	private void checkSingle() {
		if(name.getText().isEmpty()) {
			throw new NeedToAlert("Please set Contect Name.");
		}
	}

	public void clearPhoto() {
		
	}
	
	public void loadPhot() {
		
	}
}
