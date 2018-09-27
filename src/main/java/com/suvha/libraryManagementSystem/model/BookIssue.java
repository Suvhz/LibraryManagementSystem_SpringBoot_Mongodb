package com.suvha.libraryManagementSystem.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="BookIssue")
public class BookIssue {
	@Id
	private String id;
	private String userId;
	private String bookId;
	private Date issueDate;
	private boolean status;
	
	public BookIssue() {
		
	}
	public BookIssue(String userId, String bookId, boolean status) {
		this.userId = userId;
		this.bookId = bookId;
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getId() {
		return id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	
}
