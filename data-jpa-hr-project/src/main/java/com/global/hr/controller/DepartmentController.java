package com.global.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
