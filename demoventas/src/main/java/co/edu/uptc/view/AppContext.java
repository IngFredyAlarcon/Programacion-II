package co.edu.uptc.view;

import co.edu.uptc.controller.CategoryController;
import co.edu.uptc.controller.ProductController;

public class AppContext {
    private static final CategoryController categoryController = new CategoryController();
    private static final ProductController productController = new ProductController();

    public static CategoryController getCategoryController() {
        return categoryController;
    }

    public static ProductController getProductController() {
        return productController;
    }
}
