package application;

public class Address {
	String country;
	String city;
	String street;

	public Address(String country, String city, String street) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) throws InvalidInputException {
		if (isStringValid(country))
			this.country = country;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) throws InvalidInputException {
		if (isStringValid(city))
			this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) throws InvalidInputException {
		if (isStringValid(country))
			this.street = street;
	}

	public boolean isStringValid(String string) throws InvalidInputException {
		//Validate if the string only contains characters
		if (string == "" || string.matches("[a-z][A-Z]+")) {
			return true;
		}
		throw new InvalidInputException("Special Charactares and empty String Are not Allowed!!");
	}

	@Override
	public String toString() {
		return "Address [ Country= " + country + ", City= " + city + ", street= " + street + "]";
	}

}
