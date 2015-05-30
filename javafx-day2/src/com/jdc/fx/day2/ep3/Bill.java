package com.jdc.fx.day2.ep3;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Bill {

	public Bill() {
	}
	
	public Bill(int count, double price) {
		this.price.set(price);
		this.count.set(count);
	}
	
	private DoubleProperty price = new SimpleDoubleProperty(0);
	private IntegerProperty count = new SimpleIntegerProperty(0);
	private NumberBinding total = price.multiply(count);
	
	public double getPrice() {
		return price.doubleValue();
	}
	
	public void setPrice(double price) {
		this.price.set(price);
	}
	
	public DoubleProperty priceProperty() {
		return this.price;
	}
	
	public int getCount() {
		return count.get();
	}
	
	public void setCount(int count) {
		this.count.set(count);
	}
	
	public IntegerProperty countProperty() {
		return count;
	}
	
	public double getTotal() {
		return total.doubleValue();
	}
	
	public NumberBinding totalProperty() {
		return total;
	}
}
