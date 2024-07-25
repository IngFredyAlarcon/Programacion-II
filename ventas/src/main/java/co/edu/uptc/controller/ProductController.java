package co.edu.uptc.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import co.edu.uptc.App;
import co.edu.uptc.model.Category;
import co.edu.uptc.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ProductController {

    @FXML
    private TextField product_name;
    @FXML
    private TextField product_price;
    @FXML
    private TextField product_stock;
    @FXML
    private ComboBox<String> comboboxCategory;

    private List<Category> categories;

    // Inicializar el ComboBox con las categorías del archivo JSON
    @FXML
    public void initialize() throws JsonIOException, JsonSyntaxException, IOException {
        categories = readCategories();
        for (Category category : categories) {
            comboboxCategory.getItems().add(category.getName());
        }
    }

    private List<Category> readCategories() throws JsonIOException, JsonSyntaxException, IOException {
        List<Category> categories = new ArrayList<>();
        Gson gson = new Gson();
        String filePath = "ventas/src/main/java/co/edu/uptc/persistencia/category.json";

        // Comprobar si el archivo existe y no está vacío
        if (Files.exists(Paths.get(filePath)) && Files.size(Paths.get(filePath)) > 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                Type listType = new TypeToken<ArrayList<Category>>() {}.getType();
                categories = gson.fromJson(br, listType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return categories;
    }

    private List<Product> readProducts() throws JsonIOException, JsonSyntaxException, IOException {
        List<Product> products = new ArrayList<>();
        Gson gson = new Gson();
        String filePath = "ventas/src/main/java/co/edu/uptc/persistencia/product.json";

        // Comprobar si el archivo existe y no está vacío
        if (Files.exists(Paths.get(filePath)) && Files.size(Paths.get(filePath)) > 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                Type listType = new TypeToken<ArrayList<Product>>() {}.getType();
                products = gson.fromJson(br, listType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    //Guardar categoria en el archivo json
    @FXML
    private void saveProduct() throws IOException {
        List<Product> products = readProducts();
        // Asignar un ID único a la nueva categoría
        int newId = getNextId(products);

        Product product = convertFXMLToProduct(newId);
        products.add(product);

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("ventas/src/main/java/co/edu/uptc/persistencia/product.json")) {
            gson.toJson(products, writer);
        }
        App.setRoot("view/main");
    }

    // Obtener el siguiente ID único y consecutivo
    private int getNextId(List<Product> products) {
        int maxId = 0;
        for (Product product : products) {
            if (product.getId() > maxId) {
                maxId = product.getId();
            }
        }
        return maxId + 1;
    }

    //Convertir datos del archivo product.fxml en un objeto de la clase Product
    @FXML
    private Product convertFXMLToProduct(int newId) {
        Product product = new Product();
        product.setId(newId);
        product.setName(product_name.getText());
        product.setPrice(Double.parseDouble(product_price.getText()));
        product.setStock(Integer.parseInt(product_stock.getText()));
        String selectedCategoryName = comboboxCategory.getValue();
        
        //ojo con se busca por nombre en especial por las tildes
        Category selectedCategory = categories.stream()
                .filter(category -> category.getName().equals(selectedCategoryName))
                .findFirst()
                .orElse(null);
        product.setCategory(selectedCategory);
        return product;

    }
}
