package com.jdc.fx.day2.ex1;

import java.util.List;

import com.jdc.contact.Contact;

public interface ContactModel {
	
	void add(Contact c);
	List<Contact> getAll();

	static ContactModel getModel() {
		return new ContactModelDb();
	}
}
