package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ViewPage extends Scene {
	static VBox addBp = new VBox();
	MyButton backB = new MyButton();
	static EmployeesTable employeesTv = new EmployeesTable();
	static MyTextField empNoTf = new MyTextField();
	 MyButton deleteB = new MyButton();
	 MyButton updateB = new MyButton();
	MyButton searchB = new MyButton();
	ObservableList<Employee> filterdList = FXCollections.observableArrayList();



	@SuppressWarnings({ "deprecation" })
	public ViewPage() {
		super(addBp, 1280, 720);
		addBp.setStyle("-fx-background-color: #F5EFFF;");
		addBp.setSpacing(10);

		HBox empSearchHb = new HBox();
		MyLabel empNoL = new MyLabel("Employee Number: ");
		empSearchHb.getChildren().addAll(empNoL, empNoTf);
		addBp.getChildren().add(empSearchHb);
		empSearchHb.setSpacing(10);
		empNoL.setPadding(new Insets(7, 0, 0, 0));
		empSearchHb.setPadding(new Insets(0, 20, 0, 20));

		HBox backHb = new HBox();

		HBox buttonsHb = new HBox();
		HBox allButtonsHb = new HBox();
		buttonsHb.setPadding(new Insets(0, 0, 0, 10));
		searchB.setPrefWidth(102);
		searchB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\search.png", 20, 20);
		updateB.setPrefWidth(102);
		updateB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\file-edit.png", 20, 20);
		deleteB.setPrefWidth(102);
		deleteB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\trash.png", 20, 20);

		backB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\arrow-small-left.png", 20, 20);
		backB.setPrefWidth(120);
		backHb.getChildren().add(backB);
		buttonsHb.getChildren().addAll(searchB, updateB, deleteB);
		buttonsHb.setSpacing(10);
		allButtonsHb.getChildren().addAll(buttonsHb, backHb);
		allButtonsHb.setPadding(new Insets(0, 0, 0, 8));
		allButtonsHb.setSpacing(790);
		addBp.getChildren().add(allButtonsHb);

		
        // Initially disable buttons
		updateB.setDisable(true);
		searchB.setDisable(true);
		deleteB.setDisable(true);

		employeesTv.setStyle("-fx-background-color: #E5D9F2;");
		employeesTv.setPrefHeight(632);
		employeesTv.autosize();

		employeesTv.setItems(Main.employees);
		employeesTv.refresh();
		employeesTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Listener for employee number field to enable/disable buttons and filter employees
		empNoTf.setOnKeyTyped(e -> {
			if (!empNoTf.getText().isEmpty()) {
				updateB.setDisable(false);
				searchB.setDisable(false);
				deleteB.setDisable(false);
			} else {
				updateB.setDisable(true);
				searchB.setDisable(true);
				deleteB.setDisable(true);
			}
			
			filterdList.clear();
			Main.employees.forEach(emp -> {
				if (emp.getEmpNo().startsWith(empNoTf.getText())) {
					filterdList.add(emp);

				}
				if (!filterdList.isEmpty())
			        // Add the employee table to the page
					employeesTv.setItems(filterdList);
			});
			

		});


		addBp.getChildren().add(employeesTv);

        // Action for the search button
		searchB.setOnAction(e -> {
			filterdList.clear();
			Main.employees.forEach(emp -> {
				if (emp.getEmpNo().equals(empNoTf.getText())) {
					filterdList.add(emp);
				}
			});
			if (!filterdList.isEmpty())
				employeesTv.setItems(filterdList);
			else {
                // Show an error alert if no matching employee is found
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error: No Employees");
				alert.setHeaderText("There is no employee has this number");
				alert.setContentText(null);
				alert.showAndWait();
			}

		});

	}

}
