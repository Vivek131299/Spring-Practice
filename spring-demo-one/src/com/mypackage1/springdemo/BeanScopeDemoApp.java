package com.mypackage1.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if they are the same beans (as myCoach bean is in default scope i.e. Singleton, result will be true).
		boolean result = (theCoach == alphaCoach);
		
		// print out the result.
		System.out.println("\nPointing to the same object: " + result);
		
		// Also, printing the memory locations for both beans. (As our bean scope is Singleton, both memory locations will be same).
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");
		
		// Later on, we change our Bean's scope to 'prototype' in our configuration file and then we can see that 
		// the above two beans objects created are not equal (result = false) and their locations are also different.

		// Close the context.
		context.close();
	}

}
