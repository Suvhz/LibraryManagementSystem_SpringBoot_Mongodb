package com.suvha.libraryManagementSystem.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.suvha.libraryManagementSystem.model.Book;
import com.suvha.libraryManagementSystem.service.BookService;

@RestController
@RequestMapping(BookController.BASE_URL)
public class BookController {

	public static final String BASE_URL = "/api/V1/book";

	@Autowired
	BookService bookService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public Book save(@RequestBody @Valid Book book) {

		return bookService.create(book);
	}
	//Retrieves all book which quantity is greater than 0
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Book> get() {

		return bookService.get();
	}
	//Retrieves all book
	@GetMapping(value="/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Book> getAll(){
		return bookService.getAll();
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> delete(@PathVariable String id) {

		return bookService.delete(id);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book update(@RequestBody Book book) {
		return bookService.update(book);
	}

	@GetMapping(value = "/name/{bookName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book getByName(@PathVariable String bookName) {
		return bookService.getByBookName(bookName);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book getByid(@PathVariable String id) {
		return bookService.getById(id);
	}

}
