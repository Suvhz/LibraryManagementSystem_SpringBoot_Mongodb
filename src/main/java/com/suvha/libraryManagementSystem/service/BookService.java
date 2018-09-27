package com.suvha.libraryManagementSystem.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suvha.libraryManagementSystem.exception.DataNotFoundException;
import com.suvha.libraryManagementSystem.model.Book;
import com.suvha.libraryManagementSystem.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book create(Book book) {
		Book books = new Book();
		books = book;
		return bookRepository.save(books);
	}

	public List<Book> get() {
		return bookRepository.findByQuantityGreaterThan(0);
	}
	public List<Book> getAll(){
		return bookRepository.findAll();
	}

	public Book getByBookName(String bookName) {
		Book book = bookRepository.findByName(bookName);
		if (book != null) {
			return book;
		}
		throw new DataNotFoundException("Book with name " + bookName + " not found");
	}

	public Book update(Book book) {
		Book findedBook = findById(book.getId());
		findedBook.setName(book.getName());
		findedBook.setAuthor(book.getAuthor());
		findedBook.setDescription(book.getDescription());
		findedBook.setLocation(book.getLocation());
		findedBook.setQuantity(book.getQuantity());
		findedBook.setIsbn(book.getIsbn());
		findedBook.setPublisher(book.getPublisher());
		return bookRepository.save(findedBook);

	}

	public void deleteAll() {
		bookRepository.deleteAll();
	}

	public Map<String, String> delete(String id) {
		Book book = findById(id);
		bookRepository.delete(book);
		return Collections.singletonMap("response", "Deleted successfully");

	}

	public Book findById(String id) {

		Optional<Book> bookOptional = bookRepository.findById(id);
		if (bookOptional.isPresent()) {
			return bookOptional.get();
		}
		throw new DataNotFoundException("Book with id " + id + " not found");

	}
}