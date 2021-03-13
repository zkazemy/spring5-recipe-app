package zkazemy.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zkazemy.springframework.spring5recipeapp.domain.Category;
import zkazemy.springframework.spring5recipeapp.domain.UnitOfMeasure;
import zkazemy.springframework.spring5recipeapp.services.RecipeService;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
    public void set()
    {
        String s="";
    }



}
