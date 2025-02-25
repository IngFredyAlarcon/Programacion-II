package co.edu.uptc.app;

import java.util.List;
import java.util.Scanner;

import co.edu.uptc.control.MovieControl;
import co.edu.uptc.model.Movie;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MovieControl mc = new MovieControl();
        String name, genero, director, sinopsis, image;
        int year;
        System.out.println("enter the Name");
        name = sc.nextLine();
        System.out.println("enter the Genero");
        genero = sc.nextLine();
        System.out.println("enter the Director");
        director = sc.nextLine();
        System.out.println("enter the Sinopsis");
        sinopsis = sc.nextLine();
        System.out.println("enter the url image");
        image = sc.nextLine();
        System.out.println("enter the Year");
        year = sc.nextInt();
        sc.nextLine();

        if (mc.addMovie(name, genero, director, year, sinopsis, image)) {
            System.out.println("Movie add successfull");
            mc.saveMovie("Movie", mc.showInformationMovie());
        } else {
            System.out.println("Error");
        }

        List<Movie> movies = mc.getMoviesFromFile("Movie");

        for (Movie movie : movies) {
            System.out.println(movie);
        }

    }
}
