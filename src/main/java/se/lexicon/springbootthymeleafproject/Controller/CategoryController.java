package se.lexicon.springbootthymeleafproject.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    static List<CategoryView> categoryViews = new ArrayList<>(Arrays.asList(
            new CategoryView(1, "Book", LocalDate.now()),
            new CategoryView(2, "Shovel", LocalDate.now()),
            new CategoryView(3, "Meatball", LocalDate.now())
    ));


    @GetMapping("/list")
    public String ShoAllList(Model model){



        model.addAttribute("categoryViews", categoryViews);
        return "category/categories-view";
    }
    @GetMapping("/view/{id}")
    public String findById(@PathVariable("id") Integer id, Model model){
        System.out.println("ID: " + id);
        CategoryView categoryView = categoryViews.stream().filter(category -> category.getId() == id).findFirst().orElse(null);
        model.addAttribute("categoryView", categoryView);
        return "category/category-view";

    }



}
