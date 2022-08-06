package se.lexicon.springbootthymeleafproject.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootthymeleafproject.model.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Override
    List<Product> findAll();

    List<Product> findAllByNameIgnoreCase(String name);

}
