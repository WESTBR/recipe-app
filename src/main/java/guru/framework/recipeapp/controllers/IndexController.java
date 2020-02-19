package guru.framework.recipeapp.controllers;

import guru.framework.recipeapp.domain.Category;
import guru.framework.recipeapp.domain.UnitOfMeasure;
import guru.framework.recipeapp.repositories.CategoryRepository;
import guru.framework.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/recipe-app")
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String index(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        System.out.println("Cat ID is: " + categoryOptional.get().getId());
        System.out.println("uom ID is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
