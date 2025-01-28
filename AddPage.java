package application;

import java.io.File;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddPage extends Scene {

	static VBox addBp = new VBox();
	File file;
	static ImageView image = new ImageView(Main.defultImage);
	static Image empI = Main.defultImage;
	static TextField empNoT = new MyTextField();
	static TextField birthDateTf = new MyTextField();
	static TextField designationT = new MyTextField();
	static TextField emailT = new MyTextField();
	static TextField phoneNoT = new MyTextField();
	static TextField streetT = new MyTextField();
	static TextField cityT = new MyTextField();
	static TextField countryT = new MyTextField();
	static TextField firstNameT = new MyTextField();
	static TextField lastNameT = new MyTextField();
	static ComboBox<String> typeCb = new ComboBox<String>();

	Button backB = new MyButton();

	public AddPage() {
		super(addBp, 1120, 640);
		addBp.setStyle("-fx-background-color: #F5EFFF;");
		GridPane textsPane = new GridPane();

		MyLabel empNoL = new MyLabel("Employee Number: ");
		Label firstNameL = new MyLabel("First Name: ");
		Label lastNameL = new MyLabel("Last Name: ");
		Label birthDateL = new MyLabel("Date of birth: ");
		Label designationL = new MyLabel("Designation: ");
		Label emailL = new MyLabel("Email: ");
		Label phoneNoL = new MyLabel("Phone Number: ");
		textsPane.addColumn(0, empNoL, firstNameL, lastNameL, birthDateL, designationL, emailL, phoneNoL);

        // Automatically set employee number and make it non-editable
		empNoT.setText("" + (Employee.getEmpCounter() + 1));
		empNoT.setEditable(false);

        // Date of birth field with a hidden date picker
		HBox date = new HBox();
		birthDateTf.setEditable(false);
		DatePicker datePicker = new DatePicker();
		datePicker.setStyle("-fx-opacity: 0; -fx" + "-max-width: 0; -fx-max-height: 0;");
		datePicker.setOnAction(event -> {
			LocalDate selectedDate = datePicker.getValue();
			birthDateTf.setText(selectedDate.toString());
		});
		MyButton birthDateB = new MyButton();
		birthDateB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\calendar-day.png", 20, 20);
		birthDateB.setOnAction(event -> datePicker.show());
		date.getChildren().addAll(birthDateTf, datePicker, birthDateB);

		textsPane.addColumn(1, empNoT, firstNameT, lastNameT, date, designationT, emailT, phoneNoT);
		textsPane.setVgap(10);

        // Button for selecting and displaying an employee photo
		MyButton photoB = new MyButton();
		photoB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\camera.png", 80, 80);
		photoB.setPrefHeight(300);
		photoB.setPrefWidth(300);

        // Layout for the photo section
		HBox photoHb = new HBox();
		photoHb.setAlignment(Pos.CENTER);
		photoHb.setSpacing(80);

		addBp.getChildren().add(photoHb);

		VBox photoVb = new VBox();
		photoVb.setPrefHeight(photoB.getPrefHeight());
		photoVb.setPrefWidth(photoB.getPrefWidth());
		photoVb.getChildren().add(photoB);
		photoHb.getChildren().addAll(textsPane, photoVb);

        // When the photo button is clicked, allow the user to choose a photo
		photoB.setOnAction(e -> {
			photoChooser();
			if (empI != null) {
				image.setImage(null);
				photoVb.getChildren().remove(image);

			}
			empI = new Image(file.toURI().toString());
			image = new ImageView(empI);
			image.setFitHeight(300);
			image.setFitWidth(300);
			photoB.setPrefHeight(40);
			photoB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\camera.png", 30, 30);
			photoVb.getChildren().remove(photoB);
			photoVb.getChildren().addAll(image, photoB);
			photoVb.setSpacing(5);

		});
		
		
        // Address section with labels and text fields
		HBox adressHbox = new HBox();
		Label streetL = new MyLabel("Street: ");
		Label cityL = new MyLabel("City: ");
		Label countryL = new MyLabel("Country: ");
		adressHbox.getChildren().addAll(streetL, streetT, cityL, cityT, countryL, countryT);
		addBp.getChildren().add(adressHbox);
		adressHbox.setAlignment(Pos.CENTER);
		adressHbox.setSpacing(10);

        // Education section with radio buttons
		HBox educationHbox = new HBox();
		ToggleGroup group = new ToggleGroup();
		Label eduL = new MyLabel("Education: ");
		RadioButton phdRb = new MyRadioButton("PhD.");
		RadioButton mastre = new MyRadioButton("Mastre");
		RadioButton ba = new MyRadioButton("B. A");
		RadioButton secSchoolRb = new MyRadioButton("Scondary School");
		RadioButton primSchoolRb = new MyRadioButton("Primary School");
		RadioButton otherRb = new MyRadioButton("Other");
		phdRb.setToggleGroup(group);
		mastre.setToggleGroup(group);
		ba.setToggleGroup(group);
		secSchoolRb.setToggleGroup(group);
		primSchoolRb.setToggleGroup(group);
		otherRb.setToggleGroup(group);
		primSchoolRb.setSelected(true);
		educationHbox.getChildren().addAll(eduL, phdRb, mastre, ba, secSchoolRb, primSchoolRb,otherRb);
		educationHbox.setAlignment(Pos.CENTER);
		educationHbox.setSpacing(20);
		addBp.getChildren().add(educationHbox);
		addBp.setSpacing(30);

		HBox typeHb = new HBox();
		Label typeL = new MyLabel("Employee Type");
		typeCb.getItems().addAll("Hourly Employee", "Salaried Employee", "Commession Employee",
				"Employee based Comession");
		typeCb.setStyle("-fx-background-color: #E5D9F2;" + "-fx-background-radius: 4px;" + "-fx-border-color:#A294F9; "
				+ "-fx-border-width: 1px; " + "-fx-border-radius: 4px; " + "-fx-font-weight: bold; "
				+ "-fx-text-fill: #A294F9; " + "-fx-font-style: italic;" + "-fx-font-size: 15px;"
				+ "-fx-text-fill: #A294F9;" + "-fx-highlight-text-fill: #A294F9;");

		typeHb.getChildren().addAll(typeL, typeCb);
		typeHb.setSpacing(20);
		addBp.getChildren().add(typeHb);
		typeHb.setAlignment(Pos.CENTER);

		
        // Buttons for adding details, clearing fields, and going back
		HBox buttonsHb = new HBox();
		Button addDeitalsB = new MyButton();
		addDeitalsB.setText("Add Details");
		addDeitalsB.setPrefWidth(150);
		Button clearB = new MyButton();
		clearB.setText("Clear");
		clearB.setPrefWidth(150);

		backB.setText("Back");
		backB.setPrefWidth(150);

		buttonsHb.getChildren().addAll(addDeitalsB, clearB, backB);
		buttonsHb.setAlignment(Pos.CENTER);
		buttonsHb.setSpacing(20);
		addBp.getChildren().add(buttonsHb);

		
        // Action for adding employee details
		addDeitalsB.setOnAction(e -> {
			try {
				if (typeCb.getValue() != null) {
					if (typeCb.getValue().equals("Salaried Employee")) {
						Main.employees.add(new SalariedEmployee(firstNameT.getText(), lastNameT.getText(),
								birthDateTf.getText(),
								new Address(streetT.getText(), cityT.getText(), countryT.getText()), phoneNoT.getText(),
								emailT.getText(), countryT.getText(), designationT.getText(),
								((RadioButton) group.getSelectedToggle()).getText(), empI, 0.0));
						showSuccAlert();
						new ClearEvent().handle(e);

					} else if (typeCb.getValue().equalsIgnoreCase("Hourly Employee")) {
						Main.employees.add(new HourlyEmployee(firstNameT.getText(), lastNameT.getText(),
								birthDateTf.getText(),
								new Address(streetT.getText(), cityT.getText(), countryT.getText()), phoneNoT.getText(),
								emailT.getText(), countryT.getText(), designationT.getText(),
								((RadioButton) group.getSelectedToggle()).getText(), empI, (short) 2, 4.0f));
						showSuccAlert();
						new ClearEvent().handle(e);

					} else if (typeCb.getValue().equalsIgnoreCase("Commession Employee")) {
						Main.employees.add(new CommessionEmployee(firstNameT.getText(), lastNameT.getText(),
								birthDateTf.getText(),
								new Address(streetT.getText(), cityT.getText(), countryT.getText()), phoneNoT.getText(),
								emailT.getText(), countryT.getText(), designationT.getText(),
								((RadioButton) group.getSelectedToggle()).getText(), empI, 1));
						showSuccAlert();
						new ClearEvent().handle(e);

					} else if (typeCb.getValue().equalsIgnoreCase("Employee based Comession")) {
						Main.employees.add(new EmployeeBasedComession(firstNameT.getText(), lastNameT.getText(),
								birthDateTf.getText(),
								new Address(streetT.getText(), cityT.getText(), countryT.getText()), phoneNoT.getText(),
								emailT.getText(), countryT.getText(), designationT.getText(),
								((RadioButton) group.getSelectedToggle()).getText(), empI, 1, 2));
						showSuccAlert();
						new ClearEvent().handle(e);

					}
				} else {
                    // Show error if no type is selected
					Alert noTypeAlert = new Alert(AlertType.ERROR);
					noTypeAlert.setTitle("Empty Information");
					noTypeAlert.setHeaderText("No type selected");
					noTypeAlert.setContentText("Please select an employee type");
					noTypeAlert.showAndWait();
				}

			} catch (InvalidInputException e1) {
                // Show error if inputs are invalid
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Wrong information");
				alert.setHeaderText("There is empty or invalid informatiot");
				alert.setContentText("Please enter valid informtion");
				alert.showAndWait();

			}

		});
		clearB.setOnAction(new ClearEvent());

	}

	
	// Choose Photo by file chooser
	public void photoChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters()
				.add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif", "*.bmp"));
		file = fileChooser.showOpenDialog(new Stage());

	}

	// Show successfully alert
	public void showSuccAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Done!");
		alert.setHeaderText("Employees Added Successfully!");
		alert.showAndWait();
	}

}
