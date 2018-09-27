package com.suvha.libraryManagementSystem.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.suvha.libraryManagementSystem.exception.DataNotFoundException;
import com.suvha.libraryManagementSystem.model.Book;
import com.suvha.libraryManagementSystem.model.BookIssue;
import com.suvha.libraryManagementSystem.model.User;
import com.suvha.libraryManagementSystem.repository.BookIssueRepository;
import com.suvha.libraryManagementSystem.serviceDAO.ServiceDAO;

@Service
public class BookIssueService implements ServiceDAO<BookIssue> {

	@Autowired
	private BookIssueRepository bookIssueRepository;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	@Transactional
	@Override
	public BookIssue create(BookIssue t) {
		Book book = bookService.getById(t.getBookId());
		User user = userService.getById(t.getUserId());
		int quantity = book.getQuantity();
		if (user != null) {
			if (quantity > 0) {
				book.setQuantity(quantity - 1);
				bookService.update(book);
				t.setStatus(false);
				Date date = new Date();
				t.setIssueDate(date);
				return bookIssueRepository.save(t);
			}
		}
		throw new DataNotFoundException("Book with id " + t.getBookId() + " not found");

	}

	@Override
	public List<BookIssue> getAll() {
		return bookIssueRepository.findAll();
	}

	@Override
	public BookIssue getById(String id) {
		Optional<BookIssue> bookIssue = bookIssueRepository.findById(id);
		if (bookIssue.isPresent()) {
			return bookIssue.get();
		}
		throw new DataNotFoundException("BookIssue with id " + id + " not found");
	}

	@Override
	public BookIssue update(BookIssue t) {
		BookIssue bookIssue = getById(t.getId());
		bookIssue.setBookId(t.getBookId());
		bookIssue.setUserId(t.getUserId());
		bookIssue.setStatus(t.isStatus());
		return bookIssueRepository.save(bookIssue);
	}

	@Override
	public Map<String, String> delete(String id) {
		BookIssue bookIssue = getById(id);
		bookIssueRepository.delete(bookIssue);
		return Collections.singletonMap("response", "Deleted successfully");
	}

	@Override
	public void deleteAll() {
		bookIssueRepository.deleteAll();

	}

}
