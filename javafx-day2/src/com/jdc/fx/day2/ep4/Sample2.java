package com.jdc.fx.day2.ep4;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sample2 {

	public static void main(String[] args) {
		StringProperty var1 = new SimpleStringProperty("Java SE");
		StringProperty var2 = new SimpleStringProperty("Java EE");
		
		var1.addListener(a -> {
			System.out.println("Change Value : " + a);
		});
		
		var1.bind(var2);
		
		var2.set("JDBC");
		var2.set("Java FX");
		
		System.out.println(var1.get());
	}
}
