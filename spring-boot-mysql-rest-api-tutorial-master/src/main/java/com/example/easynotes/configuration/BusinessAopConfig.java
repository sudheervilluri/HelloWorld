package com.example.easynotes.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


/**
 * 
    @After - Executed in two situations - when a method executes successfully or it throws an exception.
    @AfterReturning - Executed only when a method executes successfully.
    @AfterThrowing - Executed only when a method throws an exception.

 * @author SVilluri
 *
 */
@Aspect
@Configuration
public class BusinessAopConfig {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//Before execution
	@Before("execution(* com.example.easynotes.*.*.*(..))")
	public void before(JoinPoint joinPoint){
		//Advice
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint);
	}
	
	//after execution
	@After("execution(* com.example.easynotes.*.*.*(..))")
	public void after(JoinPoint joinPoint){
		//Advice
		//logger.info(" Check for user access ");
		logger.info(" completed execution for {}", joinPoint);
	}
	
	//Return only after successfull execution
	@AfterReturning(value = "execution(* com.example.easynotes.*.*.*(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}
	
	
}
