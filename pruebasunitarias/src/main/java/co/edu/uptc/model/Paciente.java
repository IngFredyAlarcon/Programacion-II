package co.edu.uptc.model;

public class Paciente {
    private String nombre;
    private int edad;
    private String id;

    public Paciente(String nombre, int edad, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", edad=" + edad + ", id=" + id + "]";
    }

}
