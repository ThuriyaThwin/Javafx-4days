package com.jdc.fx.day2.ep3;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Sample3 {

	public static void main(String[] args) {
		DoubleProperty var1 = new SimpleDoubleProperty(10);
		DoubleProperty var2 = new SimpleDoubleProperty(2);
		
		NumberBinding result = var1.add(var2);
		result.addListener((a, b, c) -> {
			System.out.println("Old Value -> " + b);
			System.out.println("New Value -> " + c);
		});
		
		var1.set(14);
		var2.set(15);
	}
}
