package se.lexicon.springbootthymeleafproject.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("currentDate",currentDate);

        model.addAttribute("productsListSize", 2);
        model.addAttribute("categoryListSize", 11);
        model.addAttribute("userListSize", 5);

        return "dashboard";
    }

}
