package application;

import javafx.scene.control.MenuItem;

public class MyMenuItem extends MenuItem {
	public MyMenuItem(String text) {
		this.setText(text);
		this.setStyle("-fx-background-color: #E5D9F2;-fx-padding: 3px 60px; -fx-text-fill: #A294F9;-fx-font-family: 'Montserrat'; -fx-font-size: 12px;");

	}
}
