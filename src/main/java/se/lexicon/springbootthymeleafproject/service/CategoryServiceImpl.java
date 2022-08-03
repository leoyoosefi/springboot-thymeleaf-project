package se.lexicon.springbootthymeleafproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryForm;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryView;
import se.lexicon.springbootthymeleafproject.model.entity.Category;
import se.lexicon.springbootthymeleafproject.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }




    @Override
    public Category findById(int id) {
        if (id == 0) throw new IllegalArgumentException("id not valid");
        Optional<Category> categoryEntity = repository.findById(id);
        if (categoryEntity.isPresent()) {
            return categoryEntity.get();
        }
        else {
            return null;
        }
    }

    @Override
    public CategoryView create(CategoryForm form) {
        return null;
    }

    @Override
    public List<CategoryView> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
