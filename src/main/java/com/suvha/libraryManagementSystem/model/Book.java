package com.suvha.libraryManagementSystem.model;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Books")
public class Book {

	@Id
	private String id;
	@NotNull(message="Name cannot be null")
	@NotBlank(message="Enter the name")
	private String name;
	@Min(value=1, message="Please enter quantity greater than 0")
	private int quantity;
	@NotNull(message="location cannot be null")
	@NotBlank(message="Enter the location")
	private String location;
	@NotNull(message="Description cannot be null")
	@NotBlank(message="Enter the description")
	private String description;
	@NotNull(message="ISBN cannot be null")
	@NotBlank(message="Enter the isbn")
	private String isbn;
	@NotNull(message="Publisher cannot be null")
	@NotBlank(message="Enter the publisher")
	private String publisher;
	@NotNull(message="Author cannot be null")
	@NotBlank(message="Enter the author")
	private String author;
	private String userId;

     public Book() {
     
     }

	public Book( String name, String location, String isbn, String description, String publisher, String author,
			int quantity, String userId) {
		super();
		
		this.name = name;
		this.location = location;
		this.isbn = isbn;
		this.description = description;
		this.publisher = publisher;
		this.author = author;
		this.quantity = quantity;
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getId() {
		return id;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
