package co.edu.uptc.model;

import java.util.ArrayList;

public class Empresa {
    private int id;
    private ArrayList<Person> empleados;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Person> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Person> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", empleados=" + empleados + "]";
    }

}
