package co.edu.uptc.control;

import java.util.ArrayList;

import co.edu.uptc.model.Person;

public class PersonControl {

    private Person p;
    private ArrayList<Person> listPersons;

    public PersonControl() {
        this.listPersons = new ArrayList<>();
    }

    public boolean addPerson(String name, int age) {
        p = new Person();
        p.setName(name);
        p.setAge(age);
        return true;
    }

    public void addPersons(String name, int age) {
        p = new Person();
        p.setName(name);
        p.setAge(age);
        listPersons.add(p);
    }

    public ArrayList<Person> listPersons() {
        return listPersons;
    }
}
