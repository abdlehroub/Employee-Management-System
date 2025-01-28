package application;

import javafx.scene.control.Label;

public class MyLabel extends Label {
	public MyLabel(String text) {
		this.setText(text);
		this.setStyle( // Outline (focus effect)
				"-fx-font-weight: bold; " + // Font weight (bold)
				"-fx-text-fill: #A294F9; " + // Text color (white)
				"-fx-font-style: italic;" + "-fx-font-size: 15px;");
	}

}
