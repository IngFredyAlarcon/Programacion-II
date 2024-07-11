package co.edu.uptc.controller;

import java.io.IOException;

import co.edu.uptc.App;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    public void switchToCategory() throws IOException {
        System.out.println("Switching to category");
        App.setRoot("view/category");
    }
    
    @FXML
    public void switchToProduct() throws IOException {
        System.out.println("Switching to product");
        App.setRoot("view/product");
    }
    
}
