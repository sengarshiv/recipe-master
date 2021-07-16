package com.recipe.master.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.master.app.model.Recipe;
import com.recipe.master.app.service.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;

	@GetMapping(value = "/recipe", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getRecipes() {
		List<Recipe> lst = recipeService.getRecipes();

		return new ResponseEntity<>(lst, HttpStatus.OK);
	}

	@GetMapping(value = "/recipe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getRecipesById(@PathVariable("id") String id) {
		Recipe recipe = recipeService.getRecipeById(id);

		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@PostMapping(value = "/recipe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addRecipe(RequestEntity<Recipe> recipe) {

		Recipe rc = recipeService.addRecipe(recipe.getBody());
		return new ResponseEntity<Recipe>(rc, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/recipe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteRecipe(@PathVariable("id") String id) {
		recipeService.deleteRecipe(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping(value="/recipe/search/{keyword}")
	public ResponseEntity<?> searchRecipe(@PathVariable("keyword") String keyword) {
		return new ResponseEntity<>(recipeService.searchRecipe(keyword), HttpStatus.OK);
	}

}
