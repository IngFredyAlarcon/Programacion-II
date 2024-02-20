import java.util.ArrayList;

public class EjemploArrayList {
    public static void main(String[] args) {
        ArrayList<String> listaNombres = new ArrayList<String>();
        listaNombres.add("Juan");
        listaNombres.add("Pedro");
        listaNombres.add("Juan");

        if (listaNombres.contains("Juan")) {
            System.out.println("Juan está en la lista :" + listaNombres.indexOf("Juan"));
        }

        for (String nombre : listaNombres) {
            System.out.println(nombre);
        }
    }
}
