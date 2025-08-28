package co.edu.uptc;

import java.util.List;

public class Directory {
    int id;
    List<Person> listPersons;
    
    public Directory(int id, List<Person> listPersons) {
        this.id = id;
        this.listPersons = listPersons;
    }

    public Directory() {
    }
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

    public void addPerson(Person person) {
        this.listPersons.add(person);
    }

    public void removePerson(int id) {
        this.listPersons.removeIf(p -> p.getId() == id);
    }

    @Override
    public String toString() {
        return "Directory [id=" + id + ", listPersons=" + listPersons + "]";
    }

}
