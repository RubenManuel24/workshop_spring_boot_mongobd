package com.ruben.project.workshop.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ruben.project.workshop.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
