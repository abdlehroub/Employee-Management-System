package application;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public abstract class Employee {
	protected static int empCounter = 0;
	protected SimpleStringProperty EmpNo;
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty dateOfBirth;
	private Address address;
	private SimpleStringProperty phoneNumber;
	private SimpleStringProperty email;
	private SimpleStringProperty nationality;
	private SimpleStringProperty designation;
	private SimpleStringProperty education;
	private Image employeePhoto;

	public Employee(String firstName, String lastName, String dateOfBirth, Address address, String phoneNumber,
			String email, String nationality, String designation, String education, Image employeePhoto)
			throws InvalidInputException {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setDateOfBirth(dateOfBirth);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		setNationality(nationality);
		setDesignation(designation);
		setEducation(education);
		setEmployeePhoto(employeePhoto);
		

	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setEmpNo(String empNo) {
		EmpNo.set(empNo);
	}

	public String getEmpNo() {
		return EmpNo.get();
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) throws InvalidInputException {
		if (firstName != null && firstName.matches("[a-zA-Z]+")) {
			this.firstName = new SimpleStringProperty(firstName);
		} else {
			throw new InvalidInputException("Error: Name should contain only characters!");
		}
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) throws InvalidInputException {
		if (lastName != null && lastName.matches("[a-zA-Z]+")) {
			this.lastName = new SimpleStringProperty(lastName);
		} else {
			throw new InvalidInputException("Error: Name should contain only characters!");
		}

	}

	public String getDateOfBirth() {
		return dateOfBirth.get();
	}

	public void setDateOfBirth(String dateOfBirth) throws InvalidInputException {
		String[] date = dateOfBirth.split("-");
		int year = Integer.parseInt(date[0]);
		int mounth = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		Calendar current = new GregorianCalendar();
		Calendar sixteen = new GregorianCalendar(current.get(current.YEAR) - 16, current.get(current.MONTH) + 1,
				current.get(current.DAY_OF_MONTH));
		Calendar chosenDate = new GregorianCalendar(year, mounth, day);
		if (chosenDate.compareTo(sixteen) <= 0)
			this.dateOfBirth = new SimpleStringProperty(dateOfBirth);
		else
			throw new InvalidInputException("Error: Age must be 16 or more!");

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) throws InvalidInputException {
		if (address != null)
			this.address = address;
		else {
			throw new InvalidInputException("Error: Address should'nt be empty!");
		}

	}

	public String getPhoneNumber() {
		return phoneNumber.get();
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidInputException {
		if ((phoneNumber.startsWith("059") || phoneNumber.startsWith("056")) && phoneNumber.length() == 10
				&& phoneNumber != null)
			this.phoneNumber = new SimpleStringProperty(phoneNumber);
		else
			throw new InvalidInputException("Error: Invalid Phone Number!!");
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) throws InvalidInputException {
		if (email.matches("^[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z]+\\.[a-zA-Z]{2,}") && address != null)
			this.email = new SimpleStringProperty(email);
		else
			throw new InvalidInputException("Error: Invalid Email!!");
	}

	public String getNationality() {
		return nationality.get();
	}

	public void setNationality(String nationality) throws InvalidInputException {
		if (nationality != null)
			this.nationality = new SimpleStringProperty(nationality);
		else
			throw new InvalidInputException("Error: Invalid Email!!");
	}

	public String getDesignation() {
		return designation.get();
	}

	public void setDesignation(String designation) throws InvalidInputException {
		if (designation != null)
			this.designation = new SimpleStringProperty(designation);
		else
			throw new InvalidInputException("Error: Invalid Email!!");
	}

	public String getEducation() {
		return education.get();
	}

	public void setEducation(String education) throws InvalidInputException {
		if (education != null)
			this.education = new SimpleStringProperty(education);
		else
			throw new InvalidInputException("Error: Invalid Email!!");
	}

	public Image getEmployeePhoto() {
		return employeePhoto;
	}

	public void setEmployeePhoto(Image employeePhoto) throws InvalidInputException {
		this.employeePhoto = employeePhoto;
	}

	public static int getEmpCounter() {
		return empCounter;
	}

	

	public static void setEmpCounter(int empCounter) {
		Employee.empCounter = empCounter;
	}

	public abstract double payment();

	@Override
	public String toString() {
		return "Employee [Employee No. =" + EmpNo.get() + ", First Name= " + firstName + ", Last Name= " + lastName
				+ ", Date Of Birth= " + dateOfBirth + ", Address= " + address + ", Phone Number= " + phoneNumber
				+ ", Email= " + email + ", Nationality= " + nationality + ", Designation= " + designation
				+ ", Education= " + education + ", EmployeePhoto= " + employeePhoto + "]";
	}

}
