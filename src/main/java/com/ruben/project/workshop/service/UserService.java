package com.ruben.project.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruben.project.workshop.domain.User;
import com.ruben.project.workshop.dto.UserDTO;
import com.ruben.project.workshop.repository.UserRepository;
import com.ruben.project.workshop.service.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll(){
		List<User> list = userRepository.findAll();
		return list;
	}
	
	public User findById(String id){
        	User user = userRepository.findById(id).orElse(null);
        	
        	if(user == null) {
        		throw new ObjectNotFoundException("Object não encontrado");
        	}
        	return user;
        	
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public User fromUserDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
	public User update(User obj) {
		
		User newObj = userRepository.findById(obj.getId()).orElse(null);
		update(newObj, obj);
		return userRepository.save(newObj);
		
	}
	
	private void update(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

}
