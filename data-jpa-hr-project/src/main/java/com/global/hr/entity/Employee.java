package com.global.hr.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.global.hr.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity	
@Table(name = "EMPLOYEES")
@NamedQuery(name = "Employee.findBySalary", query = "select emp from Employee emp where salary>= :salary")

@SqlResultSetMapping(name = "empMapping",entities = @EntityResult(entityClass = Employee.class,fields = {
		@FieldResult(name = "id",column = "EMPLOYEE_ID"),
		@FieldResult(name = "name",column = "FIRST_NAME"),
		@FieldResult(name = "lastName",column = "LAST_NAME"),
		@FieldResult(name = "salary",column = "SALARY"),
		@FieldResult(name = "jobId",column = "JOB_ID"),
		@FieldResult(name = "email",column = "EMAIL"),
		@FieldResult(name = "departmentId", column = "DEPARTMENT_ID")
}))
@NamedNativeQuery(name = "Employee.findByDepartmentNative",query = "select EMPLOYEE_ID,\r\n"
		+ "       FIRST_NAME,\r\n"
		+ "       LAST_NAME,\r\n"
		+ "       SALARY,\r\n"
		+ "       HIRE_DATE,\r\n"
		+ "       JOB_ID,\r\n"
		+ "       EMAIL,\r\n"
		+ "       DEPARTMENT_ID,\r\n"
		+ "       USER_ID\r\n"
		+ "from hr.employees\r\n"
		+ "where department_id = :deptIdP", resultSetMapping = "empMapping")

public class Employee extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private Long id;
	@NotNull
	@Column(name = "FIRST_NAME")
	private String name;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Min(value = 1000)
	@Column(name = "SALARY")
	private Double salary;
	@Column(name = "HIRE_DATE")
	private Date hireDate;
	@Column(name = "JOB_ID")
	private String jobId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "DEPARTMENT_ID", insertable = false, updatable = false)
	private Long departmentId;
	
	@Transient
	private String fullName;
	
	@Formula("FIRST_NAME || ' ' || LAST_NAME")
	private String fullNameSubQuery;


	

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	@JsonIgnore
	private Department dept;
	
	@OneToOne()
	@JoinColumn(name = "USER_ID")
	private User user;
	
	
	
	public Employee() {
		super();
	}


	public Employee(Long id, String name, String lastName) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
	}
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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

	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
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
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getFullNameSubQuery() {
		return fullNameSubQuery;
	}


	public void setFullNameSubQuery(String fullNameSubQuery) {
		this.fullNameSubQuery = fullNameSubQuery;
	}


	@PostLoad
	private void concatName() {
		setFullName(getName() + " " + getLastName());
	}
}
