package com.ruben.project.workshop.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ruben.project.workshop.domain.User;
import com.ruben.project.workshop.dto.UserDTO;
import com.ruben.project.workshop.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		List<UserDTO> listUserdto = list.stream().map(x -> new UserDTO(x)).toList();
		return ResponseEntity.ok().body(listUserdto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
		User user = userService.fromUserDTO(objDTO);
		user = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
