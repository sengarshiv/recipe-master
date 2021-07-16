package com.recipe.master.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.master.app.model.Recipe;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {
	
	@Query("{'name':{'$regex':'?0','$options':'i'},'description':{'$regex':'?0','$options':'i'}}")
	public List<Recipe> getRecipeByFuzzySearch(String matchWord);

}
