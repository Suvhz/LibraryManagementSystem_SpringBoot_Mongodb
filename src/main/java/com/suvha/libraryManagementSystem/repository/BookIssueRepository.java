package com.suvha.libraryManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.suvha.libraryManagementSystem.model.BookIssue;
@Repository
public interface BookIssueRepository extends MongoRepository<BookIssue, String> {

}
