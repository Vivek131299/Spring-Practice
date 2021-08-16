package com.mypackage1.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// This is our custom annotation named CourseCode.
// @interface is special notation for defining Annotation.
// We also need some Annotations to define our custom Annotation.

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// Above, CourseCodeConstraintValidator will be our actual VALIDATOR CLASS. This is a HELPER CLASS 
// that will contain business rules / validation logic. See CourseCodeConstraintValidator class.
@Target( { ElementType.METHOD, ElementType.FIELD } )
// @Target means basically we are telling that where we can apply this Annotation. So here we can 
// apply our annotation to a method or field.
@Retention(RetentionPolicy.RUNTIME)
// @Retention specifies that how long this annotation be stored or used. So here we are saying that 
// retain this annotation in the Java class and Process it at Runtime.
public @interface CourseCode {
	
	// define the default course code. 
	// Basically define the attributes that we can PASS INTO our Annotation as a parameter.
	// Our Annotation will have two attributes, 
	// One for value.(to check that the entered String starts with 'value') and
	// Second for message (error message).
	
	// define default course code
	public String value() default "LUV";
	// if user doesn't pass any value in parameter while using annotation then the default value will be "LUV"
	
	// define default error message
	public String message() default "must start with LUV";
	// if user doesn't pass any message in parameter while using annotation then the default message will be "must start with LUV"

	// define default groups
	// GROUPS: can group related constraints
	public Class<?>[] groups() default {};
	
	// define default payloads
	// PAYLOADS: provide custom details about validation failure (severity level, error code, etc.).
	public Class<? extends Payload>[] payload() default {};
}
