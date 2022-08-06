package se.lexicon.springbootthymeleafproject.service;

import se.lexicon.springbootthymeleafproject.model.dto.ProductView;
import se.lexicon.springbootthymeleafproject.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductView> findAll();
}
