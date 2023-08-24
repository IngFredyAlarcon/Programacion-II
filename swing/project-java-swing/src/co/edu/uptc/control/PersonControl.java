package co.edu.uptc.control;

import co.edu.uptc.model.Person;

public class PersonControl {

    private Person p;

    public boolean addPerson(String name, int age) {
        p = new Person();
        p.setName(name);
        p.setAge(age);
        return true;
    }
}
