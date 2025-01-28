package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class HourlyEmployee extends Employee {
	private short hours;
	private float rate;
	final String type = "Hourly Employee";
	protected SimpleDoubleProperty payment = new SimpleDoubleProperty();

	public HourlyEmployee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber,
			String email, String nationality, String designation, String education, Image employeePhoto, short hours,
			float rate) throws InvalidInputException {
		super(firstName, lastName, dateOfBirth, address, phoneNumber, email, nationality, designation, education,
				employeePhoto);
		setHours(hours);
		setRate(rate);
		payment.set(payment());
		Employee.empCounter++;
		EmpNo = new SimpleStringProperty(String.valueOf(empCounter));

	}

	public short getHours() {
		return hours;
	}

	public void setHours(short hours) throws InvalidInputException {
		if (hours > 288 || hours < 1)
			throw new InvalidInputException("Error: hours must be between 1-288!");
		this.hours = hours;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) throws InvalidInputException {
		if (rate > 6 || rate < 2.5)
			throw new InvalidInputException("Error: the rate must be between 2.5-6!");
		this.rate = rate;
	}

	public String getType() {
		return type;
	}

	@Override
	public double payment() {
		double payment = 0;
		if (this.hours > 140)
			payment = (rate * 1.7 * this.hours);
		else
			payment = (rate * this.hours);
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
		return super.toString() + "hours= " + hours + ", rate= " + rate + "]";
	}

}
