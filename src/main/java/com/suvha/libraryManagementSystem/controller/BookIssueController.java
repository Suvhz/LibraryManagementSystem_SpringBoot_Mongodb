package com.suvha.libraryManagementSystem.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.suvha.libraryManagementSystem.model.BookIssue;
import com.suvha.libraryManagementSystem.service.BookIssueService;

@RestController
@RequestMapping(BookIssueController.BASE_URL)
public class BookIssueController {
	
	@Autowired
	BookIssueService bookIssueService;
	
	public static final String BASE_URL = "/api/V1/bookIssue";
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public BookIssue create(@RequestBody BookIssue bookIssue) {
		return bookIssueService.create(bookIssue);
	}
	
	@GetMapping(value="/{id}")
	@ResponseBody
	public BookIssue getById(@PathVariable String id) {
		return bookIssueService.getById(id);
	}
	@GetMapping
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public List<BookIssue> findAll(){
		return bookIssueService.getAll();
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public BookIssue update(@RequestBody BookIssue bookIssue) {
		return bookIssueService.update(bookIssue);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public Map<String, String> deleteById(@PathVariable String id){
		return bookIssueService.delete(id);
	}
	
}
