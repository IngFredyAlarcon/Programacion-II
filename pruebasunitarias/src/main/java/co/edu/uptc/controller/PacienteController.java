package co.edu.uptc.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Paciente;

public class PacienteController {
    private List<Paciente> pacientes = new ArrayList<>();

    public void crearPaciente(String nombre, int edad, String id) {
        pacientes.add(new Paciente(nombre, edad, id));
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    public Paciente buscarPaciente(String id) {
        return pacientes.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean actualizarPaciente(String id, String nuevoNombre, int nuevaEdad) {
        Paciente paciente = buscarPaciente(id);
        if (paciente != null) {
            paciente.setNombre(nuevoNombre);
            paciente.setEdad(nuevaEdad);
            return true;
        }
        return false;
    }

    public boolean eliminarPaciente(String id) {
        return pacientes.removeIf(p -> p.getId().equals(id));
    }
}
