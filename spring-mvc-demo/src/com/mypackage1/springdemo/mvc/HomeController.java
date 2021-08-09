package com.mypackage1.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// This is our Controller class

@Controller // @Controller Annotation extends @Component. So they are also scanned while Component Scanning.
public class HomeController {

	// Defining a CONTROLLER METHOD
	// Add Request Mapping to Controller Method by using @RequestMapping("path") Annotation.
	@RequestMapping("/") // "/" will handle all type of http requests(paths).
	public String showPage() { // We can give any method name.
		// Returning view name (name of the page that we want to return).
		return "main-menu"; 
		// Above, we will not write full name of file because, in DemoAppConfig.java file (in com.mypackage1.springdemo.config)
		// we have already set the prefix (in this case: "/WEB-INF/view/") and suffix (in this case: ".jsp") using viewResolver.
		// So spring will automatically look into /WEB-INF/view/ directory with the file name specified with .jsp suffix.
		// So now we have to create jsp (like HTML file) file named main-menu.jsp in /WEB-INF/view/ path.
	}
}
