package se.lexicon.springbootthymeleafproject.service;

import se.lexicon.springbootthymeleafproject.model.dto.CategoryForm;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryView;
import se.lexicon.springbootthymeleafproject.model.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryView findById(int id);
    CategoryView create(CategoryForm form);
    List<CategoryView> findAll();
    boolean delete(int id);

    int categorySize();



}
