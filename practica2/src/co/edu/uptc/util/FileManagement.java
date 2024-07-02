package co.edu.uptc.util;

import co.edu.uptc.model.Course;
import co.edu.uptc.model.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class FileManagement {
    public static PrintWriter pw;
    public static final  String filePath="src\\";
    public static final String fileExtension =".json";

    public  String createFileJson(String fileJsonName) {
        try {
            pw = new PrintWriter(new FileWriter(filePath + fileJsonName + fileExtension, true));
            return "archivo creado";
        } catch (FileNotFoundException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public ArrayList<Course> deserealiseObjectCollectionFromJson2(String listPath, Class<?> classType) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        java.lang.reflect.Type type = new TypeToken<ArrayList<Course>>(){}.getType();
        ArrayList<Course> courses = gson.fromJson(listPath, type);

        return courses;
    }

    public ArrayList<Student> deserealiseObjectCollectionFromJson(String listPath, Class<?> classType) {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        java.lang.reflect.Type type = new TypeToken<ArrayList<Student>>(){}.getType();
        ArrayList<Student> students = gson.fromJson(listPath, type);
        return students;
    }
    public String serializeObjectCollectionToJson2(ArrayList<?> list)   {
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson=gsonBuilder.create();

        return gson.toJson(list);
    }



    public String readJsonFile(String path)  {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();// lee la primera linea del archivo
            while (line != null)    {
                sb.append(line);
                line=br.readLine();// lee la siguiente linea
            }
            br.close();
        }catch (FileNotFoundException e)    {
            System.out.println("No encontrado"+ e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    public void saveData(String path, String newContentJson) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(newContentJson);

        } catch (Exception e) {
            System.out.println("sin acceso: archivo no encontrado");
        }
    }


}
