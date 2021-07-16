package com.recipe.master.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Recipe {

	public Recipe() {

	}

	public Recipe(String name, String description, String recipe) {
		super();
		this.name = name;
		this.description = description;
		this.recipe = recipe;
	}

	@Id
	private String id;

	private String name = "";

	private String description = "";

	private String recipe = "";

}
