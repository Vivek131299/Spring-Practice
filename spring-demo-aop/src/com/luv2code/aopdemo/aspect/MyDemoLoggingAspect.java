package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // To tell Spring that this is an Aspect.
@Component // So that Spring will discover this Aspect while Component Scanning.
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging.
	
	///// @Before ADVICE /////
	
	@Before("execution(public void addAccount())")
	// "execution(public void addAccount())" is an Pointcut Expression AND it will
	// call this method(beforeAddAccountAdvice()) for any execution of a method that
	// has a signature 'public void addAccount()'.
	// So this is @before Advice along with a Pointcut Expression.
	public void beforeAddAccountAdvice() { // We can give any method name.
		
		// Here we can add our own custom code.
		// This custom code will be executed BEFORE that 
		// given method (public void addAccount()) runs.
		
		System.out.println("\n=====>>> Executing @Before Advice on method addAccount()");
	}
}
