package com.global.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.entity.Employee;
import com.global.hr.repo.CustomEmployeeRepo;
import com.global.hr.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private CustomEmployeeRepo cusEmpRepo;
	
	public Employee findById(String id) {
		return empRepo.findById(id).get();
	}
	
	public Employee updateEmployee(Employee emp) {
		Employee curEmp = empRepo.findById(emp.getId()).get();
		curEmp.setName(emp.getName());
		curEmp.setEmail(emp.getEmail());
		curEmp.setPhone(emp.getPhone());
		return empRepo.save(curEmp);
	}
	
	public List<Employee> findAll() {
		return empRepo.findAll();
	}
	
	public void deleteById(String id) {
		 empRepo.deleteById(id);
	}
	
	public Employee insertEmployee(Employee emp) {
		
		return empRepo.save(emp);
	}
	
	public Employee findEmpByEmail(String email) {
		return empRepo.findEmpByEmail(email);
	}
	
	public void updateEmail(String name, String email) {
		cusEmpRepo.updateEmail(name, email);
	}
}
