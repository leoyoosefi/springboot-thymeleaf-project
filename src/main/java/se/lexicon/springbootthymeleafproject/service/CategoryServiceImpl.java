package se.lexicon.springbootthymeleafproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.springbootthymeleafproject.converter.CategoryConverter;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryForm;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryView;
import se.lexicon.springbootthymeleafproject.model.entity.Category;
import se.lexicon.springbootthymeleafproject.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    CategoryRepository repository;
    CategoryConverter converter;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, CategoryConverter converter) {
        this.converter = converter;
        this.repository = repository;
    }




    @Override
    public Category findById(int id) {
        if (id == 0) throw new IllegalArgumentException("id not valid");
        Optional<Category> categoryOptional = repository.findById(id);
        if(categoryOptional.isPresent()){
            Category categoryEntity = categoryOptional.get();


            CategoryView categoryView = converter.toView(categoryEntity);
            return categoryEntity;
        }else{ return null;
    }}

    @Override
    public CategoryView create(CategoryForm form) {
        if(form == null) throw new IllegalArgumentException("form is null");
        Category convertedEntity = new Category(form.getName());
        Category createCategory = repository.save(convertedEntity);

        CategoryView convertToView = converter.toView(createCategory);

        return convertToView;
    }

    @Override
    public List<CategoryView> findAll() {
        List<Category> entities = repository.findAll();
        return new ArrayList<>(converter.toViews(entities));
    }

    @Override
    public boolean delete(int id) {
        if(findById(id) != null){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public int categorySize() {
        return findAll().size();
    }
}
