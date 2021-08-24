package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// In this, we will access the METHOD SIGNATURE AND METHOD ARGUMENTS in our Aspect.
	// We do this by using JoinPoint Object from AspectJ package.
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>>> Executing @Before Advice on method");
		
		// DISPLAY THE METHOD SIGNATURE
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		
		// DISPLAY THE METHOD ARGUMENTS
		
		// get arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through arguments
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			// We can do some other checks here,
			// like, if it's an instance of Account means if it's an Account object, 
			// then we will Downcast it and get some actual data from that Account 
			// because by default it will simply print out the Account object's hash code
			// of the default toString() and we are not providing special toString() here
			// so we need to just pull it out individually.
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
		
	}	

}
