module co.edu.uptc {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens co.edu.uptc to javafx.fxml;

    exports co.edu.uptc;
}
