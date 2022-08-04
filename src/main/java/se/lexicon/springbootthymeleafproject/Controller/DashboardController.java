package se.lexicon.springbootthymeleafproject.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryView;
import se.lexicon.springbootthymeleafproject.service.CategoryService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DashboardController {

    CategoryService categoryService;

    @Autowired
    public DashboardController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("currentDate",currentDate);


        model.addAttribute("productsListSize", 2);
        model.addAttribute("categoryListSize", categoryService.categorySize());
        model.addAttribute("userListSize", 5);

        return "dashboard";
    }

}
