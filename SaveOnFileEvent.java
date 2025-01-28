package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveOnFileEvent implements EventHandler<ActionEvent> {
	File file;

	@Override
	public void handle(ActionEvent arg0) {
		fileChooser();
		try {
            // Create a PrintWriter to write to the chosen file
			PrintWriter out = new PrintWriter(file);
			boolean isAdded = false;
			for (Employee employee : Main.employees) {
				if (employee instanceof SalariedEmployee) {
                    // Write salaried employee data
					out.println("Salaried Employee," + employee.getFirstName() + "," + employee.getLastName() + ","
							+ employee.getDateOfBirth() + "," + employee.getAddress().getStreet() + ","
							+ employee.getAddress().getCity() + "," + employee.getAddress().getCountry() + ","
							+ employee.getPhoneNumber() + "," + employee.getEmail() + "," + employee.getNationality()
							+ "," + employee.getDesignation() + "," + employee.getEducation() + ","
							+ ((SalariedEmployee) employee).getAnnualSalary());
					isAdded = true;// Mark that an employee was added
				} else if (employee instanceof HourlyEmployee) {
					out.println("Hourly Employee," + employee.getFirstName() + "," + employee.getLastName() + ","
							+ employee.getDateOfBirth() + "," + employee.getAddress().getStreet() + ","
							+ employee.getAddress().getCity() + "," + employee.getAddress().getCountry() + ","
							+ employee.getPhoneNumber() + "," + employee.getEmail() + "," + employee.getNationality()
							+ "," + employee.getDesignation() + "," + employee.getEducation() + ","
							+ ((HourlyEmployee) employee).getHours() + "," + ((HourlyEmployee) employee).getRate());
					isAdded = true;// Mark that an employee was added
				} else if (employee instanceof CommessionEmployee) {
					out.println("Commession Employee," + employee.getFirstName() + "," + employee.getLastName() + ","
							+ employee.getDateOfBirth() + "," + employee.getAddress().getStreet() + ","
							+ employee.getAddress().getCity() + "," + employee.getAddress().getCountry() + ","
							+ employee.getPhoneNumber() + "," + employee.getEmail() + "," + employee.getNationality()
							+ "," + employee.getDesignation() + "," + employee.getEducation() + ","
							+ ((CommessionEmployee) employee).getSoldItemsPerMounth());
					isAdded = true;// Mark that an employee was added
				} else if (employee instanceof EmployeeBasedComession) {
					out.println("Employee based Comession," + employee.getFirstName() + "," + employee.getLastName()
							+ "," + employee.getDateOfBirth() + "," + employee.getAddress().getStreet() + ","
							+ employee.getAddress().getCity() + "," + employee.getAddress().getCountry() + ","
							+ employee.getPhoneNumber() + "," + employee.getEmail() + "," + employee.getNationality()
							+ "," + employee.getDesignation() + "," + employee.getEducation() + ","
							+ ((EmployeeBasedComession) employee).getSoldItemsPerMounth() + ","
							+ ((EmployeeBasedComession) employee).getBasedOnSalary());
					isAdded = true;// Mark that an employee was added
				}

			}
			out.close();
			
            // Show success alert if employees were added
			if (isAdded)
				showSuccAlert();

		} catch (FileNotFoundException | NullPointerException e1) {
            // Show an error alert if there is an issue with the file or no employees were added
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Wrong information");
			alert.setHeaderText("There is no added employees!");
			alert.showAndWait();
		}

	}
	
    // Display success alert when employees are saved successfully
	public void showSuccAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Done!");
		alert.setHeaderText("Employees Saved Successfully!");
		alert.showAndWait();
	}

    // File chooser to select the file to save data
	public void fileChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
		file = fileChooser.showOpenDialog(new Stage());
	}
}
