package com.mypackage1.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// This Controller will be used for Reading HTML Form Data.

@Controller

//// CONTROLLER LEVEL/PARENT REQUEST MAPPING ///
// Below, Adding parent mapping for controller / Controller Level Request Mapping.
@RequestMapping("/hello") // So now, this is high level mapping or main directory, and then we will have 
						  // sub-mappings of it. So all other method Request Mappings below (/showForm 
						  // and /processForm), these are all relative to 'hello'.
						  // So, full path for showForm will be /hello/showForm and for processForm it will be /hello/processForm.
						  // So, this will remove that Ambiguity problem (See SillyController from line 9).
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
	
	// BINDING REQUEST PARAMS / @RequestParam ANNOTATION
	// Reading HTML Form Data with @RequestParam Annotation
	// Above, we are reading the HTML form data(parameter) 'studentName' by using HttpServletRequest 
	// and then assigning it to String variable 'theName'.
	// BUT, we can also do that by using the @RequestParam("studentName") Annotation and we can directly 
	// assign that to the variable theName in the method parameter while defining method itself like:
	// public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {...}.
	// And then we can use theName variable as we want.
	// So rewriting above method:
	// (we are changing RequestMapping name and method name to avoid errors):
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		// convert the data to all Uppercase
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey My Friend from v3! " + theName;
		
		// add message/data to the model
		model.addAttribute("message", result); 
		// Above, 'message' is the name given to attribute and 'result' id the value.
		
		
		return "helloworld";
	}
}
