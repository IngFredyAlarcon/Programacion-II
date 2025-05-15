package co.edu.uptc.controller;

public class AppController {
    private final ProductController productController;
    private final CategoryController categoryController;

    public AppController() {
        productController = new ProductController();
        categoryController = new CategoryController();
    }

    public ProductController getProductController() {
        return productController;
    }

    public CategoryController getCategoryController() {
        return categoryController;
    }
}
