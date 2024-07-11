module co.edu.uptc {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens co.edu.uptc to javafx.fxml;
    opens co.edu.uptc.controller to javafx.fxml; // Abre el paquete controller
    opens co.edu.uptc.model to javafx.fxml; // Abre el paquete view

    exports co.edu.uptc;
    exports co.edu.uptc.controller; // Exporta el paquete controller
    exports co.edu.uptc.model; // Exporta el paquete view
}