package com.jdc.fx.day2.ex1;

import java.util.ArrayList;
import java.util.List;

public class ContactModelImp implements ContactModel{
	
	private static ContactModelImp model;
	
	public static ContactModel getModel() {
		if(null == model)
			model = new ContactModelImp();
		
		return model;
	}
	
	private List<Contact> list;
	
	private ContactModelImp() {
		list = new ArrayList<Contact>();
	}

	@Override
	public void add(Contact c) {
		list.add(c);
	}

	@Override
	public List<Contact> getAll() {
		return list;
	}

}
