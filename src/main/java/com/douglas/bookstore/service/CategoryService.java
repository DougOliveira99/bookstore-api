package com.douglas.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.bookstore.domain.Category;
import com.douglas.bookstore.repositories.CategoryRepository;
import com.douglas.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Category not found! Id: " + id + " Type: " + Category.class.getName()));
	}
}
