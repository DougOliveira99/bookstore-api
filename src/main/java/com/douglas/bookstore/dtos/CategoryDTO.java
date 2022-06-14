package com.douglas.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.douglas.bookstore.domain.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Field NAME can't be empty!")
	@Length(min = 3, max = 100, message = "Field NAME must have at least 3 characters and max 100!")
	private String name;
	
	@NotEmpty(message = "Field DESCRIPTION can't be empty!")
	@Length(min = 3, max = 200, message = "Field DESCRIPTION must have at least 3 characters and max 200!")
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
