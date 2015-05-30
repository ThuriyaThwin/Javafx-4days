package com.jdc.fx.day1.ep4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Calculator  {
	@FXML
	private Label resultDisplay;
	@FXML
	private Label tmpDisplay;

	@FXML
	private GridPane grid;

	private boolean isNew = true;
	
	public void doAction(ActionEvent e) {
		Button b = (Button) e.getSource();
		String str = b.getText().trim();
		switch (str) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			numbers(str);
			break;
		case "CE":
			clear();
			break;
		case "=":
			calculate();
			break;
		default:
			operators(str);
			break;
		}
	}

	private void numbers(String numb) {
		
		String current = resultDisplay.getText();

		if(isNew) {
			current = "0";
			isNew = false;
		}

		if (current.equals("0")) {
			resultDisplay.setText(numb);
		} else {
			resultDisplay.setText(current + numb);
		}
	}

	private void operators(String ope) {
		String current = resultDisplay.getText();
		String tmp = tmpDisplay.getText();

		if (!current.equals("0")) {

			if (tmp.isEmpty()) {
				tmpDisplay.setText(current + " " + ope);
				resultDisplay.setText("0");
			} else {
				String[] strs = tmp.split(" ");
				if (strs.length == 2) {
					String result = this.calculate(strs[0].trim(), current,
							strs[1].trim());
					tmpDisplay.setText(result + " " + ope);
					resultDisplay.setText("0");
				}
			}
		}
	}
	
	public void close() {
		Platform.exit();
	}

	private void calculate() {
		String current = resultDisplay.getText();
		String tmp = tmpDisplay.getText();
		
		if(!tmp.isEmpty()) {
			String[] strs = tmp.split(" ");
			if (strs.length == 2) {
				String result = this.calculate(strs[0].trim(), current,
						strs[1].trim());
				resultDisplay.setText(result);
				tmpDisplay.setText("");
			}
		}
		
		isNew = true;

	}

	private String calculate(String first, String second, String operator) {
		
		int result = 0;
		int fInt = Integer.parseInt(first);
		int sInt = Integer.parseInt(second);
		
		switch (operator) {
		case "+":
			result = fInt + sInt;
			break;
		case "-":
			result = fInt - sInt;
			break;
		case "*":
			result = fInt * sInt;
			break;
		default:
			result = fInt / sInt;
			break;
		}
		return String.valueOf(result);
	}

	private void clear() {
		tmpDisplay.setText("");
		resultDisplay.setText("0");
	}

}
