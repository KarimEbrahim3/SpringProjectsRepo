package com.global.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.entity.Department;
import com.global.hr.entity.Employee;
import com.global.hr.repository.DepartmentRepo;
import com.global.hr.repository.EmployeeRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo deptRepo;
	
	public Department findById(Long id) {
		return deptRepo.findById(id).orElseThrow();
	}
}
