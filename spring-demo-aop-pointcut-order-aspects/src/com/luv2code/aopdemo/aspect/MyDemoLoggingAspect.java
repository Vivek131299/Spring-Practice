package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // To tell Spring that this is an Aspect.
@Component // So that Spring will discover this Aspect while Component Scanning.
@Order(2) // (See below comments for explanation).
public class MyDemoLoggingAspect {

	/*
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {} 
	
	
	// Create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))") // Match getter methods (get*)
	private void getter() {}
	
	// Create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))") // Match setter methods (set*)
	private void setter() {}
	
	// Create Combined Pointcut: INCLUDE package and EXCLUDE getter/setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	// Above, will INCLUDE our all package methods BUT EXCLUDE getter and setter methods.
	*/
	
	
	
	
	///// ORDERING ASPECTS / @Order ANNOTATION /////
	// As we have 3 Advices defined below, they will execute in the UNDEFINED ORDER.
	// BUT if we want to give an specific order to these Advices to execute,
	// THEN we can do that by @Order ANNOTATION.
	// For this, we need to give @Order Annotation TO THE ASPECT.
	// So, to set an order for below Advices, we need to create new Aspects classes 
	// for each of the Advices and then add @Order Annotation to that newly created Aspects.
	//
	// So, commenting below last 2 Advices and placing them in 2 separate Aspects.
	//
	// ALSO, now we need above 4 Pointcut Expressions/Declarations in our newly created Aspects.
	// So instead of copying in every Aspect, we will create new Aspect/class (LuvAopExpressions)
	// and paste those declarations there (also changing their access modifier from private to public)
	// and then share it from there to each of our Aspect.
	// So commenting it in this class.
	//
	// While referencing Pointcut expressions from LuvAopExpressions in our other 
	// Aspects classes, we need to GIVE FULLY QUALIFIED PATH for declaration method 
	// like : @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	//
	//// NOW FINALLY, WE NEED TO GIVE ORDERS TO THESE ASPECTS BY @Order ANNOTATION ////
	// So we simply give @Order Annotation at starting of the class/aspect and specify
	// the order in it.
	// We can specify the order by giving a number in it like: @Order(1), @Order(2), etc..
	// LOWER THE ORDER/NUMBER, HIGHER THE PRIORITY.
	// So @Order(1) will execute first and then @Order(2).
	// There is no compulsion those need to be in sequence. So we can give @Order(20) to 
	// one Aspect and @Order(35) to another Aspect.
	// We can also give negative numbers.
	// If we gave same Order to two different Aspects then it is like UNDEFINED Aspects.
	
	
	
	// Applying Pointcut declaration for No getter/setter to our Advice.
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before Advice on method");
	}
	
	/*
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		
		System.out.println("\n=====>>> Performing API analytics");
	}
	*/
	
	/*
	@Before("forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		
		System.out.println("\n=====>>> Logging to cloud in async fashion");
	}*/
	

}
