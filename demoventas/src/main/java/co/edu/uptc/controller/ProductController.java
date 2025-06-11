package co.edu.uptc.controller;

import co.edu.uptc.model.Product;
import co.edu.uptc.persistence.ProductRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductController {
    private final ProductRepository repository;
    private final ObservableList<Product> products;

    public ProductController() {
        repository = new ProductRepository();
        products = FXCollections.observableArrayList(repository.load());
    }

    public ObservableList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        repository.save(products);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        repository.save(products);
    }

    public void updateProducts() {
        repository.save(products);
    }

    public int nextIdProducts(){
        int maxId = 0;
        for (Product product : products) {
            if (maxId<product.getId()) {
                maxId = product.getId();
            }
        }
        return maxId+1;
    }
}

