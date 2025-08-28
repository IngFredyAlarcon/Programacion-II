package co.edu.uptc;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ListPersons {
    public static void main(String[] args) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();

        Directory directory = null;

        // Leer listado de personas desde archivo JSON y crear el directorio
        try (FileReader reader = new FileReader("src/main/resources/dataPersons.json")) {
            Type listType = new TypeToken<List<Person>>() {}.getType();
            List<Person> persons = gson.fromJson(reader, listType);

            directory = new Directory(2, persons);

            System.out.println("Directorio inicial:");
            System.out.println("------------------------------------------------------");
            System.out.println(gson.toJson(directory));
            System.out.println("------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (directory != null) {
            // Adicionar una persona
            Person newPerson = new Person(12, "Fredy", "Alarcon");
            addPerson(directory, newPerson);

            // Eliminar una persona por id
            removePerson(directory, 3); // elimina a "Lela"

            // Mostrar cambios en memoria
            System.out.println("Directorio actualizado:");
            System.out.println("------------------------------------------------------");
            System.out.println(gson.toJson(directory));
            System.out.println("------------------------------------------------------");

            // Guardar los cambios en el archivo JSON
            try (FileWriter writer = new FileWriter("src/main/resources/directoryPersons.json")) {
                gson.toJson(directory, writer); // guardamos SOLO la lista
                System.out.println("Archivo JSON actualizado correctamente");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Buscar una persona por id
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el ID de la persona a buscar: ");
            int searchId = scanner.nextInt();
            Person foundPerson = findPersonById(directory, searchId);
            if (foundPerson != null) {
                System.out.println("Persona encontrada: " + gson.toJson(foundPerson));
            } else {
                System.out.println("Persona con ID " + searchId + " no encontrada.");
            }

            // Buscar personas por nombre
            scanner.nextLine(); // Limpiar el buffer
            System.out.print("Ingrese el nombre de la persona a buscar: ");
            String searchName = scanner.nextLine();
            List<Person> personsByName = findPersonsByName(directory, searchName);
            System.out.println("Personas con nombre '" + searchName + "': " + gson.toJson(personsByName));

            // Buscar personas por apellido
            String searchLastName = "Alarcon";
            List<Person> personsByLastName = findPersonsByLastName(directory, searchLastName);
            System.out.println("Personas con apellido '" + searchLastName + "': " + gson.toJson(personsByLastName) );
            System.out.println("------------------------------------------------------");
            System.out.println("Total personas en el directorio: " + directory.getListPersons().size() );
            System.out.println("------------------------------------------------------");
        }
            
    }

    //Método para adicionar una persona al directorio
    public static void addPerson(Directory directory, Person person) {
        directory.addPerson(person);
    }

    //Método para eliminar una persona del directorio por id
    public static void removePerson(Directory directory, int id) {
        directory.removePerson(id);
    }

    //Método para buscar una persona en el directorio por id
    public static Person findPersonById(Directory directory, int id) {
        for (Person person : directory.getListPersons()) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    //Método para buscar personas en el directorio por nombre
    public static List<Person> findPersonsByName(Directory directory, String name) {
        return directory.getListPersons().stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(name))
                .toList();
    }

    //Método para buscar personas en el directorio por apellido
    public static List<Person> findPersonsByLastName(Directory directory, String lastName) {
        return directory.getListPersons().stream()
                .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }
}
