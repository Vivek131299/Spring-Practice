package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {


	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {} 
	
	
	// Create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))") // Match getter methods (get*)
	public void getter() {}
	
	// Create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))") // Match setter methods (set*)
	public void setter() {}
	
	// Create Combined Pointcut: INCLUDE package and EXCLUDE getter/setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	// Above, will INCLUDE our all package methods BUT EXCLUDE getter and setter methods.
	
}
