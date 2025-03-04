package co.edu.uptc.interfaces;

import java.util.List;

import co.edu.uptc.model.Product;

public interface IProduct {
    void addProduct(Product product);
    void removeProduct(Product product);
    void updateProduct(Product product);
    List<Product> getProducts();
}
