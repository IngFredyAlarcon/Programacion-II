package co.edu.uptc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AppPerson {
    public static void main(String[] args){
        final String json = "{\"id\":46,\"firstName\":\"Denna\",\"lastName\":\"Crosio\"}";
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File("demogson\\src\\data.json");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado en la ruta: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // bloque con un String definido
        // final Gson gson = new Gson();
        // final Person person = gson.fromJson(json, Person.class);
        // System.out.println(showPerson(person));
        // System.out.println(showPersonProperties(person));

        // bloque con un String construido desde un archivo
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        final Gson gson = new Gson();
        final Gson gson2 = gb.create();
        final Person person = gson.fromJson(sb.toString(), Person.class);
        final Person person2 = gson2.fromJson(sb.toString(), Person.class);
        person.setFirstName("Carolina");
        System.out.println(showPersonProperties(person));
        System.out.println(gson2.toJson(person2));
    }

    public Person fromJson(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }

    // imprimiendo todo el objeto a través de toString
    public static String showPerson(Person person) {
        return person.toString();
    }

    // imprimir por propiedades
    public static String showPersonProperties(Person person) {
        return "id: " + person.getId() + ", firstName: " + person.getFirstName() + ", lastName: "
                + person.getLastName();
    }
    
}
