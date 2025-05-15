package co.edu.uptc.view;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class MainViewController {

    @FXML
    private TabPane mainTabPane;

    @FXML
    public void initialize() {
        mainTabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab.getText().equals("Productos")) {
                // Recuperar el controlador de ProductView y llamar a refresh
                ProductViewController pvc = ViewControllerRegistry.getProductViewController();
                if (pvc != null) {
                    pvc.refresh();
                }
            }
        });
    }
}
