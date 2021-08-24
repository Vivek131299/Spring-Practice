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
	
	
	///// COMBINING POINTCUT EXPRESSIONS /////
	// We need it due to some problems/needs like:
	// Problem: How to apply multiple pointcut expressions to a single advice?
	//          Execute an advice only if certain conditions are met.
	//          For e.g.- All methods in a package Except getter/setter methods.
	//
	// So to SOLVE above problem we can COMBINE POINTCUT EXPRESSIONS.
	// 
	// While combining, we can make use of Logic Operators like AND, OR, NOT to
	// include or exclude certain methods from the pointcut expression.
	// It works LIKE an IF STATEMENT. So execution happens only if it evaluates to TRUE.
	// So we can apply it like:
	// @Before("expressionOne() && expressionTwo()")
	// @Before("expressionOne() || expressionTwo()")
	// @Before("expressionOne() && !expressionTwo()")
	//
	// So, we can combine pointcut expressions like this and ASSIGN IT TO NEW METHOD.
	// AND then, we can use that NEW METHOD for applying to any Advice.
	
	// Till now, we are applying our pointcut expression on all the methods INCLUDING
	// Getters/Setters of AccountDAO class.
	// So, we can COMBINE pointcut expressions to EXCLUDE those Getter/Setter methods 
	// and then apply it to our Advices.
	
	
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
	
	
	// Applying Pointcut declaration for No getter/setter to our Advice.
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before Advice on method");
	}
	
	
	// Reusing Pointcut declaration for No getter/setter to our Advice.
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		
		System.out.println("\n=====>>> Performing API analytics");
	}
	

}
