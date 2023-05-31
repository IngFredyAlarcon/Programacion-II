package co.edu.uptc.modelo;

public class Estudiante extends Persona {
    private String codigo;
    private String programa;

    // Sino se coloca el método super que es la invocación al constructor de la
    // clase Persona y asignar al estudiante un nombre, apellido y una edad nos
    // marcará errores

    public Estudiante(String nombre, String apellido, int edad, String codigo, String programa) {
        super(nombre, apellido, edad);
        this.codigo = codigo;
        this.programa = programa;
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
        return "Estudiante " + super.toString() + "[codigo=" + codigo + ", programa=" + programa + "]";
    }

}
