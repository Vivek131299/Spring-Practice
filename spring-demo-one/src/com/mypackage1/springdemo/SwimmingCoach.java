package com.mypackage1.springdemo;

public class SwimmingCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimmingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice holding breathe under water.";
	}

	@Override
	public String getDailyFortune() {
		return "Swim Swim!" + fortuneService.getFortune();
	}
}
