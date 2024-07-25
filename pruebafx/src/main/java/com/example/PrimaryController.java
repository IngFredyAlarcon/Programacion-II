package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Secondary.fxml"));
        Parent root = loader.load();
        // Obtener el controlador de la segunda escena
        SecondaryController secondaryController = loader.getController();
        // Pasar datos a la segunda escena
        secondaryController.initData("Hola mundo");

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
