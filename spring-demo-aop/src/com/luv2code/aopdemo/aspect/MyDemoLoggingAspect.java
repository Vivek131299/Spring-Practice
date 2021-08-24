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
	// NOTE: Modifier is optional. So we can also write it as: "execution(void addAccount())"
	//       instead of "execution(public void addAccount())".
	//       ALSO, we can give * instead of specifying modifier to apply on any modifier.
	//       ///// * MEANS ANY /////
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
	/*@Before("execution(public void add*())")*/
	//
	// MATCH METHOD WITH BASED ON RETURN TYPE - 
	// If we give "execution(void add*())", it will only apply to methods which has
	// return type as void an which name starts with 'add'.
	// So, to match ANY RETURN TYPE, we can give * instead of specifying return type in 
	// our Pointcut Expression so that it will call our both void addAccount() from AccountDAO
	// AND boolean addSillyMember() from MembershipDAO like :
	/*@Before("execution(* add*())")*/
	//
	// MATCH METHOD PARAMETER TYPES /  PARAMETER PATTERN WILDCARDS
	// ()   - matches a method with no arguments.
	// (*)  - matches a method with one argument of any type.
	// (..) - matches a method with 0 or more arguments of any type.
	// We can specify any parameter type by giving fully qualified class name of that parameter class.
	// LIKE : "execution(* addAccount(com.luv2code.aopdemo.Account))".
	// NOTE : We must use FULLY QUALIFIED CLASS NAME for defining parameter type.
	//        So for above, we CAN'T give just 'Account'.
	// So it will apply to a method with any return type which has name 'addAccount' AND
	// has parameter of type 'com.luv2code.aopdemo.Account'. 
	// So it will only apply if we pass Account object from that given package in fully qualified class name.
	//
	// MATCH ON ANY METHOD IN ANY CLASS IN PACKAGE WITH ANY ARGUMENTS - 
	// LIKE : @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))").
	// So this will apply to a method of any return type (first *) in our specified 
	// package (com.luv2code.aopdemo.dao), to any class in that package (second *) and 
	// to any method in that class (third *) which can have 0 or more arguments of any type ((..)).
	/*@Before("execution(* add*(com.luv2code.aopdemo.Account))")*/
	//
	// Now we have changed our addAccount() method to take 2 parameters (of Account and boolean type)
	// instead of just one (of Account type) before.
	// So, above @Before statement will not work.
	// So we can update it to accept any number of arguments AFTER matching an Account object :
	/*@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")*/
	//
	// BUT we can also remove that first Account parameter type restriction from our above statement and 
	// update it to accept any number of parameters of any type.
	// So now it will apply to both addAccount(Account, boolean) and addSillyMember() methods.
	/*@Before("execution(* add*(..))")*/
	//
	// MATCH METHODS IN A PACKAGE - 
	// So this will apply to a method of any return type (first *) in our specified 
	// package (com.luv2code.aopdemo.dao), to any class in that package (second *) and 
	// to any method in that class (third *) which can have 0 or more arguments of any type ((..)).
	// We ADD one more method(public boolean doWork()) in our AccountDAO class
	// AND one method(public void goToSleep()) in our MembershipDAO class to test below.
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() { // We can give any method name.
		
		// Here we can add our own custom code.
		// This custom code will be executed BEFORE that 
		// given method (public void addAccount()) runs.
		
		System.out.println("\n=====>>> Executing @Before Advice on method");
	}
}
