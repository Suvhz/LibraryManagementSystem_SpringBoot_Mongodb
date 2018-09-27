package com.suvha.libraryManagementSystem.serviceDAO;

import java.util.List;
import java.util.Map;

public interface ServiceDAO<T>{
	public T create(T t);
	public List<T> getAll();
	public T getById(String id);
	public T update(T t);
	public Map<String, String> delete(String id);
	public void deleteAll();
}
