package com.ruben.project.workshop.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruben.project.workshop.domain.Post;
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
		return postRepository.searchTitle(text);
		//return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		 
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 100);
		
		return postRepository.fullSearce(text, minDate, maxDate);
	}
	
}
