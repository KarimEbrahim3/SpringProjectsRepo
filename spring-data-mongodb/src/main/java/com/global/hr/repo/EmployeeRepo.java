package com.global.hr.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String>{

	@Query(value ="{ 'email': ?0 }" , fields = "{'name' : 1, 'email' : 2}")
	Employee findEmpByEmail(String email) ;
}
