package com.jdc.fx.day2.ep4;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;

import com.jdc.fx.day2.ep3.Bill;

public class Sample6 {

	public static void main(String[] args) {
		Bill bill1 = new Bill(10, 1050);
		Bill bill2 = new Bill(3, 1800);
		Bill bill3 = new Bill(5, 2030);
		
		NumberBinding total = Bindings.add(
				bill1.totalProperty().add(bill2.totalProperty()), 
				bill3.totalProperty());
		
		System.out.println(total.doubleValue());
	}
}
