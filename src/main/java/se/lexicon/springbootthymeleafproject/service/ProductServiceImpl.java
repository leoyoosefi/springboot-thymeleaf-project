package se.lexicon.springbootthymeleafproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.springbootthymeleafproject.model.dto.ProductView;
import se.lexicon.springbootthymeleafproject.model.entity.Product;
import se.lexicon.springbootthymeleafproject.model.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductView> findAll() {
        List<Product> productList = productRepository.findAll();
        return null;
    }
}
