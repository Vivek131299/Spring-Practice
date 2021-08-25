package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	///// @Around ADVICE /////
	// Around Advice - This runs before and after the method.
	// We can execute code before we make the method call and then we can also get the results after 
	// that method call is complete.
	// @Around Advice is like a combination of @Before and @After but it gives us more fine-grained
	// control over the process.
	//
	// Use cases - Most common: logging, auditing, security.
	//             Pre-processing and post-processing data.
	//             Instrumentation/profiling code like - How long does it take for a section of code to run.
	//             Managing Exceptions- Swallow / handle / stop exceptions.
	//
	// Proceeding JoinPoint - When using @Around Advice, we will get a reference to a 'proceeding join point'.
	// This is a handle to the target method. We can use this handle / proceeding join point to actually execute the 
	// target method.
	//
	// HANDLING EXCEPTIONS //
	// For an Exception thrown from proceeding JoinPoint, We can handle / swallow / stop the exception,
	// OR We can simply RETHROW the Exception.
	// After catching/handling the exception in Advice, we can just return the default result to the main program 
	// so that the Main Program will NEVER KNOW that Exception was thrown.
	// So we can assign a default value to result and return it OR we can just rethrow the exception
	// depending on our Program requirement.
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
	// We are also using Throwable just in case something goes wrong and we get exception.
	// In this method, we will handle the exception thrown by our target method.
		
		// print out which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, execute the method
		Object result = null;
		
		// handling the exception
		try {
			result = theProceedingJoinPoint.proceed();
			// Above, we are using .proceed() method to EXECUTE / INVOKE our target method.
			// So, now our getFortune() method will start executing.
		} catch (Exception e) {
			// log the exception
			System.out.println(e.getMessage());
		// So here, we are handling the exception and returning the default result to Main App, 
		// so our Main App will NEVER KNOW that the exception was thrown.
			
			// give user a custom message
			result = "Major accident! But no worries, your private AOP helicopter is on the way!";
		}
		
		
		// get the ending timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it.
		long duration = end - begin;
		System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");
		// We are dividing by 1000 to convert it from milliseconds to seconds.
		
		return result;	// returning whatever the result of our target method (getFortune()).
	}
	
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
	}
	

	
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
