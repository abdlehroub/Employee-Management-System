package application;

import javafx.scene.control.Menu;

public class MyMenu extends Menu {
	public MyMenu(String text) {
		this.setText(text);
		this.setStyle("-fx-background-color: #E5D9F2;-fx-padding: 3px 80px; -fx-text-fill: #A294F9;-fx-font-family: 'Montserrat'; -fx-font-size: 12px;");
	}
}
