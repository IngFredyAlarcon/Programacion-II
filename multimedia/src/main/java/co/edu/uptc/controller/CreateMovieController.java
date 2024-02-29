package co.edu.uptc.controller;

import java.io.IOException;

import co.edu.uptc.App;
import co.edu.uptc.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateMovieController {

    @FXML
    private TextField movieName;

    @FXML
    private TextField movieDirector;

    @FXML
    private TextField movieYear;

    @FXML
    private Button saveMovieButton;

    private ObservableList<Movie> movies = FXCollections.observableArrayList();

    public boolean createMovie(String name, String director, int year) {
        Movie movie = new Movie(name, director, year);
        try {
            movies.add(movie);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ObservableList<Movie> getMovies() {
        return movies;
    }

    @FXML
    private boolean saveMovie() throws IOException {
        Movie movie = new Movie(movieName.getText(), movieDirector.getText(), Integer.parseInt(movieYear.getText()));
        try {
            movies.add(movie);
        } catch (Exception e) {
            return false;
        }

        // Clean fields in case of success
        movieName.clear();
        movieDirector.clear();
        movieYear.clear();

        App.setRoot("listMovies");
        return true;
    }

    @FXML
    private void showFormCreateMovie() throws IOException {

        App.setRoot("createMovie");
    }
}
