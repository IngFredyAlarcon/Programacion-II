package co.edu.uptc.test;

import java.util.Scanner;

import co.edu.uptc.control.PersonControl;

public class TestPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonControl pc = new PersonControl();
        String firstName, lastName;
        int age;
        boolean result = false;
        System.out.println("Enter the First Name");
        firstName = sc.nextLine();
        System.out.println("Enter the Last Name");
        lastName = sc.nextLine();
        System.out.println("Enter the age");
        age = sc.nextInt();
        result = pc.addPerson(firstName, lastName, age);
        if (result) {
            System.out.println("Data add successfull");
            System.out.println(pc.showInformationPerson());
            pc.saveInformationPerson("person", pc.showInformationPerson());
        } else {
            System.out.println("Error");
        }

        sc.close();
    }
}
