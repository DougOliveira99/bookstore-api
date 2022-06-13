package com.douglas.bookstore.dtos;

import java.io.Serializable;

import com.douglas.bookstore.domain.Book;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	
	public BookDTO() {
		super();
	}
	
	public BookDTO(Book obj) {
		super();
		id = obj.getId();
		title = obj.getTitle();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
