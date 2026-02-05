package com.global.hr.service;

import java.util.List;

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
	
	public Department createDepartment(Department dpt) {
		return deptRepo.save(dpt);
	}
	
	public Department updateDepartment(Department dpt) {
		Department curDpt = deptRepo.findById(dpt.getId()).get();
		curDpt.setDeptName(dpt.getDeptName());
		return deptRepo.save(curDpt);
	}
	
	public List<Department> findAllDepartments() {
		return deptRepo.findAll();
	}
}
