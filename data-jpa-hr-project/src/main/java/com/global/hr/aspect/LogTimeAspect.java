package com.global.hr.aspect;

import java.util.Iterator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class LogTimeAspect {

	Logger log = LoggerFactory.getLogger(LogTimeAspect.class);

	
	@Pointcut(value = "execution(* com.global.hr.repository..*(..))")
	public void forRepositoryLog() {
		
	}
	
	@Pointcut(value = "execution(* com.global.hr.service..*(..))")
	public void forServiceLog() {
		
	}
	
	@Pointcut(value = "execution(* com.global.hr.controller..*(..))")
	public void forControllerLog() {
		
	}
	@Pointcut(value = "forRepositoryLog() || forServiceLog() || forControllerLog()")
public void forAllApp() {
		
	}
	@Before(value = "forAllApp()")
public void beforeMethod(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		log.info("Method name is ==> "+methodName);
		Object[] args= jp.getArgs();
		for (Object arg : args) {
			log.info("Argument is ==> "+arg);
		}
	}
	
	
}
