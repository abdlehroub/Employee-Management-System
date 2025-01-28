package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class CommessionEmployee extends Employee {
	private double soldItemsPerMounth;
	protected SimpleDoubleProperty payment = new SimpleDoubleProperty();
	final String type = "Commession Employee";

	public CommessionEmployee(String firstName, String lastName, String dateOfBirth, Address address,
			String phoneNumber, String email, String nationality, String designation, String education,
			Image employeePhoto, double soldItemsPerMounth) throws InvalidInputException {
		super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education,
				employeePhoto);
		setSoldItemsPerMounth(soldItemsPerMounth);
		payment.set(payment());
		Employee.empCounter++;
		EmpNo = new SimpleStringProperty(String.valueOf(empCounter));
	}

	public CommessionEmployee() {
		super();
	}

	public double getSoldItemsPerMounth() {
		return soldItemsPerMounth;
	}

	public void setSoldItemsPerMounth(double soldItemsPerMounth) throws InvalidInputException {
		if (soldItemsPerMounth > 0)
			this.soldItemsPerMounth = soldItemsPerMounth;
		else
			throw new InvalidInputException("Error: Sold items per mounth cannot be negative!");
	}

	public String getType() {
		return type;
	}

	@Override
	public double payment() {
		//Calculate the payment for the commission employee
		double payment = 0;
		if (soldItemsPerMounth > 2800 && soldItemsPerMounth < 3775)
			payment = (soldItemsPerMounth * 0.03);
		else if (soldItemsPerMounth > 3775)
			payment = (soldItemsPerMounth * 0.05);
		else
			payment = (soldItemsPerMounth * 0.015);

		return payment;
	}

	public double getPayment() {
		return payment.get();
	}

	public void setPayment(SimpleDoubleProperty payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return super.toString() + " CommessionEmployee [soldItemsPerMounth=" + soldItemsPerMounth + "]";
	}

}
