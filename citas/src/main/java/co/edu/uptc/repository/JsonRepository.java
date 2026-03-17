package co.edu.uptc.repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class JsonRepository<T> implements Repository<T> {

    private final String fileName;
    private final Gson gson;
    private final Type type;

    public JsonRepository(String fileName, Type type) {
        this.fileName = fileName;
        this.type = type;
        this.gson = new Gson();
    }

    @Override
    public void save(T entity) {

        List<T> data = findAll();
        data.add(entity);

        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> findAll() {

        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
