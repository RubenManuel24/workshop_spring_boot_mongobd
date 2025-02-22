package com.ruben.project.workshop.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruben.project.workshop.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
		User u1 = new User("1", "Ruben Manuel", "rub");
		User u2 = new User("1", "Adilson Marcos", "rub");
		User u3 = new User("1", "Maria Manuel", "rub");
		
		List<User> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(u1,u2,u3));
		
		return ResponseEntity.ok().body(list);
		
	}

}
