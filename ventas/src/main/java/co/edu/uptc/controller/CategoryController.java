package co.edu.uptc.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import co.edu.uptc.App;
import co.edu.uptc.model.Category;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CategoryController {

    @FXML
    private TextField category_name;

    //Guardar categoria en el archivo json
    @FXML
    private void saveCategory() throws IOException {
        // Obtener datos del archivo category.fxml
        // Convertir en un objeto de la clase Category del modelo
        // Guardarlo en un archivo json utilizando la librería gson
        // Ejemplo:
        Category category = convertFXMLToCategory();
        Gson gson = new Gson();
        String json = gson.toJson(category);
        FileWriter writer = new FileWriter("ventas\\src\\main\\java\\co\\edu\\uptc\\persistencia\\category.json", true);
        writer.write(json);
        writer.close();
        App.setRoot("view/main");
    }

    //Convertir datos del archivo category.fxml en un objeto de la clase Category
    @FXML
    private Category convertFXMLToCategory() {
        Category category = new Category();
        category.setName(category_name.getText());
        return category;

    }

    //Leer categoría del archivo json
    @FXML
    private void readCategory() throws IOException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("persistencia/category.json"));
        Category category = gson.fromJson(br, Category.class);
        System.out.println(category.getId());
        System.out.println(category.getName());
    }
    
}
