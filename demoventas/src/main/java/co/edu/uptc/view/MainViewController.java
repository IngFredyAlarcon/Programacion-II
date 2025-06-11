package co.edu.uptc.view;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainViewController {

    @FXML
    private TabPane mainTabPane;
    @FXML
    private ComboBox<String> languageComboBox;

    @FXML
    public void initialize() {
        languageComboBox.getItems().addAll("Español", "English");
        languageComboBox.setValue("Español");

        languageComboBox.setOnAction(e -> {
            String lang = languageComboBox.getValue();
            Locale selectedLocale = lang.equals("English") ? new Locale("en") : new Locale("es");

            ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", selectedLocale);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uptc/view/MainView.fxml"), bundle);
                Parent root = loader.load();
                Stage stage = (Stage) languageComboBox.getScene().getWindow();
                stage.getScene().setRoot(root);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        mainTabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab.getText().equals("Productos")) {
                ProductViewController pvc = ViewControllerRegistry.getProductViewController();
                if (pvc != null) {
                    pvc.refresh();
                }
            }
        });
    }
}
