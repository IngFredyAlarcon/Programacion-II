import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializedDesarializedObjectJson {
    public static void main(String[] args) {
        //path to the file only one object
        String path = "src/data.json";
        //path to the file objects collection
        String pathCollection = "src/dataPersons.json";
        Person person = new Person(1, "Laura", "Tobón");
        String json = serializeObjectToJson(person);
        System.out.println(json);

        //Deserialize usando una cadena json
        Person person2 = (Person) deserializeObjectFromJson(json, Person.class);
        System.out.println(person2);

        //Deserialize usando un archivo json
        Person person3 = (Person) deserializeObjectFromJson(readJsonFile(path), Person.class);
        System.out.println(person3);

        //Serialize objects collection to json
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(1, "Laura", "Tobón"));
        list.add(new Person(2, "Carolina", "Gómez"));
        list.add(new Person(3, "Andrea", "Serna"));
        String jsonCollection = serializeObjectCollectionToJson(list);
        System.out.println(jsonCollection);
        
    }

    //Serialize object to json: Recibe un objeto de una clase y lo convierte en un String en formato JSON
    public static String serializeObjectToJson(Object object) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.toJson(object);
    }

    //Serialize objects collection to json: Recibe un arrayList de objetos de una clase y lo convierte en un String en formato JSON
    public static String serializeObjectCollectionToJson(ArrayList<Person> list) {
        Directory directory1 = new Directory(1, list);
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.toJson(directory1);
    }

    //Deserialize object from json: Recibe un String en formato JSON y lo convierte en un objeto de una clase
    public static Object deserializeObjectFromJson(String json, Class<?> classType) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.fromJson(json, classType);
    }

    //Read json file only one object
    public static String readJsonFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(path);
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
        return sb.toString();
    }

    //Read json file objects collection
    public static String readJsonFileCollection(String pathCollection) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(pathCollection);
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
        return sb.toString();
    }
}
