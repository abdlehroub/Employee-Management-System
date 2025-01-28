package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class SalariedEmployee extends Employee {

	private double annualSalary;
	final String type = "Salaried Employee";
	protected SimpleDoubleProperty payment = new SimpleDoubleProperty();

	public SalariedEmployee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber,
			String email, String nationality, String designation, String education, Image employeePhoto,
			double annualSalary) throws InvalidInputException {
		super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education,
				employeePhoto);
		this.annualSalary = annualSalary;
		payment.set(payment());
		Employee.empCounter++;
		EmpNo = new SimpleStringProperty(String.valueOf(empCounter));

	}

	public SalariedEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) throws InvalidInputException {
		if (isAnnualSalaryValid(annualSalary))
			this.annualSalary = annualSalary;
		else
			throw new InvalidInputException("Error: Annual salary must be between 4075-25000.");
	}

	//Validate the annual salary
	public boolean isAnnualSalaryValid(double annualSalary) {
		return annualSalary < 25000 && annualSalary > 4075;
	}

	//Calculate the payment
	@Override
	public double payment() {
		return annualSalary / 12;
	}

	public double getPayment() {
		return payment.get();
	}

	public void setPayment(SimpleDoubleProperty payment) {
		this.payment = payment;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return super.toString() + " SalariedEmployee [annualSalary=" + annualSalary + "]";
	}

}
