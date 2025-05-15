package co.edu.uptc.persistence;

import java.io.File;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class JsonRepository<T> implements Repository<T> {
    private final File file;
    private final Gson gson;
    private final Type type;

    public JsonRepository(String path, Type type) {
        this.file = new File(path);
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.type = type;
    }

    @Override
    public void save(List<T> items) {
        try (FileWriter writer = new FileWriter(file)) {
            String json = gson.toJson(items, type);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> load() {
        try (Reader reader = new FileReader(file)) {
            List<T> data = gson.fromJson(reader, type);
            return (data != null) ? data : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<T> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(T entity) {
        // TODO Auto-generated method stub
        
    }

    

    /*@Override
    public void save(List<T> items) {
        try (FileWriter writer = new FileWriter(file)) {
            String json = gson.toJson(items, type);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T findById(int id) {
        List<T> items = findAll();
        for (T item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void update(T entity) {
        List<T> items = findAll();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == entity.getId()) {
                items.set(i, entity);
                break;
            }
        }
        save(items);
    }

    @Override
    public void delete(int id) {
        List<T> items = findAll();
        items.removeIf(item -> item.getId() == id);
        save(items);
    }

    @Override
    public List<T> findAll() {
        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void deleteAll() {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("[]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
