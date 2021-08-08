package com.mypackage1.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	//// REFERENCE VALUES FROM PROPERTIES FILE / FIELD INJECTION ////
	// We use @Value Annotation to inject the actual value from the properties file.
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	// Here, foo.email and foo.team is the actual Property Name from the actual config/properties file.
	// And this will Inject the value of that into our private String field email and team.
	
	
	// Constructor to inject the dependency
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	
	// Getters for our fields 'email' and 'team'

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
		

}
