package co.edu.uptc.view;

import co.edu.uptc.controller.CategoryController;
import co.edu.uptc.model.Category;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CategoryViewController {

    @FXML private TextField categoryName;
    @FXML private TextField categoryDesc;
    @FXML private TableView<Category> categoryTable;
    @FXML private TableColumn<Category, String> nameCol;
    @FXML private TableColumn<Category, String> descCol;

    private final CategoryController categoryController = new CategoryController();

    @FXML
    public void initialize() {
        categoryTable.setItems(categoryController.getCategories());

        nameCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getName()));
        descCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getDescription()));
    }

    @FXML
    private void handleAddCategory() {
        String name = categoryName.getText();
        String desc = categoryDesc.getText();

        if (name.isEmpty()) return;

        Category category = new Category(0, name, desc);
        categoryController.addCategory(category);

        categoryName.clear();
        categoryDesc.clear();
    }
}
