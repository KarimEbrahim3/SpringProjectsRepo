package com.global.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	public Employee findById(Long id) {
		return empRepo.findById(id).orElseThrow();
	}
}
