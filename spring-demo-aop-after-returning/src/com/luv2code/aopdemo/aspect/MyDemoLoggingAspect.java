package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	
	///// @AfterReturning ANNOTATION /////
	// Previously we have seen @Before Annotation which executes Advice before any method runs.
	// BUT @AfterReturning executes AFTER THE METHOD has been successfully executed.
	// Syntax is similar to @Before like: @AfterReturning("execution(pointcut_Expression)").
	//
	// BUT in this, as we are executing it after method has been successfully finished executing,
	// we can ACCESS THE RETURNED VALUE from the Method.
	// This means, if the method returns anything, then we can access it JUST LIKE we accessed 
	// method arguments in @Before by using JOINPOINT.
	// So then our Annotation becomes like : 
	// @AfterReturning(pointcut="execution(pointcut_Expression)", returning="variable").
	// Above, 'variable' will store whatever the value returned by the method.
	// AND THEN we SPECIFY JoinPoint and returning variable in the parameters of our Advice.
	// NOTE : variable name in given returning in Annotation SHOULD MATCH the variable 
	//        name given in parameter of Advice.
	
	
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
