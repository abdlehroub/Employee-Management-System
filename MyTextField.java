package application;

import javafx.scene.control.TextField;

public class MyTextField extends TextField {
	public MyTextField() {
		this.setStyle("-fx-padding: 6px 12px; " + // padding: 6px 12px
				"-fx-background-color: #E5D9F2; " + // background color
				"-fx-border-color:#A294F9; " + // border color
				"-fx-border-width: 1px; " + // border width
				"-fx-border-radius: 4px; " + // border radius
				"-fx-font-size: 13px; " + // font size
				"-fx-text-fill: #A294F9; " + // text color
				"-fx-pref-height: 35px; " + // height
				"-fx-background-insets: 0; " + // background insets
				"-fx-background-radius: 4px; " + // background radius
				"-fx-appearance: none; " + // appearance none
				"-fx-transition: border 0.15s ease 0s;" + "-fx-font-weight: bold; ");
	}

}
