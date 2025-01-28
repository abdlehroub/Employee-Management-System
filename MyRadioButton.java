package application;

import javafx.scene.control.RadioButton;

public class MyRadioButton extends RadioButton {
	public MyRadioButton(String text) {
		this.setText(text);
		this.setStyle("-fx-font-weight: bold; " + // Font weight (bold)
				"-fx-text-fill: #A294F9; " + // Text color (white)
				"-fx-font-style: italic;" + "-fx-font-size: 15px;");
	}
}
