package com.global.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
private UserService userServ;
	
	@PostMapping()
	public ResponseEntity<?> addUser(@RequestParam String username,@RequestParam String password) {
		 userServ.addUsers(username,password);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/role/{roleName}")
	public ResponseEntity<?> addRoleForAllUsers(@PathVariable String roleName) {
		userServ.addRoleForAllUsers(roleName);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping()
	public ResponseEntity<?> findAllUsers() {
		return ResponseEntity.ok(userServ.findAllUsers());
	}
}
