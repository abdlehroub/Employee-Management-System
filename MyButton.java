package application;

import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyButton extends Button {
	public MyButton() {

		this.setStyle("-fx-background-color: #A294F9; " + "-fx-border-color: #A294F9;" + "-fx-border-radius: 6px; "
				+ "-fx-alignment: center; " + "-fx-user-select: none; " + "-fx-text-transform: none;"
				+ "-fx-font-family: 'Montserrat';" + "-fx-font-style: italic;" + "-fx-font-weight: bold;"
				+ "-fx-text-fill: #F5EFFF;" + "-fx-font-size: 16px ;");

		this.setOnMouseEntered(event -> {
			this.setStyle("-fx-background-color: transparent; " + "-fx-border-color: #A294F9; "
					+ "-fx-border-radius: 6px; " + "-fx-line-height: 20px; " + "-fx-cursor: pointer; "
					+ "-fx-alignment: center; " + "-fx-user-select: none; " + "-fx-text-transform: none;"
					+ "-fx-font-family: 'Montserrat';" + "-fx-font-style: italic;" + "-fx-font-weight: bold;"
					+ "-fx-text-fill: #A294F9;" + "-fx-font-size: 16px ;");
			if (this.getGraphic() != null) {
				ColorAdjust colorAdjust = new ColorAdjust();
				colorAdjust.setContrast(0.1);
				colorAdjust.setHue(-0.0556);
				colorAdjust.setBrightness(-0.2);
				colorAdjust.setSaturation(-0.2);
				this.getGraphic().setEffect(colorAdjust);
			}
		});

		this.setOnMouseExited(event -> {
			this.setStyle("-fx-background-color: #A294F9; " + "-fx-border-color: #A294F9;; "
					+ "-fx-border-radius: 6px; " + "-fx-box-shadow: rgba(0, 0, 0, 0.1) 1px 2px 4px; "
					+ "-fx-cursor: pointer; " + "-fx-alignment: center; " + "-fx-user-select: none; "
					+ "-fx-text-transform: none;" + "-fx-font-family: 'Montserrat';" + "-fx-font-style: italic;"
					+ "-fx-font-weight: bold;" + "-fx-text-fill: #F5EFFF;" + "-fx-font-size: 16px ;");
			if (this.getGraphic() != null) {

				ColorAdjust colorAdjust = new ColorAdjust();
				colorAdjust.setContrast(0);
				colorAdjust.setHue(0);
				colorAdjust.setBrightness(0);
				colorAdjust.setSaturation(0);
				this.getGraphic().setEffect(colorAdjust);
			}

		});
		this.setOnMousePressed(event -> {
			this.setStyle("-fx-background-color: transparent; " + "-fx-border-color: #FF4742; " + "-fx-opacity: 0.5;"
					+ "-fx-border-radius: 6px; " + "-fx-cursor: pointer; " + "-fx-font-family: 'Montserrat';"
					+ "-fx-font-style: italic;" + "-fx-font-weight: bold;" + "-fx-alignment: center; "
					+ "-fx-user-select: none; " + "-fx-font-size: 16px ;");

		});
	}

	public void setIcon(String iconPath, double h, double w) {
		Image addImage = new Image(iconPath);
		ImageView addIcon = new ImageView(addImage);
		addIcon.setFitHeight(h);
		addIcon.setFitWidth(w);
		this.setGraphic(addIcon);
	}
}
