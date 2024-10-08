package com.javaexpress.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.entities.User;
import com.javaexpress.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {

		log.info(" UserService :: createUser {}", user.getUsername());
		log.info(" UserService :: createUser {} {}", user.getUsername(), user.getEmail());

		userRepository.save(user);
		log.info("User Successfully Saved in DB");
	}

	public List<User> fetchAllUsers() {

		List<User> userList = userRepository.findAll();
		List<User> result = userList.stream().sorted(Comparator.comparing(User::getUsername)).toList();
		return result;

		// var is introduced in Java 11 , var keyword will be treated as any data type
		// it will be understood by compiler.
	}

	public User findUserById(Long userId) {

		return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
	}

	public void updateUser(Long userId,User inputUser) {

		User dbUser = findUserById(userId);
		dbUser.setUsername(inputUser.getUsername());
		dbUser.setPassword(inputUser.getPassword());
		dbUser.setEmail(inputUser.getEmail());
		userRepository.save(dbUser);
	}
	
	// For Partial Update
	public void updatePassword(Long userId,User inputUser) {

		User dbUser = findUserById(userId);
		dbUser.setPassword(inputUser.getPassword());
		userRepository.save(dbUser);
	}

	// Hard Delete (means permanently deleting data from DB
	public void deleteUser(Long userId) {

		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
		} else {
			throw new RuntimeException("User Not Found");
		}

	}

	// Hard Delete (means permanently deleting data from DB
	public void deleteUser_another(Long userId) {
		
		User dbUser = findUserById(userId);
		userRepository.delete(dbUser);

	}
	
	
	
}
