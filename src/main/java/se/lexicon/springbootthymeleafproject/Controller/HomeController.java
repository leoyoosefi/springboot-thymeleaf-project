package se.lexicon.springbootthymeleafproject.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/index", "/home"})
    public String index(){
        System.out.println("index method executed");
        return "index";
    }




}
