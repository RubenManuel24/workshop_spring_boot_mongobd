package com.ruben.project.workshop.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ruben.project.workshop.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	
	@Query("{ $and: [ {date: { $gte: ?1 }}, {date: { $lte: ?2 }}, { $nor: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'listComments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearce(String text, Date minDate, Date maxDat);
	
}
