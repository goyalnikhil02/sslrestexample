package com.example.client.helloclient;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ExampleAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleAspect.class);
	
	/*@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		Object proceed = joinPoint.proceed();

		long executionTime = System.currentTimeMillis() - start;

		LOGGER.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}*/
	
	
	@Before("@annotation(LogExecutionTime)")
	public void logBefore1(JoinPoint joinPoint) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		LOGGER.info("Valaue enter in the methods"+joinPoint.getArgs()[0]);
	 }
	
	
	/*@After("@annotation(com.example.client.helloclient.LogExecutionTime)")
	//@AfterReturning("@annotation(LogExecutionTime)")
	public void logAfter(JoinPoint joinPoint, Object result) {
		//String returnValue = this.getValue(result);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		LOGGER.info("Method Return value : " + result.toString());
	}*/
}
