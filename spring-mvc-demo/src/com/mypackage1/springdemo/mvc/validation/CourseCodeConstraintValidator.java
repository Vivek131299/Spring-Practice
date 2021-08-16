package com.mypackage1.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
// ConstraintValidator<> is actually an interface from javax validation package.

	// coursePrefix to validate against.
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		// Assigning the passed value as parameter in Annotation to our coursePrefix to validate.
		coursePrefix = theCourseCode.value(); // .value() will give us actual value that is passed while using annotation.
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
	// In this method we will put OUR ACTUAL BUSINESS LOGIC to return true or false if the given String validates.
	// String theCode is the actual data/text that the user has entered on the HTML form.
	// And theConstraintValidatorContext is an actual parameter that we can use to give additional error messages if we need it.
		
		boolean result;
		
		// check for null to avoid NullPointerException if user lefts the field blank in form.
		if (theCode != null) {
			// Below is VALIDATION LOGIC to test if the form data starts with our course prefix. (which is "LUV" in this case).
			result = theCode.startsWith(coursePrefix);
		} else {
			// if user has left the field blank then we just pass true because there is nothing to validate and let user go on and also because this is not required.
			result = true;
		}
		
		return result;
	}
	
}
