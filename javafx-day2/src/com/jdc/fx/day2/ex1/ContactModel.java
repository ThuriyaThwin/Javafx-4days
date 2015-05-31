package com.jdc.fx.day2.ex1;

import java.util.List;

public interface ContactModel {
	
	void add(Contact c);
	List<Contact> getAll();

	static ContactModel getModel() {
		return ContactModelImp.getModel();
	}
}
