package co.edu.uptc.service;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import co.edu.uptc.model.Paciente;
import co.edu.uptc.repository.JsonRepository;

public class PacienteService {
    private JsonRepository<Paciente> repository;

    public PacienteService() {
        Type type = new TypeToken<List<Paciente>>() {
        }.getType();
        System.out.println("Estoy en PacienteService y el tipo es"+type);
        repository = new JsonRepository<>("pacientes.json", type);
    }

    public void crear(Paciente paciente) {
        repository.save(paciente);
    }

    public List<Paciente> listar() {
        return repository.findAll();
    }

    public Paciente buscarPorId(String id) {

        return repository.findAll()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
