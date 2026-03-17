package co.edu.uptc.model;

public class Paciente {
    private String id;
    private String nombre;
    private int edad;
    
    public Paciente(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Paciente() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
    }

}
