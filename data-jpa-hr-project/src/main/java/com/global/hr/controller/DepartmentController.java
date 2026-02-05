package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Department;
import com.global.hr.entity.Employee;
import com.global.hr.service.DepartmentService;
import com.global.hr.service.EmployeeService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService deptServ;
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		return deptServ.findById(id);
	}
	
	@GetMapping()
	public List<Department> findAllDepartments() {
		return deptServ.findAllDepartments();
	}
	
	@PostMapping()
	public Department createDepartment(@RequestBody Department dpt) {
		return deptServ.createDepartment(dpt);
	}
	
	@PutMapping()
	public Department updateDepartment(@RequestBody Department dpt) {
		
		return deptServ.updateDepartment(dpt);
	}
}
