package com.mypackage1.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	// Adding the validation rules to lastName.
	@NotNull(message="is required") // this is error message which will be displayed if the value is null.
	@Size(min=1, message="is required") // minimum 1 character is required in the field.
	private String lastName;

	// Adding validation rules(Min and Max values) to freePasses.
	@Min(value=0, message="must be greater than or equal to zero") // If the entered value is less than zero, then it will show error message.
	@Max(value=10, message="must be less than or equal to 10") // If the entered value is greater than 10, then it will show error message.
	private int freePasses;
	
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

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	
}
