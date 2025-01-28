package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class EmployeeBasedComession extends CommessionEmployee {
	private double basedOnSalary;
	protected SimpleDoubleProperty payment = new SimpleDoubleProperty();

	public EmployeeBasedComession(String firstName, String lastName, String dateOfBirth, Address address,
			String phoneNumber, String email, String nationality, String designation, String education,
			Image employeePhoto, double soldItemsPerMounth, double basedOnSalary) throws InvalidInputException {
		super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education,
				employeePhoto, soldItemsPerMounth);
		this.basedOnSalary = basedOnSalary;
		payment.set(payment());
		Employee.empCounter++;
		EmpNo = new SimpleStringProperty(String.valueOf(empCounter));

	}

	public EmployeeBasedComession() {
		// TODO Auto-generated constructor stub
	}

	public double getBasedOnSalary() {
		return basedOnSalary;
	}

	public void setBasedOnSalary(double basedOnSalary) throws InvalidInputException {
		if (basedOnSalary > 0)
			this.basedOnSalary = basedOnSalary;
		else
			throw new InvalidInputException("Error: Salary cannot be negative!");
	}

	public double getPayment() {
		return payment.get();
	}

	public void setPayment(SimpleDoubleProperty payment) {
		this.payment = payment;
	}

	@Override
	public double payment() {
		double payment = 0;
		payment = (basedOnSalary + super.getSoldItemsPerMounth());
		return payment;
	}

	@Override
	public String toString() {
		return super.toString() + "EmployeeBasedComession [basedOnSalary=" + basedOnSalary + "]";
	}

}
