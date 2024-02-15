package co.edu.uptc.control;

import java.util.ArrayList;

import co.edu.uptc.model.Movie;
import co.edu.uptc.util.FileManagement;

public class MovieControl {
    private Movie movie;
    private FileManagement fileManagement;

    public boolean addMovie(String name, String genero, String director, int year, String sinopsis, String image) {
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

    public boolean saveMovie(String fileName, String data) {
        fileManagement = new FileManagement();
        if (fileManagement.createFile(fileName)) {
            fileManagement.writeFile(fileName, data);
            return true;
        } else {
            return false;
        }
    }

    public String showInformationMovie() {
        return movie.toString();
    }

    public ArrayList<String> readFile(String fileName) {
        ArrayList<String> result = new ArrayList<>();
        result = fileManagement.readFile(fileName);
        return result;
    }

    public boolean updateMovie(String fileName, String oldData, String newData) {
        movie = new Movie();

        ArrayList<String> result = new ArrayList<>();
        result = fileManagement.readFile(fileName);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).contains("name=" + oldData)) {
                System.out.println("Si contiene el nombre");
                String updatedLine = result.get(i).replace(oldData, newData);
                result.set(i, updatedLine);
            }
        }
        if (fileManagement.createFile(fileName)) {
            for (String line : result) {
                fileManagement.writeFile(fileName, line);
            }
            return true;
        } else {
            return false;
        }
    }
}
