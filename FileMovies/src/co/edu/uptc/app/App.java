package co.edu.uptc.app;

import java.util.List;
import java.util.Scanner;

import co.edu.uptc.controller.MovieController;
import co.edu.uptc.model.Movie;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MovieController movieController = new MovieController();
        String title, genre, synopsis;
        int year;
        System.out.println("input the movie title");
        title = sc.nextLine();
        System.out.println("input the movie year");
        year = sc.nextInt();
        sc.nextLine();
        System.out.println("input the movie genre");
        genre = sc.nextLine();
        System.out.println("input the movie synopsis");
        synopsis = sc.nextLine();

        if(movieController.createMovie(title, year, genre, synopsis)){
            if(movieController.saveInformationMovie("movies", movieController.showInformationMovie())){
                System.out.println("The movie was created successfully");
            }
            else {
                System.out.println("The movie was not created");
            }
        }
        else {
            System.out.println("The movie was not created");
        }

        List<Movie> movies = movieController.getMoviesFromFile("movies");

        for (Movie movie : movies) {
            System.out.println(movie);
        }

    }
}
