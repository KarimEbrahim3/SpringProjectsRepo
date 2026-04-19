package com.global.hr.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@Component
public class CalcSalarySchedule {
Logger log = LoggerFactory.getLogger(CalcSalarySchedule.class);
	
	@Scheduled(fixedRate = 2000)
	@Async
	@SchedulerLock(name = "myscheduledTask")
	public void calcSalary() throws InterruptedException {
		Thread.sleep(4000);
		log.info("Scheduuuuuuuuuuuule");
	}
}
