package co.edu.uptc.app;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.uptc.control.MovieControl;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieControl mc = new MovieControl();
        ArrayList<String> result = new ArrayList<String>();
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

        result = mc.readFile("Movie");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Movie " + (i + 1));
            System.out.println(result.get(i));
        }

        System.out.println("digite el nombre a buscar para actualizar:");
        String oldName = sc.nextLine();
        System.out.println("digite el nuevo nombre a actualizar:");
        String newName = sc.nextLine();
        mc.updateMovie("Movie", oldName, newName);

        result = mc.readFile("Movie");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Movie " + (i + 1));
            System.out.println(result.get(i));
        }
    }
}
