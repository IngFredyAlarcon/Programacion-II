package co.edu.uptc;

import java.io.IOException;
import javafx.fxm FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}