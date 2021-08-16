package com.mypackage1.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer()); // 'customer' is the attribute name and 'new Customer' is the value.
		return "customer-form";
	}
	
	// PERFORM VALIDATION IN CONTROLLER CLASS
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		// Above, @Valid will tell Spring to validate the Customer object.
		// BindingResult will store the results of validation in its 'theBindingResult' object.
		// NOTE: BindingResult must be specified JUST AFTER @ModelAttribute.
		
		// To check if there are any white spaces in last name. Because if we give just white space (spacebar)
		// in last name, then also our validation passes. Because white space is also counted as a 
		// character so it passes the validation. 
		// This should NOT happen. We solve this issue by using @InitBinder Annotation.
		System.out.println("Last name: |" + theCustomer.getLastName() + "|");
		
		//checking if BindingResult has errors:
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}
	
	/// @InitBinder ANNOTATION ///
	// To solve the above problem (of white space validation) we have to trim all the white spaces before validating it.
	// For this, we will use @InitBinder Annotation which works as a pre-processor.
	// For every web request that comes THROUGH OUR CONTROLLER this code WILL EXECUTE FIRST.
	// So we will Annotate method with @InitBinder.
	// So we will use it to trim Strings. Remove leading and trailing white spaces.
	// If the String has only white spaces then it will trim it to null.
	// So we will solve our validation problem.
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		// Above, StringTrimmerEditor remover leading and trailing white spaces.
		// And, true in parameter means it will trim to null if there are only white spaces.(like in our problem above).
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	// While adding Min and Max validation for freePasses attribute in Customer class,
	// we don't have to add anything here, because @Valid above already handles validation.
	// Also later for validating regular expression for postalCode, we don't need to add anything.
}
