package com.mypackage1.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		// As we can see in the output, before the above print statement, our init method (doMyStartupStuff())
		// gets executed and then our print statement get executed by calling getDailyWorkout() and after
		// that after closing the container our destroy method (doMyCleanupStuff()) gets executed
	    // as mentioned in our configuration file (beanLifeCycle-applicationContext.xml).
		// Those init and destroy methods (doMyStartupStuff and doMyCleanupStuff) are defined in TrackCoach.java.
		
		
		// Close the context.
		context.close();
	}

}
