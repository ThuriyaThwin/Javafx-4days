package com.jdc.fx.day2.ep3;

public class Sample6 {

	public static void main(String[] args) {
		Bill javaSE = new Bill();
		
		javaSE.totalProperty().addListener((a, b, c) -> {
			System.out.println("Total is : " + c);
		});
		
		javaSE.setCount(10);
		javaSE.setPrice(75000);
	}
}
