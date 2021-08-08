package com.mypackage1.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read Spring configuration Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		// Above we are using AnnotationConfigApplicationContext instead of ClassPathXmlApplicationContext before 
		// because we are not using any configuration xml file here. 
		// Instead, we are Configuring Spring with Java Code by using Annotations 
		// (See comments in SportConfig class from line 6).
		// So we do not need xml file anymore.
		// Everything else below remains the same.
		
		// get the bean from Spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
