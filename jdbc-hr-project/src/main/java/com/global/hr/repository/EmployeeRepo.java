package com.global.hr.repository;

import java.util.List;

import com.global.hr.model.Employee;

public interface EmployeeRepo {
int count();
Employee findById(Long id);
Employee findByNameAndSal(String name,Double salary);
List<Employee> findAll();
int insert(Employee emp);
int update(Employee emp);
int delete(Long id);
}
