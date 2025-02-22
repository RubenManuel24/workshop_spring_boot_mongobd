package com.ruben.project.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruben.project.workshop.domain.User;
import com.ruben.project.workshop.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll(){
		List<User> list = userRepository.findAll();
		return list;
	}

}
