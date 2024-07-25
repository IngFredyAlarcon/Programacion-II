package co.edu.uptc.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import co.edu.uptc.App;
import co.edu.uptc.model.Category;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CategoryController {

    @FXML
    private TextField category_name;
    @FXML
    private TextField category_description;

    //Guardar categoria en el archivo json
    @FXML
    private void saveCategory() throws IOException {
        List<Category> categories = readCategories();
        // Asignar un ID único a la nueva categoría
        int newId = getNextId(categories);

        Category category = convertFXMLToCategory(newId);
        categories.add(category);

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("ventas/src/main/java/co/edu/uptc/persistencia/category.json")) {
            gson.toJson(categories, writer);
        }
        App.setRoot("view/main");
    }

    //Convertir datos del archivo category.fxml en un objeto de la clase Category
    @FXML
    private Category convertFXMLToCategory(int newId) {
        Category category = new Category();
        category.setId(newId);
        category.setName(category_name.getText());
        category.setDescription(category_description.getText());
        return category;

    }

    //Leer todas las categorías del archivo json
    @FXML
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

    // Obtener el siguiente ID único y consecutivo
    private int getNextId(List<Category> categories) {
        int maxId = 0;
        for (Category category : categories) {
            if (category.getId() > maxId) {
                maxId = category.getId();
            }
        }
        return maxId + 1;
    }
    
}
