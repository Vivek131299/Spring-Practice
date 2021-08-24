package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // To tell Spring that this is an Aspect.
@Component // So that Spring will discover this Aspect while Component Scanning.
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging.
	
	///// @Before ADVICE /////
	
	/*@Before("execution(public void addAccount())")*/
	// "execution(public void addAccount())" is an Pointcut Expression AND it will
	// call this method(beforeAddAccountAdvice()) for any execution of a method that
	// has a signature 'public void addAccount()'.
	// So this is @before Advice along with a Pointcut Expression.
	// This will execute before addAccount() method in ANY CLASS.
	// So this will also call addAccount() method from MembershipDAO class.
	//
	// MATCH ONLY AcountDAO addAccount() METHOD - 
	// We can give fully qualified name of a class and method to only apply our 
	// @Before advice method to it.
	// So here, we give fully qualified name of our AccountDAO class so that this Advice 
	// will now ONLY APPLY TO IT :
	/*@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")*/
	//
	// MATCH METHOD STARTING WITH "add" IN ANY CLASS - 
	// We can use wild card pattern, we can specify pattern of method name to which our Aspect
	// should be applied.
	// We can give 'add*', so that it will apply to any method that starts with 'add'.
	// So whole method name does not matter. It should only start with 'add'.
	// So now, this will apply to our both methods addAccount() from AccountDAO AND
	// addSillyMember() from MembershipDAO.
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() { // We can give any method name.
		
		// Here we can add our own custom code.
		// This custom code will be executed BEFORE that 
		// given method (public void addAccount()) runs.
		
		System.out.println("\n=====>>> Executing @Before Advice on method");
	}
}
