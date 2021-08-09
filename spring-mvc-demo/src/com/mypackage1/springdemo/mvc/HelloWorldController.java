package com.mypackage1.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// This Controller will be used for Reading HTML Form Data.

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML form.
	@RequestMapping("/showForm") // So if we go to /showForm, then our helloworld-form.jsp view page will be displayed.
	public String showForm() {
		return "helloworld-form"; // We need to create view page of this name which will have HTML Form.
	}
	
	// And once we have form displayed, we are going to need a controller method to process this form.
	@RequestMapping("/processForm") // When user clicks submit button after displaying form in helloworld-form, 
									// we are setting action as processForm in helloworld-form jsp file, So 
									// it will send request to /processForm and then this request is handled here 
									// and then helloworld.jsp view page will be displayed which is just a 
									// confirmation page stating that form has been submitted successfully.
	public String processForm() {
		return "helloworld";
	}
}
