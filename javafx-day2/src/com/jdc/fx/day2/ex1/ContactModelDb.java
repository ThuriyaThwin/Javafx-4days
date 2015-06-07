package com.jdc.fx.day2.ex1;

import java.util.List;

import com.jdc.contact.Contact;
import com.jdc.jdbc.Model;

public class ContactModelDb implements ContactModel{
	
	private Model<Contact> model;
	
	public ContactModelDb() {
		model = Model.instance(Contact.class, Contact::map);
	}

	@Override
	public void add(Contact c) {
		model.insert(c);
	}

	@Override
	public List<Contact> getAll() {
		return model.find(null, null);
	}

}
