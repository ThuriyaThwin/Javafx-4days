package com.jdc.fx.day2.ep3;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Sample2 {

	public static void main(String[] args) {
		DoubleProperty var1 = new SimpleDoubleProperty(10);
		DoubleProperty var2 = new SimpleDoubleProperty(2);
		
		NumberBinding result = var1.add(var2);
		
		System.out.println(result.intValue());
		
		var1.set(15);
		
		System.out.println(result.intValue());
		
		var2.set(15);
		
		System.out.println(result.intValue());
	}
}
