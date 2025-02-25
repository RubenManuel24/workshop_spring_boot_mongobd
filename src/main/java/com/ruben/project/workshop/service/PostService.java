package com.ruben.project.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruben.project.workshop.domain.Post;
import com.ruben.project.workshop.domain.User;
import com.ruben.project.workshop.dto.UserDTO;
import com.ruben.project.workshop.repository.PostRepository;
import com.ruben.project.workshop.service.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	public Post findById(String id){
        	Post post = postRepository.findById(id).orElse(null);
        	
        	if(post == null) {
        		throw new ObjectNotFoundException("Object não encontrado");
        	}
        	return post;
        	
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
}
