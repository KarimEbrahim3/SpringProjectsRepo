package com.global.hr.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("EMPLOYEES")
public class Employee {
	@Id
	@Column("EMPLOYEE_ID")
	private Long id;
	@Column("FIRST_NAME")
	private String name;
	@Column("LAST_NAME")
	private String lastName;
	@Column("SALARY")
	private Double salary;
	@Column("HIRE_DATE")
	private Date hireDate;
	@Column("JOB_ID")
	private String jobId;
	@Column("EMAIL")
	private String email;


public Employee(Long id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
public Employee() {
		super();
	}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
public Date getHireDate() {
	return hireDate;
}
public void setHireDate(Date hireDate) {
	this.hireDate = hireDate;
}
public String getJobId() {
	return jobId;
}
public void setJobId(String jobId) {
	this.jobId = jobId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
