package se.lexicon.springbootthymeleafproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryView;
import se.lexicon.springbootthymeleafproject.model.dto.ProductView;
import se.lexicon.springbootthymeleafproject.model.entity.Product;

import java.util.Collection;

@Component
public class ProductConverter implements Converter<Product, ProductView>{

    CategoryConverter categoryConverter;

    @Autowired
    public ProductConverter(CategoryConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    @Override
    public ProductView toView(Product entity) {
        CategoryView categoryView = categoryConverter.toView(entity.getCategory());
        ProductView view = new ProductView(entity.getId(), entity.getName(), entity.getPrice(), categoryView,entity.getDate());
        return view;
    }

    @Override
    public Product toEntity(ProductView view) {
        return null;
    }

    @Override
    public Collection<ProductView> toViews(Collection<Product> entities) {
        return null;
    }

    @Override
    public Collection<Product> toEntities(Collection<ProductView> views) {
        return null;
    }
}
