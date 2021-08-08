package com.mypackage1.springdemo;

public class BaseballCoach implements Coach {

	/////////////////////// DEPENDENCY INJECTION ///////////////////////
	// for injecting a dependency through constructor we have 2 steps:
	// 1) define a private field for the dependency.
	private FortuneService fortuneService;
	
	// 2) define a constructor for a dependency injection.
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use our fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
