package se.lexicon.springbootthymeleafproject.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryForm;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    static List<CategoryView> categoryViews = new ArrayList<>(Arrays.asList(
           // new CategoryView(1, "Book", LocalDate.now()),
          //  new CategoryView(2, "Shovel", LocalDate.now()),
           // new CategoryView(3, "Meatball", LocalDate.now())
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

    @PostMapping("/view")
    public String findByIdPost(@RequestParam("id") Integer id, Model model){
        System.out.println("ID: " + id);
        CategoryView categoryView = categoryViews.stream().filter(category -> category.getId() == id).findFirst().orElse(null);
        model.addAttribute("categoryView", categoryView);
        return "category/category-view";

    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        System.out.println("ID: " + id);
        categoryViews.removeIf(categoryView1 -> categoryView1.getId() == id);
        redirectAttributes.addFlashAttribute("message", "Category Id"+id+"is removed");
        redirectAttributes.addFlashAttribute("alertClass", "alert alert-info");
        return "redirect:/category/list";
    }
    @GetMapping("/form")
    public String categoryForm(Model model){

        CategoryForm categoryForm = new CategoryForm();
        model.addAttribute("category",categoryForm );

        return "category/category-form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("category")@Valid CategoryForm categoryForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {
        System.out.println("categoryForm =" + categoryForm);

        if (bindingResult.hasErrors()){
            return "category/category-form";
        }

        int randomId = (int) (Math.random() * 100);
        CategoryView categoryView = new CategoryView(randomId, categoryForm.getName(),LocalDate.now());
        categoryViews.add(categoryView);

        redirectAttributes.addFlashAttribute("message", "Category name " + categoryView.getCategoryName() + "is successfully added");
        redirectAttributes.addFlashAttribute("alertClass", "alert alert-info");

        //Custom Error
        //throw new IllegalArgumentException("custom exception");

        return "redirect:/category/list";

    }







}
