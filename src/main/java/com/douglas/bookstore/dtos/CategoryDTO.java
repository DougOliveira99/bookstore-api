package com.douglas.bookstore.dtos;

import java.io.Serializable;

import com.douglas.bookstore.domain.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;
	
	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Category obj) {
		super();
		id = obj.getId();
		name = obj.getName();
		description = obj.getDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
