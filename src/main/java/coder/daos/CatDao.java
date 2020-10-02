package coder.daos;

import coder.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CatDao {

List<Category> getAllCategory();

void addCat(Category category);

Category getCatById(int id);

void updateCategory(Category category);

void deleteCategory(int id);

}
