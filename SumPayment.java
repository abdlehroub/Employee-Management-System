package application;

import javafx.geometry.Pos;

public class SumPayment extends MyLabel {

	public SumPayment(String text) {
		super(text);
		this.setText(text + "\n        " + String.format("%.2f", calcPayment()) + " JD");
		this.setStyle("-fx-font-size: 80px;" + "-fx-alignment: center; -fx-font-weight: bold; " + // Font weight (bold)
				"-fx-text-fill: #A294F9; " + // Text color (white)
				"-fx-font-style: italic;");

	}
	
	
	// Calculate the total payment
	public double calcPayment() {
		double sum = 0;
		for (int i = 0; i < Main.employees.size(); i++) {
			sum += Main.employees.get(i).payment();
		}
		return sum;
	}

}
