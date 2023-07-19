package co.edu.uptc.model;

import java.util.ArrayList;

public class Bag<T> {
    private ArrayList<T> products = new ArrayList<T>();

    public void add(T objeto) {
        products.add(objeto);
    }

    public ArrayList<T> getProducts() {
        return products;
    }
}
