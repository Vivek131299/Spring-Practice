package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
 
public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {

		// read Spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from Spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		
		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("\nCalling getFortune");
		
		// for simulating an exception
		boolean tripWire = true;
		
		
		String data = theFortuneService.getFortune(tripWire); // This will throw an exception as tripWire is true.
		// And we are handling this thrown exception in our @Around Advice (in MyDemoLoggingAspect).
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
		
		
		// close the context
		context.close();
	}

}
