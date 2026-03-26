	package com.global.hr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.HRStatisticsProjection;
import com.global.hr.base.BaseRepository;
import com.global.hr.entity.Employee;
import com.global.hr.projection.EmployeeProjection;

import java.util.List;


@Repository
public interface EmployeeRepo extends BaseRepository<Employee, Long> ,JpaSpecificationExecutor<Employee>{
public List<Employee> findByDepartmentId(Long deptId);


@Query(value = "select emp from Employee emp join emp.dept dept where dept.id = :deptIdP")
public List<Employee> findByDepartment(@Param("deptIdP")Long deptIdP);

public List<Employee> findByDepartmentNative(@Param("deptIdP")Long deptIdP);

public List<Employee> findByNameContainingOrDeptDeptNameContaining(String empName , String deptName); 

public List<Employee> findBySalary(Double salary);

@Query(value = "select (select count(*) from hr.employees) empCount,\r\n"
		+ "       (select count(*) from hr.departments) deptCount,\r\n"
		+ "       (select count(*) from hr.sec_users) usrCount\r\n"
		+ "       from dual", nativeQuery = true)
HRStatisticsProjection getHrStatistics();


@Query(value = "select new Employee(emp.id,emp.name,emp.lastName) from Employee emp")
public List<EmployeeProjection> findEmpsProjection();
}
