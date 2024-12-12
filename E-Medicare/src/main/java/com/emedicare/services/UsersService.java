package com.emedicare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emedicare.entities.Users;
import com.emedicare.repositories.UsersRepository;

import jakarta.transaction.Transactional;

@Service(value = "userService")
@Scope(value = "singleton")
@Transactional
public class UsersService {
	
	@Autowired
	@Qualifier(value = "userRepository")
	private UsersRepository userRepository;

	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	public Users getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public Users addUser(Users user) {
		return userRepository.save(user);
	}

	public Users updateUser(Long id, Users updateUser) {
		if(userRepository.existsById(id)) {
			updateUser.setUserId(id);
			return userRepository.save(updateUser);
		}
		return null;
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	public ResponseEntity<?> findByUserNameAndUserPassword(String userName, String userPassword) {
		Users user = userRepository.findByUserNameAndUserPassword(userName, userPassword);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
	}

}
