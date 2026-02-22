package com.global.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.service.RoleService;
import com.global.hr.service.UserService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
private RoleService roleServ;
	
	@PostMapping()
	public ResponseEntity<?> addUser(@RequestParam String rolename) {
		roleServ.addRole(rolename);
		return ResponseEntity.ok(null);
	}
}
