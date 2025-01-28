package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class MaxSalaryPane extends Pane {
	static ObservableList<Employee> maxSalary = FXCollections.observableArrayList();


	@SuppressWarnings({ "unchecked", "deprecation" })
	public MaxSalaryPane() {
		if (Main.employees.size() > 0)
			FindMax();

        // Create a table to display employees.
		EmployeesTable employeesTv = new EmployeesTable();
		employeesTv.setPrefHeight(600);
		employeesTv.setPrefWidth(1400);
		employeesTv.setItems(maxSalary);
		employeesTv.refresh();
		employeesTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);  // Adjust column sizes automatically.

		this.getChildren().add(employeesTv);
	}

    // Method to find employees with the highest salary in each type.
	public void FindMax() {
		maxSalary.clear();
		double maxSalaried = 0;
		int indexOfMaxSalaried = 0;
		double maxHourly = 0;
		int indexOfMaxHourly = 0;
		double maxCommession = 0;
		int indexOfMaxCommession = 0;
		double maxBased = 0;
		int indexOfMaxBased = 0;
		boolean salariedFlag = false;
		boolean hourlyFlag = false;
		boolean commessionFlag = false;
		boolean basedFlag = false;

		for (int i = 0; i < Main.employees.size(); i++) {
			if (Main.employees.get(i) instanceof SalariedEmployee) {
				if (Main.employees.get(i).payment() > maxSalaried) {
					maxSalaried = Main.employees.get(i).payment();
					indexOfMaxSalaried = i;
					salariedFlag = true;
				}
			} else if (Main.employees.get(i) instanceof HourlyEmployee) {
				if (Main.employees.get(i).payment() > maxHourly) {
					maxHourly = Main.employees.get(i).payment();
					indexOfMaxHourly = i;
					hourlyFlag = true;
				}
			} else if (Main.employees.get(i) instanceof CommessionEmployee) {
				if (Main.employees.get(i).payment() > maxCommession) {
					maxCommession = Main.employees.get(i).payment();
					indexOfMaxCommession = i;
					commessionFlag = true;
				}
			} else if (Main.employees.get(i) instanceof EmployeeBasedComession) {
				if (Main.employees.get(i).payment() > maxBased) {
					maxBased = Main.employees.get(i).payment();
					indexOfMaxBased = i;
					basedFlag = true;
				}
			}
		}
		if (salariedFlag)
			maxSalary.add(Main.employees.get(indexOfMaxSalaried));
		if (hourlyFlag)
			maxSalary.add(Main.employees.get(indexOfMaxHourly));
		if (commessionFlag)
			maxSalary.add(Main.employees.get(indexOfMaxCommession));
		if (basedFlag)
			maxSalary.add(Main.employees.get(indexOfMaxBased));
	}

}
