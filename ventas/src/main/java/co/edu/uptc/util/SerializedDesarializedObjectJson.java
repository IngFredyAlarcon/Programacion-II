package co.edu.uptc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializedDesarializedObjectJson<T> {
    
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

    //Serialize object to json: Recibe un objeto de una clase y lo convierte en un String en formato JSON
    public static String serializeObjectToJson(Object object) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.toJson(object);
    }

    //Serialize objects collection to json: Recibe un arrayList de objetos de una clase y lo convierte en un String en formato JSON
    public String serializeObjectCollectionToJson(ArrayList<T> list) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.toJson(list);
    }

    //Deserialize object from json: Recibe un String en formato JSON y lo convierte en un objeto de una clase
    public static Object deserializeObjectFromJson(String json, Class<?> classType) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.fromJson(json, classType);
    }

    /*
    //Deserialize list object from json: Recibe un listo de objetos en un String en formato JSON y lo convierte en un listado de objetos de una clase
    public ArrayList<T> deserializeListObjectFromJson(String json, Class<?> classType) {
        GsonBuilder gb = new GsonBuilder();
        ArrayList<T> list = new ArrayList<>();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        for (T object : list) {
            list.add((T) gson.fromJson(json, classType));
        }
        return gson.fromJson(json, classType);
    }
        */
}
