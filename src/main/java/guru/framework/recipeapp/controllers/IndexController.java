package guru.framework.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe-app")
public class IndexController {


    @RequestMapping({"","/","/index"})
    public String index(){
        System.out.println("some message her test");
        return "index";
    }
}
