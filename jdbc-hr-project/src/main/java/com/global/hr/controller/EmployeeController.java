package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	@Qualifier("EmployeeJDBCRepo")
	private EmployeeRepo empRepo;
	
	@Autowired
	@Qualifier("EmployeeNamedParamJDBCRepo")
	private EmployeeRepo empNamRepo;
	
	@GetMapping("/count")
public int countEmployees() {
	return empRepo.count();
}
	@GetMapping("/findemployee/{id}")
	public Employee findEmployee(@PathVariable Long id) {
		return empRepo.findById(id);
	}
	@GetMapping("/findallemployee")
	public List<Employee> findAllEmployees() {
		return empRepo.findAll();
	}
	
	@GetMapping("/findemp/{name}/{sal}")
	public Employee findEmployeeByNameOrSal(@PathVariable String name,@PathVariable Double sal) {
		return empNamRepo.findByNameAndSal(name, sal);
	}
	
}
