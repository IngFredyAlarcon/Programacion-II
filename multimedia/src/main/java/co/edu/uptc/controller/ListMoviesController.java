package co.edu.uptc.controller;

import java.io.IOException;

import co.edu.uptc.App;
import co.edu.uptc.model.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListMoviesController {
    @FXML
    private TableView<Movie> tableView;

    @FXML
    private TableColumn<Movie, String> nameColumn;

    @FXML
    private TableColumn<Movie, String> directorColumn;

    @FXML
    private TableColumn<Movie, Integer> yearColumn;

    public void initialize() {
        // Configurar las columnas
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        // Obtener las películas del controlador MovieController
        CreateMovieController createMovieController = new CreateMovieController();
        tableView.setItems(createMovieController.getMovies());
    }

    @FXML
    private void showFormCreateMovie() throws IOException {
        App.setRoot("createMovie");
    }
}
