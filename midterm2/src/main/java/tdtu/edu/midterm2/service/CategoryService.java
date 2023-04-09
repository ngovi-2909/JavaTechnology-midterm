package tdtu.edu.midterm2.service;

import tdtu.edu.midterm2.model.Category;
import tdtu.edu.midterm2.model.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategory();
    Category addCategory(Category category);
    void removeCategoryById(long id);
    Optional<Category> getCategoryById(long id);
}
