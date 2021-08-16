package com.mypackage1.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mypackage1.springdemo.mvc.validation.CourseCode;

public class Customer {

	private String firstName;
	
	// Adding the validation rules to lastName.
	@NotNull(message="is required") // this is error message which will be displayed if the value is null.
	@Size(min=1, message="is required") // minimum 1 character is required in the field.
	private String lastName;

	// Adding validation rules(Min and Max values) to freePasses.
	@NotNull(message="is required") // Making this field required. But if we do it like this, it will show an error because, @NotNull trims all white spaces which is not possible on int.
	// So we change the field type from primitive int to 'Integer' type. Also now need to change return type to Integer of getter and setter methods for this field.
	@Min(value=0, message="must be greater than or equal to zero") // If the entered value is less than zero, then it will show error message.
	@Max(value=10, message="must be less than or equal to 10") // If the entered value is greater than 10, then it will show error message.
	private Integer freePasses;
	// But now, if we put any characters in freePasses field, we get unexpected error.
	// So to handle that we create our CUSTOM ERROR MESSAGE when the type is mismatched(e.g.- char instead of int).
	// We do this by creating new file messages.properties in resources folder in src directory.
	// Basically we override the error codes for custom message.(See comments in CustomerController class from line 38).
	
	// Adding validation rules(Regular expression) to postalCode. Rule- value must be only 5 chars/digits.
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits") // So basically it will accept chars from a to z, A to Z and digits from 0 to 9 but only 5 of them.
	private String postalCode;
	
	// Add our custom validation
	/*@CourseCode*/ // We are not passing any values and message here because we have already set defaults in 
	// our CourseCode Annotation (See CourseCode class/annotation_interface in .validation package).
	// We can also give custom value and message if we want. like:
	@CourseCode(value="TOPS", message="must start with TOPS") // Now, field should start with 'TOPS'.
	private String courseCode;
	
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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	// This is added in Dell for git checking.
}
