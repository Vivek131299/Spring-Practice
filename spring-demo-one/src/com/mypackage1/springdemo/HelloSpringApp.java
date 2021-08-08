package com.mypackage1.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class); // Here, "myCoach" is the bean id in 
																  // the applicationContext.xml file and 
																  // Coach.class is the Interface for casting
																  // the object.
		
		///////////////////////// DEPENDENCY INJECTION /////////////////////////
		// There are mainly two types of Dependency Injection-
		// 1) Constructor Injection
		// 2) Setter Injection
		////////////////////////////////////////////////////////////////////////
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		// Also, let's call our new method for fortunes by dependency which we have injected by Constructor Injection.
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
		
		
		// So basically this class will read from our configuration file (i.e. applicationContext.xml) from 
		// the bean of id which we will provide. If we change the 'class' in the bean in our configuration 
		// file, then output will change depending upon the new class we will provide(see comments in applicationContext.xml file). 
		// So our project is now Configurable, means we only need to change our configuration file and not the 
		// source code in this class.
	}

}
