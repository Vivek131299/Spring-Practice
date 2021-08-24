package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	
	///// @AfterThrowing ANNOTATION /////
	// @AfterThrowing is similar to @AfterReturning Annotation BUT THIS AfterThrowing 
	// ONLY EXECUTES IF the METHOD THROWS AN EXCEPTION.
	// So if the method throws an exception, this Advice will get executed.
	//
	// Like previous, we can also take a look at Exception thrown and print it.
	// We can get the thrown exception by method by using 'throwing' parameter like:
	// @AfterThrowing(pointcut="pointcut_expression", throwing="variable")
	// Here, 'variable' is the parameter that it will inject here when the exception is thrown and it 
	// will store the exception.
	// And we can ACCESS this parameter in the Advice by using 'Throwable variable' in the parameter.
	// NOTE : variable name must be same in the Annotation and in parameter of Advice.
	//
	// BUT STILL it Propagates the Exception to the calling method.
	// So it does not Solves/Removes the Exception, we can just see the exception thrown
	// by the method.
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", 
				   throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n=====>>> The exception is:  " + theExc);
	}
	
	
	
	// add a new advice for @AfterReturning on the findAccounts() method
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning="result") // So, the value returned by findAccounts() method will be stored in 'result'.
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
	// Above, 'result' variable name is same as that of what we have given in 'returning' in @AfterReturning Annotation.
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n=====>>> result is: " + result);
		
		
		// MODIFYING THE RETURNED DATA //
		// We can INTERCEPT / POST-PROCESS the returned data/value from the method and then CHANGE IT
		// before passing it to the calling method(original method in main app).
		// So, if the method returns the list of 4 accounts then we can add or remove 
		// some items from it. AND then the result displayed will be different from what 
		// we expected because we have INTERCEPTED into returned data from the method and 
		// CHANGED IT.
		
		// let's post-process / modify the data
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		// print out the results after modification
		System.out.println("\n=====>>> result is: " + result);
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts
		for (Account tempAccount : result) {
			
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
		}
	}


	
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
			
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
		
	}	

}
