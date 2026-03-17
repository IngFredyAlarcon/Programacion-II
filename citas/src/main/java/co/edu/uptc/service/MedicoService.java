package co.edu.uptc.service;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import co.edu.uptc.model.Medico;
import co.edu.uptc.repository.JsonRepository;

public class MedicoService {
    private JsonRepository<Medico> repository;

    public MedicoService() {

        Type type = new TypeToken<List<Medico>>() {
        }.getType();
        repository = new JsonRepository<>("medicos.json", type);
    }

    public void crearMedico(Medico medico) {
        repository.save(medico);
    }

    public List<Medico> listar() {
        return repository.findAll();
    }

    public Medico buscarPorId(String id) {

        return repository.findAll()
                .stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
