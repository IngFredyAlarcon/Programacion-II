package co.edu.uptc;

import java.util.List;

public class Directory {
    private int id;
    private List<Person> listPersons;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Person> getListPersons() {
        return listPersons;
    }
    public void setListPersons(List<Person> listPersons) {
        this.listPersons = listPersons;
    }

    @Override
    public String toString() {
        return "Directory [id=" + id + ", listPersons=" + listPersons + "]";
    }
    
}
