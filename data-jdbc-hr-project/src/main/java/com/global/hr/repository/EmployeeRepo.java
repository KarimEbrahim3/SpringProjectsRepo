package com.global.hr.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;
import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>{
List<Employee> findByName(String name);

List<Employee> findByNameContaining(String name);
@Query(value ="SELECT employee_id, first_name, salary\r\n"
		+ "FROM hr.employees\r\n"
		+ "WHERE first_name LIKE '%' || :empName || '%' or salary >= :empSal")
List<Employee>findCustomEmployee(@Param("empName") String name ,@Param("empSal") Double salary);
}
