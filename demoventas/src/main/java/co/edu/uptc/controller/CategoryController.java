package co.edu.uptc.controller;

import co.edu.uptc.model.Category;
import co.edu.uptc.persistence.CategoryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategoryController {
    private final CategoryRepository repository;
    private final ObservableList<Category> categories;

    public CategoryController() {
        repository = new CategoryRepository();
        categories = FXCollections.observableArrayList(repository.load());
    }

    public ObservableList<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
        repository.save(categories);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
        repository.save(categories);
    }

    public void updateCategories() {
        repository.save(categories);
    }

    public int nextIdCategories(){
        int maxId = 0;
        for (Category category : categories) {
            if (maxId<category.getId()) {
                maxId = category.getId();
            }
        }
        return maxId+1;
    }
}
