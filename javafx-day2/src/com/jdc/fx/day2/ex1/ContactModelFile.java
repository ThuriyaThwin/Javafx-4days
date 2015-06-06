package com.jdc.fx.day2.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactModelFile implements ContactModel {

	private List<Contact> list;

	ContactModelFile() {
		list = new ArrayList<>();

		// read from file
		try {
			List<String> lines = Files.readAllLines(Paths.get("contact.txt"));

			list.addAll(lines.stream().map(Contact::new)
					.collect(Collectors.toList()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Contact c) {
		list.add(c);

		// save to file
		try {
			List<String> lines = list.stream().map(a -> a.toLine())
					.collect(Collectors.toList());

			Files.write(Paths.get("contact.txt"), lines,
					StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> getAll() {
		return list;
	}
	
	private static ContactModel model;
	
	public static ContactModel getModel() {
		if(model == null) {
			model = new ContactModelFile();
		}
		
		return model;
	}

}
