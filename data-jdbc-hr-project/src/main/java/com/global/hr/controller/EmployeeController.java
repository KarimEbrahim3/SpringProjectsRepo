package com.global.hr.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import com.global.hr.service.EmployeeService;

import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	Logger log = LoggerFactory.getLogger(EmployeeController.class);
@Autowired
EmployeeService empServ;
@GetMapping("/count")
	public long countEmp() {
		return empServ.countEmp();
	}

@GetMapping("/{id}")
public Employee findById(@PathVariable Long id,@RequestHeader(name = "lang-val") String langVal) {
	log.info("Language is ==> "+langVal);
	return empServ.findById(id);
}

@GetMapping("")
public ResponseEntity<?> findAll() {
	return new ResponseEntity(empServ.findAll(),HttpStatus.OK);
}

@GetMapping("/find/{name}")
public Iterable<Employee> findAllByName(@PathVariable String name) {
	return empServ.findByNameContaining(name);
}

@GetMapping("/find/{name}/{sal}")
public Iterable<Employee> findCustomEmp(@PathVariable String name,@PathVariable Double sal) {
	return empServ.findCustomEmployee(name, sal);
}

@GetMapping("/find")
public Iterable<Employee> findCustomEmpReqParam(@RequestParam String name,@RequestParam Double sal) {
	return empServ.findCustomEmployee(name, sal);
}

@PostMapping("")
public Employee createEmp(@RequestBody Employee emp) {
	return empServ.createEmp(emp);
}

@PutMapping("")
public Employee updateEmp(@RequestBody Employee emp) {
	return empServ.updateEmp(emp);
}

@DeleteMapping("/{id}")
public void deleteEmp(@PathVariable Long id) {
	empServ.deleteEmp(id);
}

@PutMapping("/salary")
int updateSalary(@RequestParam Double sal,@RequestParam Long id ) {
	return empServ.updateSalary(sal, id);
}

public void testJackson() {
	ObjectMapper om = new ObjectMapper();
	String str = "{\r\n"
			+ "    \"id\": 214,\r\n"
			+ "    \"name\": \"kareem\",\r\n"
			+ "    \"salary\": 9000.0,\r\n"
			+ "    \"email\": \"kareem@yahoo.com\",\r\n"
			+ "    \"hireDate\": \"2003-06-16T21:00:00.000Z\",\r\n"
			+ "    \"jobId\": \"AD_PRES\",\r\n"
			+ "    \"lastName\": \"abdou\"\r\n"
			+ "}";
	Employee emp = om.readValue(str, Employee.class);
	str = om.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
}


//@PostMapping("")
//public int insertEmp() {
//	return empRepo.save(new Employee(null, null, null));
//}
}
