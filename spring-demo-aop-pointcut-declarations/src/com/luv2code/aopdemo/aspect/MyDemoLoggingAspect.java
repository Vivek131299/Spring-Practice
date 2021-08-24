package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // To tell Spring that this is an Aspect.
@Component // So that Spring will discover this Aspect while Component Scanning.
public class MyDemoLoggingAspect {

	///// POINTCUT DECLARATIONS / @Pointcut ANNOTATION /////
	
	// @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	// We know that we have used above for defining pointcut expression earlier.
	//
	// BUT, what if we want above Pointcut Expression to use for multiple Advices.
	// For that we use POINTCUT DECLARATIONS.
	// Basically, we declare our Pointcut Expression once by using @Pointcut ANNOTATION
	// with some method and give it a name like @Pointcut("execution(expression)").
	// AND whenever we want to use it on any Advice, we simply call that method 
	// like @Before("call to method").
	// So we can REUSE it on any advice.
	
	
	// Declaring Pointcut Expression
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {} 
	// So, We need to call this method if we want to use above expression.
	// We can give any method name.
	// It is basically storing expression in a method instead in a variable.
	
	
	// Applying Pointut Declaration for below Advice.
	@Before("forDaoPackage()") // Call to pointcut declaration method.
	public void beforeAddAccountAdvice() { // We can give any method name.
		
		System.out.println("\n=====>>> Executing @Before Advice on method");
	}
	
	
	// Applying / Reusing Pointut Declaration
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n=====>>> Performing API analytics");
	}
}
