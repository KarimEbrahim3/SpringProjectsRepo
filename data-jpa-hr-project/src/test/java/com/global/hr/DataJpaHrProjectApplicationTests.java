package com.global.hr;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.global.hr.entity.Employee;
import com.global.hr.service.EmployeeService;

@SpringBootTest
class DataJpaHrProjectApplicationTests {

	@Autowired
	EmployeeService empService;
	
	@Test
	void findByIdTest() {
		 Employee employee = empService.findById((long) 100);
		 System.out.println(empService.findById(100L));
	assertAll(
	        () -> assertNotNull(employee)
	    );
	}

}
