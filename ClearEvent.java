package application;


import javafx.event.ActionEvent;

public class ClearEvent implements javafx.event.EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		
		AddPage.firstNameT.setText(null);
		AddPage.lastNameT.setText(null);
		AddPage.birthDateTf.setText(null);
		AddPage.cityT.setText(null);
		AddPage.countryT.setText(null);
		AddPage.designationT.setText(null);
		AddPage.emailT.setText(null);
		AddPage.empNoT.setText(Employee.getEmpCounter() + 1 + "");
		AddPage.phoneNoT.setText(null);
		AddPage.streetT.setText(null);
		AddPage.typeCb.getSelectionModel().clearSelection();
		if(AddPage.image !=null)
			AddPage.image.setImage(Main.defultImage);
	}

}
