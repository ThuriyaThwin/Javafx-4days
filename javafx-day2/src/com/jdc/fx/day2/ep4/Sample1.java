package com.jdc.fx.day2.ep4;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sample1 {
	
	public static void main(String[] args) {
		StringProperty var1 = new SimpleStringProperty("Java SE");
		StringProperty var2 = new SimpleStringProperty("Java EE");
		
		System.out.println(var1.get());

		var1.bind(var2);
		
		System.out.println(var1.get());
		
		var2.set("Java FX");
		
		System.out.println(var1.get());
	}

}
