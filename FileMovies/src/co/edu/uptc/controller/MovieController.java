package co.edu.uptc.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Movie;
import co.edu.uptc.util.FileManagement;

public class MovieController {
    Movie movie;
    FileManagement fm;

    public boolean createMovie(String title, int year, String genre, String synopsis) {
        movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setGenre(genre);
        movie.setSynopsis(synopsis);
        if (movie.getTitle().equals(title) && movie.getYear() == year && movie.getGenre().equals(genre)
                && movie.getSynopsis().equals(synopsis)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean saveInformationMovie(String fileName, String data) {
        fm = new FileManagement();
        if (fm.createFile(fileName)) {
            fm.writeFile(fileName, data);
            return true;
        } else {
            return false;
        }
    }

    public String showInformationMovie() {
        return movie.toString();
    }

    public List<Movie> getMoviesFromFile(String fileName) {
        fm = new FileManagement();
        List<String> lines = fm.readFile(fileName);
        List<Movie> movies = new ArrayList<>();
        for (String line : lines) {
            Movie movie = parseMovie(line);
            if (movie != null) {
                movies.add(movie);
            }
        }
        return movies;
    }

    private Movie parseMovie(String line) {
        if (line.startsWith("Movie")) {
            Movie movie = new Movie();
            String[] parts = line.substring(line.indexOf("[") + 1, line.indexOf("]")).split(", ");
            for (String part : parts) {
                String[] keyValue = part.split("=");
                switch (keyValue[0]) {
                    case "title":
                        movie.setTitle(keyValue[1]);
                        break;
                    case "year":
                        movie.setYear(Integer.parseInt(keyValue[1]));
                        break;
                    case "genre":
                        movie.setGenre(keyValue[1]);
                        break;
                    case "synopsis":
                        movie.setSynopsis(keyValue[1]);
                        break;
                }
            }
            return movie;
        }
        return null;
    }
}
