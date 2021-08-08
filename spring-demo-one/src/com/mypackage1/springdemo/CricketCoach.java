package com.mypackage1.springdemo;

public class CricketCoach implements Coach {

	// For SETTER DEPENDENCY INJECTION
	private FortuneService fortuneService;
	
	// Creating a no-argument constructor because Spring will call this when it will make a 
	// reference to our bean.
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-argument constructor.");
	}
	
	// Creating SETTER METHOD for Injections. This will get called by Spring when we inject the dependency.
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	
	// For INJECTING LITERAL VALUES (like String, etc.).
	// Adding new fields for emailAddress and team.
	private String emailAddress;
	private String team;
	
	// Creating SETTER METHODS for INJECTING LITERAL VALUES
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}
	
	
	// Also getter methods because we will need it for printing.
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String getTeam() {
		return team;
	}
	
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
