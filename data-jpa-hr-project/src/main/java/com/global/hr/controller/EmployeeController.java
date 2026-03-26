package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.HRStatisticsProjection;
import com.global.hr.entity.Employee;
import com.global.hr.projection.EmployeeProjection;
import com.global.hr.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;

@Validated
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return empServ.findById(id);
	}
	
//	@PostMapping()
//	public Employee createEmployee(@RequestBody @Valid Employee emp) {
//		return (Employee) empServ.createEmployee(emp);
//	}
	
	@PutMapping()
	public Employee updateEmployee(@RequestBody @Valid
			Employee emp) {

		return empServ.updateEmployee(emp);
	}
	
	@GetMapping("/department/{deptId}")
	public List<Employee> findByDepartmentId(@PathVariable Long deptId) {
		return empServ.findByDepartment(deptId);
	}
	
	@GetMapping("/contain/{empName}/{deptName}")
	public List<Employee> findByNameDeptContain(@PathVariable String empName , @PathVariable String deptName){
		return empServ.findByNameDeptContain(empName,deptName);
	};
	
	@GetMapping("/salary")
	public ResponseEntity<?> findBySalary(@RequestParam @Max(value = 200000) Double salary){
		return ResponseEntity.ok(empServ.findBySalary(salary));
	};
	
	@GetMapping("/statistics")
	public ResponseEntity<?> getHrStatistics() {
		return ResponseEntity.ok(empServ.getHrStatistics());
	}
	
	@GetMapping("/sort")
public ResponseEntity<?> findAllSorting() {
		
		return ResponseEntity.ok(empServ.findAllSorting());
	}
	
	@GetMapping("/projection")
	public ResponseEntity<?> findEmpsProjection(){
		return ResponseEntity.ok(empServ.findEmpsProjection());
	}
	
	@GetMapping("/spec/{name}")
	public ResponseEntity<?> findByEmpSpec(@PathVariable String name) {
		return ResponseEntity.ok(empServ.findByEmpSpec(name));
	}
}
