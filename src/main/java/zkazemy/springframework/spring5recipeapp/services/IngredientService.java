package zkazemy.springframework.spring5recipeapp.services;

import zkazemy.springframework.spring5recipeapp.commands.IngredientCommand;
import zkazemy.springframework.spring5recipeapp.domain.Ingredient;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long id);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(Long recipeId, Long idToDelete);
}
