package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PreUpdateEvent implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent arg0) {
		if (Main.employees.size() != 0) {
			UpdatePage.empNoT.setText(Main.employees.get(Main.empCounter).getEmpNo());
			UpdatePage.image.setImage(Main.employees.get(Main.empCounter).getEmployeePhoto());
			UpdatePage.birthDateTf.setText(Main.employees.get(Main.empCounter).getDateOfBirth());
			UpdatePage.firstNameT.setText(Main.employees.get(Main.empCounter).getFirstName());
			UpdatePage.lastNameT.setText(Main.employees.get(Main.empCounter).getLastName());
			UpdatePage.designationT.setText(Main.employees.get(Main.empCounter).getDesignation());
			UpdatePage.emailT.setText(Main.employees.get(Main.empCounter).getEmail());
			UpdatePage.phoneNoT.setText(Main.employees.get(Main.empCounter).getPhoneNumber());
			UpdatePage.streetT.setText(Main.employees.get(Main.empCounter).getAddress().getStreet());
			UpdatePage.cityT.setText(Main.employees.get(Main.empCounter).getAddress().getCity());
			UpdatePage.countryT.setText(Main.employees.get(Main.empCounter).getAddress().getCountry());
			if (Main.employees.get(Main.empCounter).getClass().getSimpleName().equals("HourlyEmployee"))
				UpdatePage.typeCb.setValue("Hourly Employee");
			else if (Main.employees.get(Main.empCounter).getClass().getSimpleName().equals("SalariedEmployee"))
				UpdatePage.typeCb.setValue("Salaried Employee");
			else if (Main.employees.get(Main.empCounter).getClass().getSimpleName().equals("CommessionEmployee"))
				UpdatePage.typeCb.setValue("Commession Employee");
			else if (Main.employees.get(Main.empCounter).getClass().getSimpleName().equals("EmployeeBasedComession"))
				UpdatePage.typeCb.setValue("Employee based Comession");
			UpdatePage.fieldsDependsOnType();
			if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("PhD."))
				UpdatePage.phdRb.setSelected(true);
			else if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("Mastre"))
				UpdatePage.mastre.setSelected(true);
			else if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("B. A"))
				UpdatePage.ba.setSelected(true);
			else if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("Scondary School"))
				UpdatePage.secSchoolRb.setSelected(true);
			else if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("Primary School"))
				UpdatePage.primSchoolRb.setSelected(true);
			


		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error: No Employees");
			alert.setHeaderText("There is no added employees");
			alert.setContentText(null);
			alert.showAndWait();
		}
	}

}
