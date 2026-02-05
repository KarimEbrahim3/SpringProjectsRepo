	package com.global.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;
import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
public List<Employee> findByDepartmentId(Long deptId);


@Query(value = "select emp from Employee emp join emp.dept dept where dept.id = :deptIdP")
public List<Employee> findByDepartment(@Param("deptIdP")Long deptIdP);

public List<Employee> findByNameContainingOrDeptDeptNameContaining(String empName , String deptName); 
}
