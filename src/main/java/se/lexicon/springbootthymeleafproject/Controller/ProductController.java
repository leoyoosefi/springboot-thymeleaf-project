package se.lexicon.springbootthymeleafproject.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lexicon.springbootthymeleafproject.model.dto.ProductView;
import se.lexicon.springbootthymeleafproject.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String showAllProduct(Model model){
        List<ProductView> productViews = productService.findAll();
        model.addAttribute("productViews", productViews);
        return "product/products-view";
    }

    @GetMapping("/form")
    public String productForm(){
        return "product/product-form";
    }

}
