package co.edu.uptc.test;

import co.edu.uptc.model.Cat;
import co.edu.uptc.model.Person;

public class TestMammal {
    public static void main(String[] args) {
        Person p1 = new Person();
        System.out.println(p1.walking());
        System.out.println(p1.walking(3));
        Cat c1 = new Cat();
        System.out.println(c1.walking());

    }
}
