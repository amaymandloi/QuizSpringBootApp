package com.yash.aspects;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAspect {

	Logger logger=Logger.getLogger("LoggingAspect");
	@Before("execution(* com.yash.*.*.*(..))")
	public void beforeAdvice(JoinPoint point) {
		logger.log(Level.INFO,"--Before advice applied--"+point.getSignature().getName());
		
	}
	@After("execution(* com.yash.*.*.*(..))")
	public void afterAdvice(JoinPoint point) {
		logger.log(Level.INFO,"--After advice applied--"+point.getSignature().getName());
		
	}
	
	@AfterReturning(pointcut = "within(com.yash.controller.*)",returning = "result")
	public void afterReturning(JoinPoint point,Object result) {
		logger.log(Level.INFO,"--After returning aspect--"+point.getSignature().getName()+" returns "+result);
	}
	@AfterThrowing(pointcut = "execution(* com.yash.*.*.*(..))",throwing="error")
	public void afterThrowing(JoinPoint point,Throwable error) {
		logger.log(Level.INFO,"--After throwing aspect--"+point.getSignature().getName()+" error "+error);
	}
	@Pointcut("execution(* com.yash.controller.UserController.handleGetAllUserJSON(..))")
	public void getPointCut() {
		
	}
	@Around("getPointCut()")
	public Object aroundAdvice(ProceedingJoinPoint point) {
		logger.log(Level.INFO,"--Around advice applied--"+point.getSignature().getName());
		Object o=null;
		try {
			o=point.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String methodReturned=(String)o;
		return methodReturned.toUpperCase();
	}
	
}
