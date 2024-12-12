package com.emedicare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emedicare.entities.Users;
import com.emedicare.services.UsersService;

@RestController
@RequestMapping("/user")
@Scope(value = "request")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
	
	@Autowired
	@Qualifier("userService")
	private UsersService userService;
	
	@GetMapping(value="", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Users getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping(value="", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Users addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}
	
	@PutMapping(value="/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Users updateUser(@PathVariable Long id, @RequestBody Users updateUser) {
		return userService.updateUser(id, updateUser);
	}
	
	@DeleteMapping(value="/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
	}
	
	@PostMapping(value="/login/{username}/{password}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> login(@PathVariable String username, @PathVariable String password) {
		System.out.println(username + " " + password);
        return userService.findByUserNameAndUserPassword(username, password);
    }
	
}
