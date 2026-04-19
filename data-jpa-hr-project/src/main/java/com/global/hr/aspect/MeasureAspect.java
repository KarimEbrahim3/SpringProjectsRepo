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
@Order(0)
@Component
public class MeasureAspect {

	Logger log = LoggerFactory.getLogger(MeasureAspect.class);
	@Around("execution(* com.global.hr.service..*(..))")
	public void logTime(ProceedingJoinPoint  jp) throws Throwable {
		Long startTime = System.currentTimeMillis();
		StringBuilder sp = new StringBuilder();
		jp.proceed();
		log.info(sp.append(System.currentTimeMillis() - startTime).append(" ms ").toString());
	}
	
	
}
