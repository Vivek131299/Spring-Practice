package com.mypackage1.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	// MODEL
	// We can add our form data to model.
	// new controller method to read form data and add data to the model.
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		// Above, 'studentName' is the actual name of the HTML Form Field of 
		// the <input> tag in form in our helloworld-form.jsp file.
		
		// convert the data to all Uppercase
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;
		
		// add message/data to the model
		model.addAttribute("message", result); 
		// Above, 'message' is the name given to attribute and 'result' id the value.
		
		
		return "helloworld";
	}
}
