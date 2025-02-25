package co.edu.uptc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {

    public static final String filePath = "src\\co\\edu\\uptc\\persistence\\";
    public static final String fileExtension = ".txt";
    private PrintWriter pw;
    private File file;
    private FileReader fr;
    private BufferedReader br;

    public boolean createFile(String fileName) {
        file = new File(fileName);
        try {
            // pw = new PrintWriter(filePath + file + fileExtension);// Cuando se quiere
            // sobreescribir el archivo
            pw = new PrintWriter(new FileWriter(filePath + file + fileExtension, true));// Sin sobreescribir,
                                                                                        // adicionando en una nueva                                                                        // línea
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
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
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath + fileName + fileExtension))) {
            String line="";
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
