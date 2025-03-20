package co.edu.uptc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ShowPersonsList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Directory directory = new Directory();
        directory.setId(1);
        List<Person> listPersons = directory.getListPersons();
        
        // deserialization list Json to Object
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        try {
            File file = new File("demogson\\src\\dataPersons.json");
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            //listPersons = gson.fromJson(sb.toString(), List.class);
            //directory.setListPersons(listPersons);
            br.close();
            // Ojo: Para tener en cuenta por errores de tipos de datos
            // Especificamos el tipo correcto para evitar que los enteros se conviertan en double
            Type listType = new TypeToken<List<Person>>() {}.getType();
            listPersons = gson.fromJson(sb.toString(), listType);
            directory.setListPersons(listPersons);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // print directory properties
        System.out.println(showDirectoryProperties(directory, gson));

        // find person by id
        System.out.println("Ingrese el id de la persona a buscar: ");
        int id = sc.nextInt();

        Person person = findPersonById(id);
        if (person != null) {
            System.out.println(showPersonProperties(person));
        } else {
            System.out.println("No se encontró la persona con id: " + id);
        }

        // Update properties of the person searched by id
        System.out.println("Ingrese el id de la persona a actualizar: ");
        int idUpdate = sc.nextInt();
        Person personUpdate = findPersonById(idUpdate);
        if (personUpdate != null) {
            // select property to update
            int option = 0;
            while(option != 3) {
                System.out.println("Seleccione la propiedad a actualizar: ");
                System.out.println("1. firstName");
                System.out.println("2. lastName");
                System.out.println("3. Salir");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre: ");
                        String firstName = sc.next();
                        personUpdate.setFirstName(firstName);
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo apellido: ");
                        String lastName = sc.next();
                        personUpdate.setLastName(lastName);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
            
        } else {
            System.out.println("No se encontró la persona con id: " + idUpdate);
        }

        // Update file dataPersons.json
        updatePerson(personUpdate, gson);
        sc.close();

    }

    // print directory properties with pretty format
    public static String showDirectoryProperties(Directory directory, Gson gson) {
        return gson.toJson(directory);
    }
    
    // find person by id in file dataPersons.json
    public static Person findPersonById(int id) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        try {
            File file = new File("demogson\\src\\dataPersons.json");
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            Type listType = new TypeToken<List<Person>>() {}.getType();
            List<Person> listPersons = gson.fromJson(sb.toString(), listType);
            for (Person person : listPersons) {
                if (person.getId() == id) {
                    return person;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    

    // print person properties
    public static String showPersonProperties(Person person) {
        return "id: " + person.getId() + ", firstName: " + person.getFirstName() + ", lastName: "
                + person.getLastName();
    }

    // update person properties by id and update file dataPersons.json
    public static void updatePerson(Person person, Gson gson) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson2 = gb.create();
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        try {
            File file = new File("demogson\\src\\dataPersons.json");
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            Type listType = new TypeToken<List<Person>>() {}.getType();
            List<Person> listPersons = gson.fromJson(sb.toString(), listType);
            for (Person p : listPersons) {
                if (p.getId() == person.getId()) {
                    p.setFirstName(person.getFirstName());
                    p.setLastName(person.getLastName());
                }
            }
            br.close();
            System.out.println(gson2.toJson(listPersons));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
