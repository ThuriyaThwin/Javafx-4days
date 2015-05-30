package com.jdc.fx.day2.ep1;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class CourseCell extends ListCell<Course> {

	public CourseCell(ListView<Course> param) {
	}

	@Override
	protected void updateItem(Course item, boolean empty) {
		super.updateItem(item, empty);

		if (!empty) {
			setText(item.getName());
		}
	}

}
