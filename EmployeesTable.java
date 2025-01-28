package application;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeesTable extends TableView<Employee> {
	public EmployeesTable() {
		TableColumn<Employee, String> stName = new TableColumn<Employee, String>("First Name");
		stName.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black;-fx-font-family: 'Montserrat'; ");

		TableColumn<Employee, String> lastName = new TableColumn<Employee, String>("Last Name");
		lastName.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black;-fx-font-family: 'Montserrat'; ");

		TableColumn<Employee, String> email = new TableColumn<Employee, String>("Email");
		email.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black;-fx-font-family: 'Montserrat'; ");

		TableColumn<Employee, String> desgination = new TableColumn<Employee, String>("Designation");
		desgination.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black;-fx-font-family: 'Montserrat'; ");

		TableColumn<Employee, String> dateOB = new TableColumn<Employee, String>("Date Of Birth");
		dateOB.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black;-fx-font-family: 'Montserrat'; ");

		TableColumn<Employee, String> educationC = new TableColumn<Employee, String>("Education");
		educationC.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black;-fx-font-family: 'Montserrat'; ");

		TableColumn<Employee, String> phoneNoC = new TableColumn<Employee, String>("Phone Number");
		phoneNoC.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black; -fx-font-family: 'Montserrat';");

		TableColumn<Employee, Address> addressC = new TableColumn<Employee, Address>(
				"\t  Adress \n Street,City,Country");
		addressC.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black; -fx-font-family: 'Montserrat';");

		TableColumn<Employee, String> typeC = new TableColumn<Employee, String>("Employee Type");
		typeC.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black;-fx-font-family: 'Montserrat'; ");

		TableColumn<Employee, Double> salaryC = new TableColumn<Employee, Double>("Salary");
		salaryC.setStyle(
				"-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black; -fx-font-family: 'Montserrat';");

		this.getColumns().addAll(stName, lastName, email, desgination, dateOB, educationC, phoneNoC, addressC, typeC,
				salaryC);

		stName.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		email.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
		desgination.setCellValueFactory(new PropertyValueFactory<Employee, String>("designation"));
		dateOB.setCellValueFactory(new PropertyValueFactory<Employee, String>("dateOfBirth"));
		educationC.setCellValueFactory(new PropertyValueFactory<Employee, String>("education"));
		phoneNoC.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));
		addressC.setCellValueFactory(new PropertyValueFactory<Employee, Address>("address"));
		typeC.setCellValueFactory(new PropertyValueFactory<Employee, String>("type"));
		salaryC.setCellValueFactory(new PropertyValueFactory<Employee, Double>("payment"));

	}

}
