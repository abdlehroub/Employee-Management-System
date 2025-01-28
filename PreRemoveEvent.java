package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PreRemoveEvent implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent arg0) {
		if (Main.employees.size() != 0) {
			RemovePage.empNoT.setText(Main.employees.get(Main.empCounter).getEmpNo());
			RemovePage.image.setImage(Main.employees.get(Main.empCounter).getEmployeePhoto());
			RemovePage.birthDateTf.setText(Main.employees.get(Main.empCounter).getDateOfBirth());
			RemovePage.firstNameT.setText(Main.employees.get(Main.empCounter).getFirstName());
			RemovePage.lastNameT.setText(Main.employees.get(Main.empCounter).getLastName());
			RemovePage.designationT.setText(Main.employees.get(Main.empCounter).getDesignation());
			RemovePage.emailT.setText(Main.employees.get(Main.empCounter).getEmail());
			RemovePage.phoneNoT.setText(Main.employees.get(Main.empCounter).getPhoneNumber());
			RemovePage.streetT.setText(Main.employees.get(Main.empCounter).getAddress().getStreet());
			RemovePage.cityT.setText(Main.employees.get(Main.empCounter).getAddress().getCity());
			RemovePage.countryT.setText(Main.employees.get(Main.empCounter).getAddress().getCountry());
			if (Main.employees.get(Main.empCounter).getClass().getSimpleName().equals("HourlyEmployee"))
				RemovePage.typeCb.setValue("Hourly Employee");
			else if (Main.employees.get(Main.empCounter).getClass().getSimpleName().equals("SalariedEmployee"))
				RemovePage.typeCb.setValue("Salaried Employee");
			else if (Main.employees.get(Main.empCounter).getClass().getSimpleName().equals("CommessionEmployee"))
				RemovePage.typeCb.setValue("Commession Employee");
			else if (Main.employees.get(Main.empCounter).getClass().getSimpleName().equals("EmployeeBasedComession"))
				RemovePage.typeCb.setValue("Employee based Comession");
			RemovePage.fieldsDependsOnType();
			if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("PhD."))
				RemovePage.phdRb.setSelected(true);
			else if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("Mastre"))
				RemovePage.mastre.setSelected(true);
			else if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("B. A"))
				RemovePage.ba.setSelected(true);
			else if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("Scondary School"))
				RemovePage.secSchoolRb.setSelected(true);
			else if(Main.employees.get(Main.empCounter).getEducation().equalsIgnoreCase("Primary School"))
				RemovePage.primSchoolRb.setSelected(true);
			


		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error: No Employees");
			alert.setHeaderText("There is no added employees");
			alert.setContentText(null);
			alert.showAndWait();
		}
	}

}
