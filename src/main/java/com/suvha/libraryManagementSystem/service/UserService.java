package com.suvha.libraryManagementSystem.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suvha.libraryManagementSystem.exception.DataNotFoundException;
import com.suvha.libraryManagementSystem.model.User;
import com.suvha.libraryManagementSystem.repository.UserReppository;
import com.suvha.libraryManagementSystem.serviceDAO.ServiceDAO;

@Service
public class UserService implements ServiceDAO<User>{
	@Autowired
	private UserReppository userRepository;
	
	@Override
	public User create(User t) {
		return userRepository.save(t);
	}

	@Override
	public List<User> getAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User getById(String id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new DataNotFoundException("User with id "+id+" not found");
	}

	@Override
	public User update(User t) {
		User user = getById(t.getId());
		user.setEmail(t.getEmail());
		user.setFirstName(t.getFirstName());
		user.setLastName(t.getLastName());
		user.setPassword(t.getPassword());
		return userRepository.save(user);
	}

	@Override
	public Map<String, String> delete(String id) {
		User user = getById(id);
		userRepository.delete(user);
		return Collections.singletonMap("Response", "Deleted successfully.");
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
		
	}

}
