package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo empRepo;
	
	public Employee findById(Long id){
		return empRepo.findById(id).get();
	};
	
	public List<Employee> findByName(String name){
		return empRepo.findByName(name);
	};

	public List<Employee> findAll() {
		return  (List<Employee>) empRepo.findAll();
	}
	
	
	public Employee createEmp(Employee emp) {
		return empRepo.save(emp);
	}

	
	public Employee updateEmp(Employee emp) {
		return empRepo.save(emp);
	}
	
	public void deleteEmp(Long id) {
		 empRepo.deleteById(id);
	}
	
	public List<Employee> findByNameContaining(String name){
		return empRepo.findByNameContaining(name);
	};
	
	public List<Employee>findCustomEmployee(@Param("empName") String name ,@Param("empSal") Double salary){
		return empRepo.findCustomEmployee(name,salary);
	};
	public long countEmp() {
		return empRepo.count();
	}
	
	public int updateSalary(Double salary,Long id ) {
		return empRepo.updateSalary(salary, id);
	}
}
