package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.interfaces.IProduct;

public class ProductDAO implements IProduct {

    private List<Product> products;

    public ProductDAO() {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        for (Product p : products) {
            if (p.getName().equals(product.getName())) {
                p.setDescription(product.getDescription());
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setStock(product.getStock());
            }
        }
    }

}

   