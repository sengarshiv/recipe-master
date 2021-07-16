package com.recipe.master.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.master.app.model.Recipe;
import com.recipe.master.app.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	RecipeRepository recipeRepository;

	public List<Recipe> getRecipes() {
		return recipeRepository.findAll();
	}

	public Recipe getRecipeById(String id) {
		return recipeRepository.findById(id).get();
	}

	public Recipe addRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public void deleteRecipe(String id) {
		recipeRepository.deleteById(id);
	}

	public List<Recipe> searchRecipe(String keyword) {
		return recipeRepository.getRecipeByFuzzySearch(keyword);
	}

}