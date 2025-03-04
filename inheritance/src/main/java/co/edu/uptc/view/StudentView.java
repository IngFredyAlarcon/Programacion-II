package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.controller.StudentController;

public class StudentView {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student's name:");
        String name = scanner.nextLine();
        System.out.println("Enter the student's last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter the student's age:");
        int age = scanner.nextInt();
        System.out.println("Enter the student's ID:");
        String studentId = scanner.next();
        if (studentController.createStudent(name, lastName, age, studentId)) {
            System.out.println("The student was created successfully.");
        } else {
            System.out.println("An error occurred while creating the student.");
        }
        scanner.close();
        
    }

}
