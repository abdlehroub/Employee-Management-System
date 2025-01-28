package application;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RemovePage extends Scene {

	
    // Static text fields for employee details
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

	public RemovePage() {
		super(addBp, 1120, 680);
		addBp.setStyle("-fx-background-color: #F5EFFF;");
		GridPane textsPane = new GridPane();

		designationT.setEditable(false);
		emailT.setEditable(false);
		phoneNoT.setEditable(false);
		streetT.setEditable(false);
		cityT.setEditable(false);
		countryT.setEditable(false);
		firstNameT.setEditable(false);
		lastNameT.setEditable(false);
		annualSalaryT.setEditable(false);
		rateT.setEditable(false);
		hoursT.setEditable(false);
		salaryT.setEditable(false);
		itemsPerMonthT.setEditable(false);
		basedOnSalaryT.setEditable(false);

	    // Disable and make fields non-editable
		empNoT.setDisable(true);
		designationT.setDisable(true);
		emailT.setDisable(true);
		phoneNoT.setDisable(true);
		streetT.setDisable(true);
		cityT.setDisable(true);
		countryT.setDisable(true);
		firstNameT.setDisable(true);
		lastNameT.setDisable(true);
		annualSalaryT.setDisable(true);
		rateT.setDisable(true);
		hoursT.setDisable(true);
		salaryT.setDisable(true);
		itemsPerMonthT.setDisable(true);
		basedOnSalaryT.setDisable(true);
		birthDateTf.setDisable(true);

		
	    // Set up employee details section
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
		MyButton birthDateB = new MyButton();
		birthDateB.setDisable(true);

		birthDateB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\calendar-day.png", 20, 20);
		date.getChildren().addAll(birthDateTf, birthDateB);
		date.setSpacing(5);

		textsPane.addColumn(1, empNoT, firstNameT, lastNameT, date, designationT, emailT, phoneNoT);
		textsPane.setVgap(10);

	    // Set up photo section
		MyButton photoB = new MyButton();
		photoB.setDisable(true);

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

	    // Set up address section
		HBox adressHbox = new HBox();
		Label streetL = new MyLabel("Street: ");
		Label cityL = new MyLabel("City: ");
		Label countryL = new MyLabel("Country: ");
		adressHbox.getChildren().addAll(streetL, streetT, cityL, cityT, countryL, countryT);
		addBp.getChildren().add(adressHbox);
		adressHbox.setAlignment(Pos.CENTER);
		adressHbox.setSpacing(10);

	    // Set up education section
		phdRb.setToggleGroup(group);
		mastre.setToggleGroup(group);
		ba.setToggleGroup(group);
		secSchoolRb.setToggleGroup(group);
		primSchoolRb.setToggleGroup(group);
		phdRb.setDisable(true);
		mastre.setDisable(true);
		ba.setDisable(true);
		secSchoolRb.setDisable(true);
		primSchoolRb.setDisable(true);

		educationHbox.getChildren().addAll(eduL, phdRb, mastre, ba, secSchoolRb, primSchoolRb);
		educationHbox.setAlignment(Pos.CENTER);
		educationHbox.setSpacing(20);
		addBp.getChildren().add(educationHbox);
		addBp.setSpacing(30);

	    // Set up employee type and dynamic fields
		Label typeL = new MyLabel("Employee Type");
		typeCb.getItems().addAll("Hourly Employee", "Salaried Employee", "Commession Employee",
				"Employee based Comession");
		typeCb.setStyle("-fx-background-color: #E5D9F2;" + "-fx-background-radius: 4px;" + "-fx-border-color:#A294F9; "
				+ "-fx-border-width: 1px; -fx-border-radius: 4px;-fx-font-weight: bold; " + "-fx-text-fill: #A294F9; "
				+ "-fx-font-style: italic;" + "-fx-font-size: 15px;" + "-fx-text-fill: #A294F9;"
				+ "-fx-highlight-text-fill: #A294F9;");
		typeCb.setDisable(true);

		typeHb.getChildren().addAll(typeL, typeCb);
		typeHb.setSpacing(20);
		typeHb.setAlignment(Pos.CENTER);

		fieldsDependsOnType();
		typeHb.getChildren().add(dependsOnTypeHb);
		addBp.getChildren().add(typeHb);

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
		Button removeB = new MyButton();
		removeB.setText("Remove Employee");
		removeB.setPrefWidth(250);

		backB.setText("Back");
		backB.setPrefWidth(250);

		buttonsHb.getChildren().addAll(removeB, backB);
		buttonsHb.setAlignment(Pos.CENTER);
		buttonsHb.setSpacing(40);
		addBp.getChildren().add(buttonsHb);

        // Update fields based on selected employee type
		typeCb.setOnAction(e -> {
			dependsOnTypeHb.getChildren().clear();
			fieldsDependsOnType();
		});
		
        // Enable/disable navigation buttons based on position
		if (Main.empCounter == Main.employees.size() - 1)
			nextB.setDisable(true);
		if (Main.empCounter == 0)
			prevB.setDisable(true);

		nextB.setOnAction(e -> {
			if (Main.empCounter == Main.employees.size() - 2) {
				prevB.setDisable(false);
				nextB.setDisable(true);
			} else {
				prevB.setDisable(false);
			}
			if (Main.empCounter < Main.employees.size() - 1) {
				Main.empCounter++;
				new PreRemoveEvent().handle(e);
			}

		});
		prevB.setOnAction(e -> {
			if (Main.empCounter > 0) {
				Main.empCounter--;
				new PreRemoveEvent().handle(e);
			}
			if (Main.empCounter == 0) {
				prevB.setDisable(true);
				nextB.setDisable(false);
			} else {
				nextB.setDisable(false);
			}

		});
		removeB.setOnAction(e -> {
			Main.employees.remove(Main.empCounter);
			Main.empCounter--;
			if (Main.empCounter != -1)
				new PreRemoveEvent().handle(e);
			else {
				Main.empCounter = Main.empCounter + Employee.empCounter - 1;
				new PreRemoveEvent().handle(e);

			}
			showSuccAlert();

		});

	}
	
    // Dynamically update fields based on employee type
	public static void fieldsDependsOnType() {
		if (typeCb.getValue() != null) {
			dependsOnTypeHb.getChildren().clear();
			if (typeCb.getValue().equals("Salaried Employee")) {
				MyLabel annualSalaryL = new MyLabel("Annual Salary");
				annualSalaryL.setPadding(new Insets(0, 0, 0, 60));
				if (Main.employees.get(Main.empCounter) instanceof SalariedEmployee)
					annualSalaryT
							.setText(((SalariedEmployee) Main.employees.get(Main.empCounter)).getAnnualSalary() + "");
				dependsOnTypeHb.getChildren().addAll(annualSalaryL, annualSalaryT);
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
				if (Main.employees.get(Main.empCounter) instanceof CommessionEmployee)
					itemsPerMonthT.setText(
							((CommessionEmployee) Main.employees.get(Main.empCounter)).getSoldItemsPerMounth() + "");
				dependsOnTypeHb.getChildren().addAll(itemsPerMonthL, itemsPerMonthT);
				dependsOnTypeHb.setSpacing(10);
				dependsOnTypeHb.setAlignment(Pos.CENTER);

			} else if (typeCb.getValue().equals("Employee based Comession")) {
				MyLabel basedOnSalaryL = new MyLabel("Based On Salary: ");
				basedOnSalaryL.setPadding(new Insets(0, 0, 0, 60));
				if (Main.employees.get(Main.empCounter) instanceof EmployeeBasedComession)
					basedOnSalaryT.setText(
							((EmployeeBasedComession) Main.employees.get(Main.empCounter)).getSoldItemsPerMounth()
									+ "");
				dependsOnTypeHb.getChildren().addAll(basedOnSalaryL, basedOnSalaryT);
				dependsOnTypeHb.setSpacing(10);
				dependsOnTypeHb.setAlignment(Pos.CENTER);

			}
		}
	}

	public void showSuccAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Done!");
		alert.setHeaderText("Employees Updated Successfully!");
		alert.showAndWait();
	}

}
