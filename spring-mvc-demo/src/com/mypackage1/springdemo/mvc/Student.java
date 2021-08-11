package com.mypackage1.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	
	// For Reading Countries from Java Class instead of hard coding them in jsp file.
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		// populate country options: used ISO country code
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil"); // So, "BR" is the country code/key and "Brazil is the actual label/value.
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "United States of America");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	// So, when form is loaded, Spring will call student.getCountryOptions() method.	
	
}
