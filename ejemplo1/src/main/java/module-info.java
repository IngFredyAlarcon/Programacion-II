module co.edu.uptc {
    requires transitive javafx.controls;
    requires javafx.fx ;

    opens co.edu.uptc to javafx.fxml;

    exports co.edu.uptc;
}
