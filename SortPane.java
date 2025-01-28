package application;

import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SortPane extends Pane {

	static ObservableList<Employee> sortedList = FXCollections.observableArrayList();
	ComboBox<String> sortByCb = new ComboBox<String>();

	public SortPane() {
		VBox allVb = new VBox();
		HBox sortTypeHb = new HBox();
		Label sortByL = new MyLabel("Sort By: ");
		sortByL.setPadding(new Insets(4, 0, 0, 0));
		// Add sorting criteria to the ComboBox
		sortByCb.getItems().addAll("First Name", "Last Name", "Education", "Salary");
		sortByCb.setStyle("-fx-background-color: #E5D9F2;" + "-fx-background-radius: 4px;"
				+ "-fx-border-color:#A294F9; " + "-fx-border-width: 1px; " + "-fx-border-radius: 4px; "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: #A294F9; " + "-fx-font-style: italic;"
				+ "-fx-font-size: 15px;" + "-fx-text-fill: #A294F9;" + "-fx-highlight-text-fill: #A294F9;");
		sortByCb.setPrefWidth(250);
		// Add the label and ComboBox to the HBox
		sortTypeHb.getChildren().addAll(sortByL, sortByCb);
		sortTypeHb.setSpacing(10);
		allVb.getChildren().add(sortTypeHb);
		allVb.setSpacing(10);
		this.getChildren().add(allVb);

		// Set default sorting criteria if none is selected
		if (sortByCb.getValue() == null)
			sortByCb.setValue("First Name");
		if (sortByCb.getValue().equals("First Name")) {
			sortByFirstName();
		} else if (sortByCb.getValue().equals("Last Name")) {
			sortByLastName();
		} else if (sortByCb.getValue().equals("Education")) {
			sortByEducation();
		} else if (sortByCb.getValue().equals("Salary")) {
			sortBySalary();
		}

		// Set up an event listener to sort the list when selection changes
		sortByCb.setOnAction(e -> {
			if (sortByCb.getValue().equals("First Name")) {
				sortByFirstName();
			} else if (sortByCb.getValue().equals("Last Name")) {
				sortByLastName();
			} else if (sortByCb.getValue().equals("Education")) {
				sortByEducation();
			} else if (sortByCb.getValue().equals("Salary")) {
				sortBySalary();
			}
		});

		// Create an EmployeesTable object to display the sorted list of employees
		EmployeesTable employeesTv = new EmployeesTable();

		allVb.getChildren().add(employeesTv);

		employeesTv.setPrefHeight(600);
		employeesTv.setPrefWidth(1400);
		employeesTv.setItems(sortedList);
		employeesTv.refresh();
		employeesTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	}

	// Sort employees by first name
	public void sortByFirstName() {
		sortedList.clear();

		sortedList.addAll(Main.employees);
		sortedList.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return -o1.getFirstName().compareTo(o2.getFirstName());
			}
		});
	}

	// Sort employees by last name
	public void sortByLastName() {
		sortedList.clear();

		sortedList.addAll(Main.employees);
		sortedList.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return -o1.getLastName().compareTo(o2.getLastName());
			}
		});
	}

	// Sort employees by education level
	public void sortByEducation() {
		sortedList.clear();

		sortedList.addAll(Main.employees);
		sortedList.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return -(o1.getEducation().compareTo(o2.getEducation()));
			}
		});
	}

	// Sort employees by salary
	public void sortBySalary() {
		sortedList.clear();

		sortedList.addAll(Main.employees);
		sortedList.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return -(Double.valueOf(o1.payment()).compareTo(Double.valueOf(o2.payment())));
			}
		});
	}

}
