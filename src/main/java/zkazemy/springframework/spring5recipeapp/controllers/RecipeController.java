package zkazemy.springframework.spring5recipeapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zkazemy.springframework.spring5recipeapp.commands.RecipeCommand;
import zkazemy.springframework.spring5recipeapp.domain.Recipe;
import zkazemy.springframework.spring5recipeapp.exceptions.NotFoundException;
import zkazemy.springframework.spring5recipeapp.services.RecipeService;

@Controller
public class RecipeController {
    private final RecipeService recipeService;
    private static final String RECIPE_RECIPEFORM_URL = "recipe/recipeform";

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", recipeService.findById(id));
        return "recipe/show";
    }

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model)
    {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }

//    @RequestMapping(name="recipe", method = RequestMethod.POST)
//or
@PostMapping("recipe")
public String saveOrUpdate( @ModelAttribute("recipe") RecipeCommand command, BindingResult bindingResult){

    if(bindingResult.hasErrors()){

        bindingResult.getAllErrors().forEach(objectError -> {
//            log.debug(objectError.toString());
        });

        return RECIPE_RECIPEFORM_URL;
    }

    RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

    return "redirect:/recipe/" + savedCommand.getId() + "/show";
}

    @GetMapping
    @RequestMapping("recipe/{id}/delete")
    public String delete(@PathVariable String id)
    {
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)//mange exception inner a controller
    public ModelAndView handleNotFound()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404error");
        return modelAndView;
    }


}
