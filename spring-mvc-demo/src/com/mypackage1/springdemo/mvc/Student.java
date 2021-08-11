package com.mypackage1.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	
	// For Reading Countries from Java Class instead of hard coding them in jsp file.
	private LinkedHashMap<String, String> countryOptions;
	
	private String favoriteLanguage;
	
	// For Reading items for Radio Buttons from Java Class instead of hard coding them in jsp file.
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	
	public Student() {
		// populate country options: used ISO country code
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil"); // So, "BR" is the country code/key and "Brazil is the actual label/value for displaying.
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "United States of America");
		
		// populate Radio Buttons items
		favoriteLanguageOptions = new LinkedHashMap<>();
		
		favoriteLanguageOptions.put("Java", "Java"); // parameter order: .put(value, display_label)
		favoriteLanguageOptions.put("C#", "C#");
		favoriteLanguageOptions.put("PHP", "PHP");
		favoriteLanguageOptions.put("Ruby", "Ruby");
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

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}
	
	
}
