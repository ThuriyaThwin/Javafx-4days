package com.jdc.fx.day2.ep3;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Sample5 {

	public static void main(String[] args) {
		ObservableList<String> list = FXCollections
				.observableArrayList("Language Specifications", 
						"OOP", "Essential API");
		
		list.addListener(new ListChangeListener<String>(){

			@Override
			public void onChanged(Change<? extends String> c) {
				while(c.next()) {
					if(c.wasAdded()) {
						System.out.println("Add : " + c.getAddedSubList());
					} else if(c.wasRemoved()) {
						System.out.println("Rmv : " + c.getRemoved());
					} 
				}
			}});
		
		list.add("JavaFX");
		list.addAll("Lambda Expression", "Stream API", "Date & Time API");
		
		list.remove(2);

		System.out.println(list);
	}
}
