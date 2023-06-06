package co.edu.uptc.modelo;

import java.util.ArrayList;

public class Estudiante extends Persona {
    private String codigo;
    private String programa;
    // private Asignatura asignatura;
    // private Asignatura[] asignatura;
    private ArrayList<Asignatura> listaAsignaturas;
    private Usuario usuario;

    // Sino se coloca el método super que es la invocación al constructor de la
    // clase Persona y asignar al estudiante un nombre, apellido y una edad nos
    // marcará errores

    public Estudiante(String nombre, String apellido, int edad, String codigo, String programa) {
        super(nombre, apellido, edad);
        this.codigo = codigo;
        this.programa = programa;
        listaAsignaturas = new ArrayList<Asignatura>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "Estudiante [codigo=" + codigo + ", programa=" + programa + ", listaAsignaturas=" + listaAsignaturas
                + ", usuario=" + usuario + "]";
    }

}
