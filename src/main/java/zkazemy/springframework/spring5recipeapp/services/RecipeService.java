package zkazemy.springframework.spring5recipeapp.services;

import zkazemy.springframework.spring5recipeapp.commands.RecipeCommand;
import zkazemy.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    void deleteById(Long id);
    RecipeCommand findCommandById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);

}
