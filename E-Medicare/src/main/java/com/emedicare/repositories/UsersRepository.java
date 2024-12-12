package com.emedicare.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emedicare.entities.Users;

@Repository(value = "userRepository")
@Scope(value = "singleton")
public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByUserNameAndUserPassword(String userName, String userPassword);

}
