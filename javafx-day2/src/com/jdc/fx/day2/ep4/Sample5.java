package com.jdc.fx.day2.ep4;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Sample5 {

	public static void main(String[] args) {
		DoubleProperty var1 = new SimpleDoubleProperty(0);
		DoubleProperty var2 = new SimpleDoubleProperty(0);
		
		NumberBinding multiply = Bindings.multiply(var1, var2);
		NumberBinding adding = Bindings.add(var1, var2);
		NumberBinding dividing = Bindings.divide(var1, var2);
		NumberBinding substract = Bindings.subtract(var1, var2);
		
		var1.set(10);
		var2.set(3.3);
		
		System.out.println(multiply.doubleValue());
		System.out.println(adding.doubleValue());
		System.out.println(dividing.doubleValue());
		System.out.println(substract.doubleValue());
	}
}
