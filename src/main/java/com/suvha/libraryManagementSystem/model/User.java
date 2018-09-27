package com.suvha.libraryManagementSystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.suvha.libraryManagementSystem.validation.ValidPassword;
@Document(collection="User")
public class User {
@Id
public String id;
@NotNull(message="First name cannot be null")
@NotBlank(message="Enter first name")
private String firstName;
@NotNull(message="Last name cannot be null")
@NotBlank(message="Enter last name") 
private String lastName;
@Email(message="Enter email")
private String email;
@NotNull
@ValidPassword
private String password;

public User () {
	
}
public User(String firstName, String lastName, String email, String password) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getId() {
	return id;
}
}
