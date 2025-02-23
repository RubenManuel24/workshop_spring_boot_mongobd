package com.ruben.project.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ruben.project.workshop.domain.Post;
import com.ruben.project.workshop.domain.User;
import com.ruben.project.workshop.dto.Author;
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
		
		userRepository.saveAll(Arrays.asList(maria, ruben, marcos));
		
		Post p1 = new Post(null, sdf.parse("18/03/2025"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new Author(marcos));
		Post p2 = new Post(null, sdf.parse("20/03/2025"), "Bom dia", "Acordei feliz hoje!", new Author(marcos));
		
		Post p3 = new Post(null, sdf.parse("01/04/2025"),  "Boa tarde família",  "O dia está maravilhoso!", new Author(ruben));
		Post p4 = new Post(null, sdf.parse("10/04/2025"),  "Eu sou um programador",  "Estou estudando JAVA!", new Author(ruben));
		Post p5 = new Post(null, sdf.parse("20/04/2025"),  "Eu sou Angolano",  "Falamos a língua portuguesa!", new Author(ruben));
		
		Post p6 = new Post(null, sdf.parse("20/04/2025"),  "Bom dia, sou a Maria",  "Estou muito alegre hoje!", new Author(ruben));
		
		
		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		marcos.getPost().addAll(Arrays.asList(p1,p2));
		ruben.getPost().addAll(Arrays.asList(p3,p4,p5));
		maria.getPost().addAll(Arrays.asList(p6));
		
		userRepository.saveAll(Arrays.asList(maria, ruben, marcos));
		
	}

}
