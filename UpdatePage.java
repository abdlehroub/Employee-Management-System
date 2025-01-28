package application;

import java.io.File;
import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UpdatePage extends Scene {

	static VBox addBp = new VBox();
	File file;
	static Image empI = Main.defultImage;
	static ImageView image = new ImageView(Main.defultImage);
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
	static HBox typeHb = new HBox();
	static HBox dependsOnTypeHb = new HBox();
	static TextField annualSalaryT = new MyTextField();
	static TextField rateT = new MyTextField();
	static TextField hoursT = new MyTextField();
	static TextField salaryT = new MyTextField();
	static TextField itemsPerMonthT = new MyTextField();
	static TextField basedOnSalaryT = new MyTextField();
	static HBox educationHbox = new HBox();
	static ToggleGroup group = new ToggleGroup();
	static Label eduL = new MyLabel("Education: ");
	static RadioButton phdRb = new MyRadioButton("PhD.");
	static RadioButton mastre = new MyRadioButton("Mastre");
	static RadioButton ba = new MyRadioButton("B. A");
	static RadioButton secSchoolRb = new MyRadioButton("Scondary School");
	static RadioButton primSchoolRb = new MyRadioButton("Primary School");

	Button backB = new MyButton();

	public UpdatePage() {
		super(addBp, 1120, 680);
		addBp.setStyle("-fx-background-color: #F5EFFF;");
		GridPane textsPane = new GridPane();

        // Labels for employee details
		MyLabel empNoL = new MyLabel("Employee Number: ");
		Label firstNameL = new MyLabel("First Name: ");
		Label lastNameL = new MyLabel("Last Name: ");
		Label birthDateL = new MyLabel("Date of birth: ");
		Label designationL = new MyLabel("Designation: ");
		Label emailL = new MyLabel("Email: ");
		Label phoneNoL = new MyLabel("Phone Number: ");
		textsPane.addColumn(0, empNoL, firstNameL, lastNameL, birthDateL, designationL, emailL, phoneNoL);

		empNoT.setText("" + (Employee.getEmpCounter() + 1));
		empNoT.setEditable(false);

		HBox date = new HBox();
		birthDateTf.setEditable(false);
		DatePicker datePicker = new DatePicker();
		datePicker.setStyle("-fx-opacity: 0; -fx-max-width: 0; -fx-max-height: 0;");
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

        // Photo upload section
		MyButton photoB = new MyButton();
		photoB.setPrefHeight(40);
		photoB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\camera.png", 30, 30);
		photoB.setPrefWidth(300);

		HBox photoHb = new HBox();
		photoHb.setAlignment(Pos.CENTER);
		photoHb.setSpacing(80);

		VBox photoVb = new VBox();
		image.setFitHeight(300);
		image.setFitWidth(300);
		photoVb.getChildren().addAll(image, photoB);
		photoHb.getChildren().addAll(textsPane, photoVb);

		addBp.getChildren().add(photoHb);

        // Handle photo selection
		photoB.setOnAction(e -> {
			photoChooser();
			if (image != null) {
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

        // Address section
		HBox adressHbox = new HBox();
		Label streetL = new MyLabel("Street: ");
		Label cityL = new MyLabel("City: ");
		Label countryL = new MyLabel("Country: ");
		adressHbox.getChildren().addAll(streetL, streetT, cityL, cityT, countryL, countryT);
		addBp.getChildren().add(adressHbox);
		adressHbox.setAlignment(Pos.CENTER);
		adressHbox.setSpacing(10);

        // Education section
		phdRb.setToggleGroup(group);
		mastre.setToggleGroup(group);
		ba.setToggleGroup(group);
		secSchoolRb.setToggleGroup(group);
		primSchoolRb.setToggleGroup(group);
		educationHbox.getChildren().addAll(eduL, phdRb, mastre, ba, secSchoolRb, primSchoolRb);
		educationHbox.setAlignment(Pos.CENTER);
		educationHbox.setSpacing(20);
		addBp.getChildren().add(educationHbox);
		addBp.setSpacing(30);

        // Employee type section
		Label typeL = new MyLabel("Employee Type");
		typeCb.getItems().addAll("Hourly Employee", "Salaried Employee", "Commession Employee",
				"Employee based Comession");
		typeCb.setStyle("-fx-background-color: #E5D9F2;" + "-fx-background-radius: 4px;" + "-fx-border-color:#A294F9; "
				+ "-fx-border-width: 1px; -fx-border-radius: 4px;-fx-font-weight: bold; " + "-fx-text-fill: #A294F9; "
				+ "-fx-font-style: italic;" + "-fx-font-size: 15px;" + "-fx-text-fill: #A294F9;"
				+ "-fx-highlight-text-fill: #A294F9;");

		typeHb.getChildren().addAll(typeL, typeCb);
		typeHb.setSpacing(20);
		typeHb.setAlignment(Pos.CENTER);

		fieldsDependsOnType();
		typeHb.getChildren().add(dependsOnTypeHb);
		addBp.getChildren().add(typeHb);

        // Navigation buttons
		HBox nextPreHb = new HBox();
		MyButton prevB = new MyButton();
		prevB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\angle-small-right (1).png", 30, 30);
		prevB.setPrefWidth(90);
		MyButton nextB = new MyButton();
		nextB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\angle-small-right.png", 30, 30);
		nextB.setPrefWidth(90);
		nextPreHb.getChildren().addAll(prevB, nextB);
		addBp.getChildren().add(nextPreHb);
		nextPreHb.setSpacing(600);
		nextPreHb.setAlignment(Pos.CENTER);

		HBox buttonsHb = new HBox();
		Button updateB = new MyButton();
		updateB.setText("Update Employee");
		updateB.setPrefWidth(250);

		backB.setText("Back");
		backB.setPrefWidth(250);

		buttonsHb.getChildren().addAll(updateB, backB);
		buttonsHb.setAlignment(Pos.CENTER);
		buttonsHb.setSpacing(40);
		addBp.getChildren().add(buttonsHb);

        // Handle the "Update Employee" button action
		updateB.setOnAction(e -> {
			try {
				if (typeCb.getValue() != null) {
					if (typeCb.getValue().equals("Salaried Employee")) {
						Employee updatedEmp = new SalariedEmployee(firstNameT.getText(), lastNameT.getText(),
								birthDateTf.getText(),
								new Address(streetT.getText(), cityT.getText(), countryT.getText()), phoneNoT.getText(),
								emailT.getText(), countryT.getText(), designationT.getText(),
								((RadioButton) group.getSelectedToggle()).getText(), empI,
								Double.parseDouble(annualSalaryT.getText()));
						updatedEmp.setEmpNo((Main.empCounter + 1) + "");
						Main.employees.set(Main.empCounter, updatedEmp);
						showSuccAlert();
						Employee.setEmpCounter(Employee.getEmpCounter() - 1);

					} else if (typeCb.getValue().equalsIgnoreCase("Hourly Employee")) {
						Employee updatedEmp = new HourlyEmployee(firstNameT.getText(), lastNameT.getText(),
								birthDateTf.getText(),
								new Address(streetT.getText(), cityT.getText(), countryT.getText()), phoneNoT.getText(),
								emailT.getText(), countryT.getText(), designationT.getText(),
								((RadioButton) group.getSelectedToggle()).getText(), empI,
								Short.parseShort(hoursT.getText()), Float.parseFloat(rateT.getText()));
						updatedEmp.setEmpNo((Main.empCounter + 1) + "");
						Main.employees.set(Main.empCounter, updatedEmp);
						showSuccAlert();
						Employee.setEmpCounter(Employee.getEmpCounter() - 1);

					} else if (typeCb.getValue().equalsIgnoreCase("Commession Employee")) {

						Employee updatedEmp = new CommessionEmployee(firstNameT.getText(), lastNameT.getText(),
								birthDateTf.getText(),
								new Address(streetT.getText(), cityT.getText(), countryT.getText()), phoneNoT.getText(),
								emailT.getText(), countryT.getText(), designationT.getText(),
								((RadioButton) group.getSelectedToggle()).getText(), empI,
								Double.parseDouble(itemsPerMonthT.getText()));
						updatedEmp.setEmpNo((Main.empCounter + 1) + "");
						Main.employees.set(Main.empCounter, updatedEmp);
						showSuccAlert();
						Employee.setEmpCounter(Employee.getEmpCounter() - 1);

					} else if (typeCb.getValue().equalsIgnoreCase("Employee based Comession")) {
						Employee updatedEmp = new EmployeeBasedComession(firstNameT.getText(), lastNameT.getText(),
								birthDateTf.getText(),
								new Address(streetT.getText(), cityT.getText(), countryT.getText()), phoneNoT.getText(),
								emailT.getText(), countryT.getText(), designationT.getText(),
								((RadioButton) group.getSelectedToggle()).getText(), empI, 1, 2);
						updatedEmp.setEmpNo((Main.empCounter + 1) + "");
						Main.employees.set(Main.empCounter, updatedEmp);
						showSuccAlert();
						Employee.setEmpCounter(Employee.getEmpCounter() - 1);

					} else {
						Alert noTypeAlert = new Alert(AlertType.ERROR);
						noTypeAlert.setTitle("Empty Information");
						noTypeAlert.setHeaderText("No type selected");
						noTypeAlert.setContentText("Please select an employee type");
						noTypeAlert.showAndWait();
					}
				}

			} catch (InvalidInputException | NumberFormatException e1) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Wrong information");
				alert.setHeaderText("There is empty or invalid informatiot");
				alert.setContentText("Please enter valid informtion");
				alert.showAndWait();

			}

		});
		typeCb.setOnAction(e -> {
			dependsOnTypeHb.getChildren().clear();
			fieldsDependsOnType();
		});

		nextB.setOnAction(e -> {
			if (Main.empCounter < Main.employees.size() - 1) {
				Main.empCounter++;
				new PreUpdateEvent().handle(e);
			}
		});
		prevB.setOnAction(e -> {
			if (Main.empCounter > 0) {
				Main.empCounter--;
				new PreUpdateEvent().handle(e);
			}
		});

		hoursT.setOnKeyTyped(e -> {
			try {
				salaryT.setText(Short.parseShort(hoursT.getText()) * Float.parseFloat(rateT.getText()) + "");
			} catch (NumberFormatException e1) {
			}
		});
		rateT.setOnKeyTyped(e -> {
			try {
				salaryT.setText(Short.parseShort(hoursT.getText()) * Float.parseFloat(rateT.getText()) + "");

			} catch (NumberFormatException e1) {
			}
		});

		itemsPerMonthT.setOnKeyTyped(e -> {
			salaryT.setText(
					Double.parseDouble(itemsPerMonthT.getText()) * Double.parseDouble(basedOnSalaryT.getText()) + "");
		});
		basedOnSalaryT.setOnKeyTyped(e -> {
			salaryT.setText(
					Double.parseDouble(itemsPerMonthT.getText()) * Double.parseDouble(basedOnSalaryT.getText()) + "");
		});
		itemsPerMonthT.setOnKeyTyped(e -> {
			salaryT.setText(
					Double.parseDouble(itemsPerMonthT.getText()) * Double.parseDouble(basedOnSalaryT.getText()) + "");
		});
		annualSalaryT.setOnKeyTyped(e -> {
			salaryT.setText(Double.parseDouble(annualSalaryT.getText()) / 12 + "");
		});

	}

    // Method to handle file chooser for selecting an image
	public void photoChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters()
				.add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif", "*.bmp"));
		file = fileChooser.showOpenDialog(new Stage());

	}

    // Method to dynamically display fields based on employee type
	public static void fieldsDependsOnType() {
		if (typeCb.getValue() != null) {
			dependsOnTypeHb.getChildren().clear();
			if (typeCb.getValue().equals("Salaried Employee")) {
				MyLabel annualSalaryL = new MyLabel("Annual Salary");
				MyLabel salaryL = new MyLabel("Salary: ");
				annualSalaryL.setPadding(new Insets(0, 0, 0, 60));

				if (Main.employees.get(Main.empCounter) instanceof SalariedEmployee)
					annualSalaryT
							.setText(((SalariedEmployee) Main.employees.get(Main.empCounter)).getAnnualSalary() + "");
				dependsOnTypeHb.getChildren().addAll(annualSalaryL, annualSalaryT, salaryL, salaryT);
				dependsOnTypeHb.setSpacing(10);
				dependsOnTypeHb.setAlignment(Pos.CENTER);
			} else if (typeCb.getValue().equals("Hourly Employee")) {
				MyLabel rateL = new MyLabel("Rate: ");
				rateL.setPadding(new Insets(0, 0, 0, 60));
				rateT.setPrefWidth(50);
				MyLabel hoursL = new MyLabel("Hours: ");
				if (Main.employees.get(Main.empCounter) instanceof HourlyEmployee) {
					rateT.setText(((HourlyEmployee) Main.employees.get(Main.empCounter)).getRate() + "");
					hoursT.setText(((HourlyEmployee) Main.employees.get(Main.empCounter)).getHours() + "");
					salaryT.setText(((HourlyEmployee) Main.employees.get(Main.empCounter)).payment() + "");
				}
				hoursT.setPrefWidth(50);
				MyLabel salaryL = new MyLabel("Salary: ");
				salaryT.setPrefWidth(50);
				salaryT.setEditable(false);
				dependsOnTypeHb.getChildren().addAll(rateL, rateT, hoursL, hoursT, salaryL, salaryT);
				dependsOnTypeHb.setSpacing(10);
				dependsOnTypeHb.setAlignment(Pos.CENTER);

			} else if (typeCb.getValue().equals("Commession Employee")) {
				MyLabel itemsPerMonthL = new MyLabel("Items Per Month");
				itemsPerMonthL.setPadding(new Insets(0, 0, 0, 60));
				itemsPerMonthT.setPrefWidth(50);
				MyLabel salaryL = new MyLabel("Salary: ");
				if (Main.employees.get(Main.empCounter) instanceof CommessionEmployee)
					itemsPerMonthT.setText(
							((CommessionEmployee) Main.employees.get(Main.empCounter)).getSoldItemsPerMounth() + "");
				dependsOnTypeHb.getChildren().addAll(itemsPerMonthL, itemsPerMonthT, salaryL, salaryT);
				dependsOnTypeHb.setSpacing(10);
				dependsOnTypeHb.setAlignment(Pos.CENTER);

			} else if (typeCb.getValue().equals("Employee based Comession")) {
				MyLabel basedOnSalaryL = new MyLabel("Based On Salary: ");
				MyLabel itemsPerMonthL = new MyLabel("Items Per Month");
				MyLabel salaryL = new MyLabel("Salary: ");
				basedOnSalaryL.setPadding(new Insets(0, 0, 0, 60));
				if (Main.employees.get(Main.empCounter) instanceof EmployeeBasedComession)
					basedOnSalaryT.setText(
							((EmployeeBasedComession) Main.employees.get(Main.empCounter)).getSoldItemsPerMounth()
									+ "");
				salaryT.setPrefWidth(50);
				basedOnSalaryT.setPrefWidth(50);
				itemsPerMonthT.setPrefWidth(50);

				salaryT.setEditable(false);
				dependsOnTypeHb.getChildren().addAll(basedOnSalaryL, basedOnSalaryT, itemsPerMonthL, itemsPerMonthT,
						salaryL, salaryT);
				dependsOnTypeHb.setSpacing(10);
				dependsOnTypeHb.setAlignment(Pos.CENTER);

			}
		}
	}

    // Method to show a confirmation alert after updating employee
	public void showSuccAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Done!");
		alert.setHeaderText("Employees Updated Successfully!");
		alert.showAndWait();
	}

}
