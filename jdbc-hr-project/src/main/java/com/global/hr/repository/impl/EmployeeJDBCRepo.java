package com.global.hr.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeRepo;

@Component("EmployeeJDBCRepo")
public class EmployeeJDBCRepo implements EmployeeRepo{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	
	@Override
	public int count() {
		
		return jdbcTemplate.queryForObject("select count(*) from hr.employees", Integer.class);
	}

	@Override
	public Employee findById(Long id) {
		
		return jdbcTemplate.queryForObject("select employee_id,first_name,salary from hr.employees where employee_id=?",new Object[] {id} 
		,new EmployeeMapper());
	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("select employee_id,first_name,salary from hr.employees",new EmployeeMapper());
	}

	@Override
	public int insert(Employee emp) {
		
		return jdbcTemplate.update("insert into emplyees (employee_id,first_name,salary) values (?,?,?)",new Object[] {emp.getId(),emp.getName(),emp.getSalary()});
	}

	@Override
	public int update(Employee emp) {
		return jdbcTemplate.update("update employees set first_name=? ,salary=? where employee_id=?",new Object[] {emp.getName(),emp.getSalary(),emp.getId()});
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("delete from  employees where employee_id=?",new Object[] {id});
	}


	@Override
	public Employee findByNameAndSal(String name, Double salary) {
		// TODO Auto-generated method stub
		return null;
	}

}
