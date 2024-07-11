package co.edu.uptc.controller;

import java.io.IOException;

import co.edu.uptc.App;

public class ProductController {

    private void switchToMain() throws IOException {
        System.out.println("Switching to main");
        App.setRoot("main");
    }
}
