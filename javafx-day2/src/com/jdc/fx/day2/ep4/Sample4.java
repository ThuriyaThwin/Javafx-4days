package com.jdc.fx.day2.ep4;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Sample4 {
	
	public static void main(String[] args) {
		DoubleProperty var1 = new SimpleDoubleProperty(0);
		DoubleProperty var2 = new SimpleDoubleProperty(0);
		
		NumberBinding multiply = var1.multiply(var2);
		NumberBinding adding = var1.add(var2);
		NumberBinding dividing = var1.divide(var2);
		NumberBinding substract = var1.subtract(var2);
		
		var1.set(10);
		var2.set(3.3);
		
		System.out.println(multiply.doubleValue());
		System.out.println(adding.doubleValue());
		System.out.println(dividing.doubleValue());
		System.out.println(substract.doubleValue());
	}

}
