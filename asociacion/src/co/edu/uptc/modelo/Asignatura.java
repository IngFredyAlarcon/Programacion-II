package co.edu.uptc.modelo;

public class Asignatura {
    private String codigo;
    private String nombre;
    private int numeroCreditos;

    public Asignatura(String codigo, String nombre, int numeroCreditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroCreditos = numeroCreditos;
    }

    public Asignatura() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    @Override
    public String toString() {
        return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + ", numeroCreditos=" + numeroCreditos + "]";
    }

}
