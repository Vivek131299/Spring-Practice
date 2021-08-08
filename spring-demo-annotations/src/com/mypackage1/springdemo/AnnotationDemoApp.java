package com.mypackage1.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from Spring container
		
		/* Coach theCoach = context.getBean("thatSillyCoach", Coach.class); */
		
		// Above, 'thatSillyCoach' is the same bean ID that we gave in @Component Annotation in TennisCoach.java (on line 7) file. 
		
		// But later, as we have changed the bean ID to DEFAULT BEAN ID in TennisCoach.java (on line 19) file,
		// so now we have to use the same Default Bean ID (i.e. 'tennisCoach') for retrieving it 
		// instead of above (i.e. 'thatSilllyCoach').
		TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Printing values from properties file (See comments in TennisCoach class from line 128).
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
