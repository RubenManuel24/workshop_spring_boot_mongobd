package com.ruben.project.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ruben.project.workshop.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
