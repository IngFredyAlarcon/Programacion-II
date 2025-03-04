package co.edu.uptc.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Product;
import co.edu.uptc.model.ProductDAO;

public class ProductController {
    Product product;
    ProductDAO productDAO;

    public ProductController() {
        productDAO = new ProductDAO();
    }

    public boolean createProduct(String name, String description, double price, int stock) {
        product = new Product(name, description, price, stock);
        productDAO.addProduct(product);
        return true;
    }

    public boolean updateProduct(String name, String description, double price, int stock) {
        product = new Product(name, description, price, stock);
        productDAO.updateProduct(product);
        return true;
    }

    public boolean deleteProduct() {
        productDAO.removeProduct(product);
        return true;
    }

    public List<Product> listProducts() {
        return productDAO.getProducts();
    }

    

}
