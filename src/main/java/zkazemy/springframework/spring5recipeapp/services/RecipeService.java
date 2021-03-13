package zkazemy.springframework.spring5recipeapp.services;

import org.springframework.stereotype.Service;
import zkazemy.springframework.spring5recipeapp.commands.RecipeCommand;
import zkazemy.springframework.spring5recipeapp.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);

}
