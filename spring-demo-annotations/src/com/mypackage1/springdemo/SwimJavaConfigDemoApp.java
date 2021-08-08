package com.mypackage1.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// In this example, we are manually defining the Beans using @Bean Annotation. (See SportConfig.java file).

		// read Spring configuration Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from Spring container
		/*Coach theCoach = context.getBean("swimCoach", Coach.class);*/ // 'swimCoach' is the BEAN ID.
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		// (We are doing this later) We are changing the above line from class 'Coach' to class 'SwimCoach'
		// because we want to make use of the special methods (getEmail() and getTeam()) that we added to 
		// SwimCoach class later for FIELD INJECTION. 
		// So, commenting line 15 and adding line 16.
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call our new SwimCoach methods (Properties/Field values Injection)
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
