package co.edu.uptc.control;

import java.util.ArrayList;

import co.edu.uptc.model.Empresa;
import co.edu.uptc.model.Person;

public class EmpresaControl {

    private Empresa e;

    public boolean addEmpresa(int id, ArrayList<Person> empleados) {
        e = new Empresa();
        e.setId(id);
        e.setEmpleados(empleados);
        return true;
    }

    public Empresa showEmpresa() {
        return e;
    }
}
