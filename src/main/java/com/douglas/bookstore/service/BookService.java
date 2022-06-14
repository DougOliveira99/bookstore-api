package com.douglas.bookstore.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.bookstore.domain.Book;
import com.douglas.bookstore.domain.Category;
import com.douglas.bookstore.repositories.BookRepository;
import com.douglas.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryService categoryService;
	
	public Book findById(Integer id) {
		Optional<Book> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Book not Found! Id: " + id + ", Type: " + Book.class.getName()));
	}
	
	public List<Book> findAll(Integer id_cat) {
		categoryService.findById(id_cat);
		return repository.findAllByCategory(id_cat);
	}

	public Book update(Integer id, Book obj) {
		Book newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Book newObj, Book obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setAuthor(obj.getAuthor());
		newObj.setText(obj.getText());
	}
	
	public Book patch(Integer id, Book obj) {
		Book newObj = findById(id);
		patchData(newObj, obj);
		return repository.save(patchValidation(newObj));
	}
	
	private void patchData(Book newObj, Book obj) {
		if(obj.getTitle() != null)newObj.setTitle(obj.getTitle());
		if(obj.getAuthor() != null)newObj.setAuthor(obj.getAuthor());
		if(obj.getText() != null)newObj.setText(obj.getText());
	}
	
	public Book patchValidation(@Valid Book obj) {
		return obj;
	}

	public Book create(Integer id_cat, Book obj) {
		obj.setId(null);
		Category cat = categoryService.findById(id_cat);
		obj.setCategory(cat);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Book obj = findById(id);
		repository.delete(obj);
	}
}
