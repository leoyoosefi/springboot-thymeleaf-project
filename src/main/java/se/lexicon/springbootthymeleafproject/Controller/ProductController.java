package se.lexicon.springbootthymeleafproject.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/list")
    public String showAllProduct(){
        return "product/products-view";
    }

    @GetMapping("/form")
    public String productForm(){
        return "product/product-form";
    }

}
