package se.lexicon.springbootthymeleafproject.converter;

import org.springframework.stereotype.Component;
import se.lexicon.springbootthymeleafproject.model.dto.CategoryView;
import se.lexicon.springbootthymeleafproject.model.entity.Category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CategoryConverter implements Converter<Category, CategoryView> {


    @Override
    public CategoryView toView(Category entity) {

        return new CategoryView(
        entity.getId(),
        entity.getName(),
        entity.getCreateDate());
    }

    @Override
    public Category toEntity(CategoryView view) {
        return new Category(view.getId(), view.getCategoryName(), view.getCreateDate()
        );
    }

    @Override
    public Collection<CategoryView> toViews(Collection<Category> entities) {

        return entities.stream().map(this::toView).collect(Collectors.toList());
    }

    @Override
    public Collection<Category> toEntities(Collection<CategoryView> views) {
        return views.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
