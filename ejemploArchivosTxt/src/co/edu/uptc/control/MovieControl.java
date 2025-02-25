package co.edu.uptc.control;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Movie;
import co.edu.uptc.util.FileManagement;

public class MovieControl {
    private Movie movie;
    private FileManagement fileManagement;

    public boolean addMovie(String name, String genero, String director, int year, String sinopsis, String image){
        movie = new Movie();
        movie.setName(name);
        movie.setGenero(genero);
        movie.setDirector(director);
        movie.setYear(year);
        movie.setSinopsis(sinopsis);
        movie.setImage(image);

        if (movie.getName().equals(name) && movie.getGenero().equals(genero) && movie.getDirector().equals(director)
                && movie.getYear() == year && movie.getSinopsis().equals(sinopsis) && movie.getImage().equals(image)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean saveMovie(String fileName, String data){
        fileManagement = new FileManagement();
        if(fileManagement.createFile(fileName)){
            fileManagement.writeFile(fileName, data);
            return true;
        } else{
            return false;
        }
    }

    public String showInformationMovie() {
        return movie.toString();
    }

    public List<Movie> getMoviesFromFile(String fileName) {
        fileManagement = new FileManagement();
        List<String> lines = fileManagement.readFile(fileName);
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
                    case "name":
                        movie.setName(keyValue[1]);
                        break;
                    case "year":
                        movie.setYear(Integer.parseInt(keyValue[1]));
                        break;
                    case "genre":
                        movie.setGenero(keyValue[1]);
                        break;
                    case "synopsis":
                        movie.setSinopsis(keyValue[1]);
                        break;
                }
            }
            return movie;
        }
        return null;
    }
}
