package se.lexicon.springbootthymeleafproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.springbootthymeleafproject.model.entity.Category;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Optional<Category> findAllByName(String categoryName);
    List<Category>findAll();

}
