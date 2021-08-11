package com.mypackage1.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	// If we give this "/showForm" request here then it will give us an error (Ambiguous Mapping error)
	// because we have same request mapping in our HelloWorldController also.
	// To solve this, we implement Controller Level Request Mapping in 
	// our HelloWorldController (See HelloWorldController from line 14).
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "silly";
	}
}
