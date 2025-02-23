package com.ruben.project.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ruben.project.workshop.domain.Post;
import com.ruben.project.workshop.domain.User;
import com.ruben.project.workshop.repository.PostRepository;
import com.ruben.project.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();

		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Manuel", "maria@gmail.com");
		User ruben = new User(null, "Ruben Pinto", "ruben@gmail.com");
		User marcos = new User(null, "Marcos Mateus", "marcos@gmail.com");
		
		Post p1 = new Post(null, sdf.parse("18/03/2025"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", marcos);
		Post p2 = new Post(null, sdf.parse("20/03/2025"),  "Bom dia",  "Acordei feliz hoje!", ruben);
		
		userRepository.saveAll(Arrays.asList(maria, ruben, marcos));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
	}

}
