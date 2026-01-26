package com.global.hr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jspecify.annotations.Nullable;
import org.springframework.jdbc.core.RowMapper;

import com.global.hr.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Employee(rs.getLong("employee_id"), rs.getString("first_name"), rs.getDouble("salary"));
	}



}
