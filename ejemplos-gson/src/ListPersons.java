import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ListPersons {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File("src\\dataPersons.json");
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

        // bloque con un String construido desde un archivo
        final Gson gson2 = gb.create();
        final Person person = gson.fromJson(sb.toString(), Person.class);
        final Person person2 = gson2.fromJson(sb.toString(), Person.class);
        person.setFirst_name("Carolina");
        System.out.println(showPersonProperties(person));
        System.out.println(gson2.toJson(person2));
    }
}
