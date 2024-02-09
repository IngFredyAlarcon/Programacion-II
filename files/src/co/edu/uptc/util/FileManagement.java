package co.edu.uptc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManagement {
    private File file;
    private PrintWriter pw;
    private BufferedReader br;
    public static final String filePath = "src\\co\\edu\\uptc\\persistence\\";
    public static final String fileExtension = ".txt";

    public boolean createFile(String fileName) {
        file = new File(fileName);
        try {
            // pw = new PrintWriter(filePath + file + fileExtension);// Cuando se quiere
            // sobreescribir el archivo
            pw = new PrintWriter(new FileWriter(filePath + file + fileExtension, true));// Sin sobreescribir,
            // adicionando en una nueva línea
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
            // e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean writeFile(String fileName, Object obj) {
        file = new File(fileName);
        try {
            // pw = new PrintWriter(filePath + file + fileExtension);// Cuando se quiere
            // sobreescribir el archivo
            pw = new PrintWriter(new FileWriter(filePath + file + fileExtension, true));// Sin sobreescribir,
            pw.println(obj);
            pw.close();// Ojo recordar siempre cerra el archivo después de realizar cualquier operación
                       // // adicionando en una nueva
                       // línea
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
            // e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> readFile(String fileName) {
        file = new File(fileName);
        ArrayList<String> result = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(filePath + file + fileExtension));
            String line = br.readLine();
            while (line != null) {
                result.add(line);
                line = br.readLine();
            }
            br.close();
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
            // e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
