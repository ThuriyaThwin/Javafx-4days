package com.jdc.fx.day2.ep3;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Sample1 {

	public static void main(String[] args) {
		IntegerProperty val1 = new SimpleIntegerProperty(10);
		IntegerProperty val2 = new SimpleIntegerProperty(2);
		
		System.out.println(val1.add(val2).intValue());
	}
}
