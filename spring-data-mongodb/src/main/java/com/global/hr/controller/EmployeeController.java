package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;

@Validated
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable String id) {
		return empServ.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable String id) {
		 empServ.deleteById(id);
	}
	
	@PostMapping()
	public Employee insertEmployee(@RequestBody @Valid Employee emp) {
		return empServ.insertEmployee(emp);
	}
	
	@PutMapping()
	public Employee updateEmployee(@RequestBody @Valid Employee emp) {
		return empServ.updateEmployee(emp);
	}
	
	@PutMapping("/updateemail")
	public ResponseEntity<?> updateEmail(@RequestParam String name , @RequestParam @Email String email) {
		 empServ.updateEmail(name , email);
		 return ResponseEntity.ok(null);
	}

	@GetMapping()
	public List<Employee> findAll() {
		return empServ.findAll();
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable @Email String email) {
		return ResponseEntity.ok(empServ.findEmpByEmail(email));
	}

}

