package co.edu.uptc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {

    public static final String filePath = "src\\co\\edu\\uptc\\persistence\\";
    public static final String fileExtension = ".txt";
    private PrintWriter pw;
    private File file;
    private FileReader fr;
    private BufferedReader br;

    /* el método createFile crea un archivo con el nombre que se le pasa como parámetro.
     * Si el archivo ya existe, no lo sobreescribe, sino que lo abre en modo append (agrega al final).
     * Se utiliza PrintWriter para escribir en el archivo.
     * Tener en cuenta que este método utiliza el juego de caracteres del sistema operativo, 
     * por tannto puede guardar caracteres extraños por ejemplo en la acentuación.
     * 
     * @param fileName Nombre del archivo a crear.
     * @return true si el archivo se creó o abrió correctamente, false en caso contrario.
     */
    /* 
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
    */

    /* 
     * El método createFile crea un archivo con el nombre que se le pasa como parámetro.
     * Si el archivo ya existe, no lo sobreescribe, sino que lo abre en modo append (agrega al final).
     * Se utiliza PrintWriter para escribir en el archivo.
     * Este método asegura que el archivo se cree con codificación UTF-8.
     * 
     * @param fileName Nombre del archivo a crear.
     * @return true si el archivo se creó o abrió correctamente, false en caso contrario.
     */
    public boolean createFile(String fileName) {
        File file = new File(filePath + fileName + fileExtension);
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8))) {
            // Se crea el archivo vacío (o se asegura de que exista con codificación UTF-8)
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* 
     * El método writeFile escribe un objeto en el archivo especificado.
     * Si el archivo no existe, lo crea.
     * Utiliza PrintWriter para escribir en el archivo.
     * Tener en cuenta que este método utiliza el juego de caracteres del sistema operativo,
     * 
     * @param fileName Nombre del archivo donde se escribirá el objeto.
     * @param obj Objeto a escribir en el archivo.
     * @return true si la escritura fue exitosa, false en caso contrario.
     */
    /*
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
    */

    /* 
     * El método writeFile escribe un objeto en el archivo especificado.
     * Si el archivo no existe, lo crea.
     * Utiliza PrintWriter para escribir en el archivo con codificación UTF-8.
     * 
     * @param fileName Nombre del archivo donde se escribirá el objeto.
     * @param obj Objeto a escribir en el archivo.
     * @return true si la escritura fue exitosa, false en caso contrario.
     */
    public boolean writeFile(String fileName, Object obj) {
        File file = new File(filePath + fileName + fileExtension);
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8))) {
            pw.println(obj);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* 
     * El método readFile lee el contenido de un archivo y devuelve una lista de cadenas.
     * Utiliza BufferedReader para leer el archivo línea por línea.
     * Tener en cuenta que este método utiliza el juego de caracteres del sistema operativo,
     * por tannto puede leer caracteres extraños por ejemplo en la acentuación.
     * 
     * @param fileName Nombre del archivo a leer.
     * @return Lista de cadenas con el contenido del archivo.
     */
    public List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath + fileName + fileExtension), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
