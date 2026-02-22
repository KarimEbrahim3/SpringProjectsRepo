package com.global.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.hr.entity.Employee;
import com.global.hr.entity.Role;
import com.global.hr.entity.User;
import com.global.hr.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private RoleService roleServ;
	@Autowired
	private UserRepo userRepo;
	
	@Transactional
	public void addRoleForAllUsers(String roleName) {
		Role role = roleServ.findByName(roleName);
		
			userRepo.findAll().forEach(user->{
				userRepo.updateAllUsersRole(role);
				userRepo.save(user);
			});
		
	}

	public void addUsers(String username, String password) {
		User user = new User(username, password);
			 userRepo.save(user);
	}
}
