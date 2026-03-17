package co.edu.uptc.service;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import co.edu.uptc.model.Cita;
import co.edu.uptc.repository.JsonRepository;

public class CitaService {
    private JsonRepository<Cita> repository;

    public CitaService() {

        Type type = new TypeToken<List<Cita>>(){}.getType();
        repository = new JsonRepository<>("citas.json", type);
    }

    public void crear(Cita cita) {
        repository.save(cita);
    }

    public List<Cita> listar() {
        return repository.findAll();
    }
}
