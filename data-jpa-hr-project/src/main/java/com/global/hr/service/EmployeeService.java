package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.global.hr.HRStatisticsProjection;
import com.global.hr.base.BaseEntity;
import com.global.hr.base.BaseService;
import com.global.hr.entity.Employee;
import com.global.hr.projection.EmployeeProjection;
import com.global.hr.repository.EmployeeRepo;

@Service
public class EmployeeService extends BaseService<BaseEntity, String>{

	@Autowired
	private EmployeeRepo empRepo;
	
	public Employee findById(Long id) {
		return empRepo.findById(id).orElseThrow();
	}
	
	
	
	public Employee updateEmployee(Employee emp) {
		Employee curEmp = empRepo.findById(emp.getId()).get();
		curEmp.setName(emp.getName());
		curEmp.setSalary(emp.getSalary());
		curEmp.setDept(emp.getDept());
		return empRepo.save(curEmp);
	}
	
	public List<Employee> findByDepartment(Long deptId) {
		
		return empRepo.findByDepartmentNative(deptId);
	}
	
public Page<Employee> findAllSorting() {
	Pageable page = PageRequest.of(1, 8, Sort.by(Direction.DESC,"name")) ;
		return empRepo.findAll(page);
	}
	
	public List<Employee> findByNameDeptContain(String empName , String deptName){
		return empRepo.findByNameContainingOrDeptDeptNameContaining(empName,deptName);
	}
	
	public List<Employee> findBySalary(Double salary){
		return empRepo.findBySalary(salary);
	}
	
	public HRStatisticsProjection getHrStatistics() {
		return empRepo.getHrStatistics();
	}
	public List<EmployeeProjection> findEmpsProjection(){
		return empRepo.findEmpsProjection();
	}
}
