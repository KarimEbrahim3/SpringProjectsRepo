package com.global.hr.service;

import java.util.List;

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
	
	public Employee createEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Employee updateEmployee(Employee emp) {
		Employee curEmp = empRepo.findById(emp.getId()).get();
		curEmp.setName(emp.getName());
		curEmp.setSalary(emp.getSalary());
		curEmp.setDept(emp.getDept());
		return empRepo.save(curEmp);
	}
	
	public List<Employee> findByDepartment(Long deptId) {
		
		return empRepo.findByDepartment(deptId);
	}
	
	public List<Employee> findByNameDeptContain(String empName , String deptName){
		return empRepo.findByNameContainingOrDeptDeptNameContaining(empName,deptName);
	};
}
