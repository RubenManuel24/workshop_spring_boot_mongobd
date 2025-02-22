package com.ruben.project.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ruben.project.workshop.domain.User;
import com.ruben.project.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Manuel", "maria@gmail.com");
		User ruben = new User(null, "Ruben Pinto", "ruben@gmail.com");
		User marcos = new User(null, "Marcos Mateus", "marcos@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, ruben, marcos));
		
	}

}
