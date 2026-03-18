package com.global.hr.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.global.hr.entity.Employee;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseService <T extends BaseEntity , ID>{
	@Autowired
private BaseRepository<BaseEntity, ID>baseRepository;
	
	public T createEmployee(T emp) {
		return baseRepository.save(emp);
	}
}
