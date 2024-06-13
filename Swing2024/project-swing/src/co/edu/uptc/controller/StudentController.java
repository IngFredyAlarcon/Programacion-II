package co.edu.uptc.controller;

import co.edu.uptc.model.Student;

public class StudentController {
    Student student;

    public StudentController() {
        student = new Student();
    }

    public void saveStudent(String firstName, String lastName, String email, String id) {
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setId(id);
    }

    public Student getStudent() {
        return student;
    }
}
