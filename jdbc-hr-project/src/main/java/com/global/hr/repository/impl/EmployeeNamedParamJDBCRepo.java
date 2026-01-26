package com.global.hr.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeRepo;

@Component("EmployeeNamedParamJDBCRepo")
public class EmployeeNamedParamJDBCRepo implements EmployeeRepo{
	
	@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	
	@Override
	public int count() {
		
		return namedParameterJdbcTemplate.queryForObject("select count(*) from hr.employees", new MapSqlParameterSource(),Integer.class);
	}

	@Override
	public Employee findById(Long id) {
		
		return namedParameterJdbcTemplate.queryForObject("select employee_id,first_name,salary from hr.employees where employee_id=:id",new MapSqlParameterSource("id", id)
		,new EmployeeMapper());
	}

	@Override
	public List<Employee> findAll() {
		return namedParameterJdbcTemplate.query("select employee_id,first_name,salary from hr.employees",new EmployeeMapper());
	}

	@Override
	public int insert(Employee emp) {
		
		return namedParameterJdbcTemplate.update("insert into emplyees (employee_id,first_name,salary) values (:id,:name,:salary)",new BeanPropertySqlParameterSource(emp));
	}

	@Override
	public int update(Employee emp) {
		return namedParameterJdbcTemplate.update("update employees set first_name=:name ,salary=:salary where employee_id=:id",new BeanPropertySqlParameterSource(emp));
	}

	@Override
	public int delete(Long id) {
		return namedParameterJdbcTemplate.update("delete from  employees where employee_id=:id",new MapSqlParameterSource("id", id));
	}

	@Override
	public Employee findByNameAndSal(String name, Double salary) {
		MapSqlParameterSource mpsql = new MapSqlParameterSource();
		mpsql.addValue("name", "%" + name + "%");
		mpsql.addValue("sal", salary);
		
		return namedParameterJdbcTemplate.queryForObject("select employee_id,first_name,salary from hr.employees where first_name like :name or salary =:sal",
				mpsql
				,new EmployeeMapper());
	}

}
