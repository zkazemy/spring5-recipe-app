package zkazemy.springframework.spring5recipeapp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import zkazemy.springframework.spring5recipeapp.domain.Recipe;
import zkazemy.springframework.spring5recipeapp.repositories.RecipeRepository;
import zkazemy.springframework.spring5recipeapp.services.RecipeService;
import zkazemy.springframework.spring5recipeapp.services.RecipeServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    @InjectMocks
    RecipeController recipeController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        recipeController = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders
                .standaloneSetup(recipeController)
                .build();
    }

    @Test
    void showById() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeService.findById(anyLong())).thenReturn(recipe);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = recipeController.showById(1L,model );

        assertEquals("recipe/show", viewName);
        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("recipe/show"));

    }
}