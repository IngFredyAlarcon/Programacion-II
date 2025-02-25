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
    private File file;
    private PrintWriter pw;
    private BufferedReader br;
    public static final String filePath = "src\\co\\edu\\uptc\\persistence\\";
    public static final String fileExtension = ".txt";

    public boolean createFile(String fileName){
        file = new File(fileName);
        try {
          pw = new PrintWriter(new FileWriter(filePath + file + fileExtension, true));
          return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean writeFile(String fileName, Object obj){
        file = new File(fileName);
        try {
            pw = new PrintWriter(new FileWriter(filePath + file + fileExtension, true));
            pw.println(obj);
            pw.close();
            return true;
          } catch (FileNotFoundException e) {
              e.printStackTrace();
              return false;
          } catch (IOException e){
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
