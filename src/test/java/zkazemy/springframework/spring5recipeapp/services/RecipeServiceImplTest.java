package zkazemy.springframework.spring5recipeapp.services;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import zkazemy.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import zkazemy.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import zkazemy.springframework.spring5recipeapp.domain.Recipe;
import zkazemy.springframework.spring5recipeapp.exceptions.NotFoundException;
import zkazemy.springframework.spring5recipeapp.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by jt on 6/17/17.
 */
public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void getRecipesTest() throws Exception {

        Recipe recipe = new Recipe();
        HashSet receipesData = new HashSet();
        receipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(receipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }


    @Test
    public void testDeleteById()
    {
        Long idToDelete = Long.valueOf(2L);
        recipeService.deleteById(idToDelete);
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdTestNotFound() throws Exception
    {
        Optional<Recipe> recipeOptional = Optional.empty();
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
         Recipe recipe= recipeService.findById(1L);

    }

}