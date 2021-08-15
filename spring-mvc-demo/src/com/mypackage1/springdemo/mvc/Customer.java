package com.mypackage1.springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	// Adding the validation rules to lastName.
	@NotNull(message="is required") // this is error message which will be displayed if the value is null.
	@Size(min=1, message="is required") // minimum 1 character is required in the field.
	private String lastName;

	
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
	
	
}
