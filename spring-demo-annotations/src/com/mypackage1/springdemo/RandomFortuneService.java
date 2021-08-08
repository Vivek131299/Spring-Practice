package com.mypackage1.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of Strings
	private String[] data = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random String from the array
		int index = myRandom.nextInt(data.length); // gives random number depending on length of 'data' array(i.e. 0,1,2 (3 not included)).
		String theFortune = data[index];
		
		return theFortune;
	}

}
