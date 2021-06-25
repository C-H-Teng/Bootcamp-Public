package com.charlesteng.javabeltexam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.charlesteng.javabeltexam.models.User;
import com.charlesteng.javabeltexam.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	// register and has password
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	// find user by email
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	// find by id
	public User findById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
	// authenticate
	public boolean authenticateUser(String email, String password) {
		// find by email
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
