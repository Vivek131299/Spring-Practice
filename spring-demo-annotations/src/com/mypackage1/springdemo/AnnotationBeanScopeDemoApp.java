package com.mypackage1.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		// load Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from Spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they (theCoach and alphaCoach) are the same objects
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach: " + theCoach);
		
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");
		
		// close the context
		context.close();
		
		
		//  @Scope ANNOTATION
		// First, as we have not given any scope to our tennisCoach bean, so it will be default (i.e. singleton) and 
		// point to the same object/memory. So the result will be true and also there memory locations
		// will be same.
		
		// We can use @Scope Annotation for defining the scope of the bean while defining it like:
		// @Scope("singleton") or @Scope("prototype").
		
		// Now we will change the Scope of our tennisCoach bean. (See TennisCoach class on line 28).
		// And after changing the scope to 'prototype' using @Scope annotation, we can see that after 
		// running this file we get result as false and also there memory locations are different.
		// Also, we see that our TennisCoach's Default Constructor is called TWO times now unlike previous 
		// one time. That's because 'prototype' scope creates new object for both instances. (i.e. for 
		// theCoach and alphaCoach).
	}

}
