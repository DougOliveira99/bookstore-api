package com.douglas.bookstore.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.douglas.bookstore.domain.Book;
import com.douglas.bookstore.domain.Category;
import com.douglas.bookstore.repositories.BookRepository;
import com.douglas.bookstore.repositories.CategoryRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Computers", "IT books");

		Book b1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);

		cat1.getBooks().addAll(Arrays.asList(b1));
		
		categoryRepository.saveAll(Arrays.asList(cat1));
		bookRepository.saveAll(Arrays.asList(b1));
	}
}
