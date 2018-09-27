package com.suvha.libraryManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.suvha.libraryManagementSystem.model.User;
@Repository
public interface UserReppository extends MongoRepository<User, String>{

}
