package co.edu.uptc.controller;

import co.edu.uptc.model.Student;

public class StudentController {
    public boolean createStudent(String name, String lastName, int age, String studentId) {
        Student student = new Student(name, lastName, age, studentId);
        return student.save();
    }

    public boolean updateStudent(String name, String lastName, int age, String studentId) {
        Student student = new Student(name, lastName, age, studentId);
        return student.update();
    }

    public boolean deleteStudent(String studentId) {
        Student student = new Student("", "", 0, studentId);
        return student.delete();
    }
    
}
