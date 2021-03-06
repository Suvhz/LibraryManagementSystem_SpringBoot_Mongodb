package com.suvha.libraryManagementSystem.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suvha.libraryManagementSystem.exception.DataNotFoundException;
import com.suvha.libraryManagementSystem.exception.IdInCreateException;
import com.suvha.libraryManagementSystem.model.Book;
import com.suvha.libraryManagementSystem.repository.BookRepository;
import com.suvha.libraryManagementSystem.serviceDAO.ServiceDAO;

@Service
public class BookService implements ServiceDAO<Book> {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book create(Book book) {
		if(book.getId()!=null) {
			throw new IdInCreateException("Don't pass id");
		}

		return bookRepository.save(book);
	}

	public List<Book> get() {
		return bookRepository.findByQuantityGreaterThan(0);
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	public Book getByBookName(String bookName) {
		Book book = bookRepository.findByName(bookName);
		if (book != null) {
			return book;
		}
		throw new DataNotFoundException("Book with name " + bookName + " not found");
	}

	@Override
	public Book update(Book book) {
		Book findedBook = getById(book.getId());
		findedBook.setName(book.getName());
		findedBook.setAuthor(book.getAuthor());
		findedBook.setDescription(book.getDescription());
		findedBook.setLocation(book.getLocation());
		findedBook.setQuantity(book.getQuantity());
		findedBook.setIsbn(book.getIsbn());
		findedBook.setPublisher(book.getPublisher());
		return bookRepository.save(findedBook);

	}

	@Override
	public void deleteAll() {
		bookRepository.deleteAll();
	}

	@Override
	public Map<String, String> delete(String id) {
		Book book = getById(id);
		bookRepository.delete(book);
		return Collections.singletonMap("response", "Deleted successfully");

	}

	@Override
	public Book getById(String id) {

		Optional<Book> bookOptional = bookRepository.findById(id);
		if (bookOptional.isPresent()) {
			return bookOptional.get();
		}
		throw new DataNotFoundException("Book with id " + id + " not found");

	}

}