package com.douglas.bookstore.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.douglas.bookstore.domain.Category;
import com.douglas.bookstore.dtos.CategoryDTO;
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
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category insert (Category obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Category update (Integer id, CategoryDTO objDto) {
		Category obj = findById(id);
		obj.setName(objDto.getName());
		obj.setDescription(objDto.getDescription());
		return repository.save(obj);
	}
	
	public Category patch(Integer id, CategoryDTO objDto) {
		Category obj = findById(id);
		if(objDto.getName() != null)obj.setName(objDto.getName());
		if(objDto.getDescription() != null)obj.setDescription(objDto.getDescription());
		return repository.save(patchValidation(obj));
	}
	
	public Category patchValidation(@Valid Category obj) {
		return obj;
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.douglas.bookstore.service.exceptions.DataIntegrityViolationException(
					"Category can't be deleted! It has associated books!");
		}
	}
}
