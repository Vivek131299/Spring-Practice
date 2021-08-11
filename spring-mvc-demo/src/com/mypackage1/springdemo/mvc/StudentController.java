package com.mypackage1.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a new Student object
		Student theStudent = new Student();
		
		// add Student object to the model
		theModel.addAttribute("student", theStudent); // 'student' is the name of attribute and 'theStudent' is the value.
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		// Above, it will bind that @ModelAttribute("student") to the parameter (Student theStudent) 
		// being passed in.
		// And after binding, that form (student-form.jsp) data is going to populate this student
		// object and then we can access it. 
		// So on the form, we have modelAttribute of "student" and here we use the same name "student".
		
		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
}
