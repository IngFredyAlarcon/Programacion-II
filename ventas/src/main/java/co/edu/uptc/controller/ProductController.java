package co.edu.uptc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import co.edu.uptc.model.Product;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class ProductController {

    @FXML
    private TextField product_name;   
    @FXML
    private TextField price;
    @FXML
    private TextField stock;
    @FXML
    private Text productLabel;

    //Guardar producto en el archivo json
    @FXML
    private void saveProduct() throws IOException {
        List<Product> products = readProducts();
        // Asignar un ID único al nuevo producto
        int newId = getNextId(products);

        Product product = convertFXMLToProduct(newId);
        products.add(product);

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("ventas/src/main/java/co/edu/uptc/persistencia/product.json")) {
            gson.toJson(products, writer);
        }
        App.setRoot("view/main");
    }

}
