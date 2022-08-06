package se.lexicon.springbootthymeleafproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.springbootthymeleafproject.converter.ProductConverter;
import se.lexicon.springbootthymeleafproject.model.dto.ProductView;
import se.lexicon.springbootthymeleafproject.model.entity.Product;
import se.lexicon.springbootthymeleafproject.model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;
    ProductConverter productConverter;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @Override
    public List<ProductView> findAll() {
        List<Product> productList = productRepository.findAll();
        Collection<ProductView> productViewList = productConverter.toViews(productList);
        return new ArrayList<>(productViewList);
    }
}
