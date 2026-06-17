package com.global.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
import com.global.hr.error.RecordNotFoundException;
import com.global.hr.projection.EmployeeProjection;
import com.global.hr.repository.EmployeeRepo;
import com.global.hr.repository.EmployeeSpec;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private MessageSource msgSource;
	
	
	//@Cacheable(value = "byidemployee" ,key = "#id")
	public Employee findById(Long id) {
		Optional<Employee> entity = empRepo.findById(id);
		if(entity.isPresent()){
			return entity.get();
		}
		else {
			String [] msgParam = {id.toString()};
			String msg = msgSource.getMessage("validation.recordNotFound.message",msgParam, LocaleContextHolder.getLocale());
			throw new RecordNotFoundException(msg);
		}
	}
	
	@Cacheable(value = "employee" ,key = "#root.methodName")
	private List<Employee> findAll() {
		return empRepo.findAll();

	}
	
	@CacheEvict(value = "updateemployee" ,key = "#root.methodName")
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
	
	public List<Employee> findByEmpSpec(String empName){
		EmployeeSpec empS = new EmployeeSpec(empName);
		return empRepo.findAll(empS);
	}
}
