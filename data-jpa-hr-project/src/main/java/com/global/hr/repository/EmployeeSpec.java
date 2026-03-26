package com.global.hr.repository;

import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

import com.global.hr.entity.Employee;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmployeeSpec implements Specification<Employee>{

	private String empName;
	
	



	public EmployeeSpec(String empName) {
		super();
		this.empName = empName;
	}





	@Override
	public @Nullable Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		return criteriaBuilder.like(root.get("name"), empName);
	}

}
