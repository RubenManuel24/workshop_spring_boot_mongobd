package com.ruben.project.workshop.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ruben.project.workshop.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
