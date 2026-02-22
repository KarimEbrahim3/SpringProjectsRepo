package com.global.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.entity.Role;
import com.global.hr.repository.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
public Role findByName(String name) {
	return roleRepo.findByRoleName(name);
	
}

public void addRole(String rolename) {
	Role role = new Role(rolename);
	role.setRoleName(rolename);
	
	roleRepo.save(role);
	
};
}
