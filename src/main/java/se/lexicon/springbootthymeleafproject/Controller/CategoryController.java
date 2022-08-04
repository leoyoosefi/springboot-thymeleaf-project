package se.lexicon.springbootthymeleafproject.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryForm;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryView;
import se.lexicon.springbootthymeleafproject.model.entity.Category;
import se.lexicon.springbootthymeleafproject.service.CategoryService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String ShoAllList(Model model){



        model.addAttribute("categoryViews", service.findAll());
        return "category/categories-view";
    }
    @GetMapping("/view/{id}")
    public String findById(@PathVariable("id") Integer id, Model model){
        System.out.println("ID: " + id);

        model.addAttribute("categoryView", service.findById(id));
        return "category/category-view";

    }

    @PostMapping("/view")
    public String findByIdPost(@RequestParam("id") Integer id, Model model){
        System.out.println("id = " + id);

        CategoryView categoryView = service.findById(id);

        model.addAttribute("categoryView", categoryView);
        return "category/category-view";

    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        System.out.println("ID:" + id);
        boolean result = service.delete(id);
        if (result) {
            redirectAttributes.addFlashAttribute("message", "Category Id " + id + " was successfully deleted");
            redirectAttributes.addFlashAttribute("alertClass", "alert alert-info");
        } else {

        }

        return "redirect:/category/list";
    }

    @GetMapping("/form")
    public String categoryForm(Model model) {

        CategoryForm categoryForm = new CategoryForm();
        model.addAttribute("form", categoryForm);

        return "category/category-form";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("form") @Valid CategoryForm categoryForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("categoryForm = " + categoryForm);

        if (bindingResult.hasErrors()) {
            return "category/category-form";
        }

        CategoryView createdCategory = service.create(categoryForm);

        redirectAttributes.addFlashAttribute("message", "Category  name " + createdCategory.getCategoryName() + " was successfully added");
        redirectAttributes.addFlashAttribute("alertClass", "alert alert-info");


        return "redirect:/category/list";
    }
}
