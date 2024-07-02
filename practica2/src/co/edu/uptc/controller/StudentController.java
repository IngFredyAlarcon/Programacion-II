package co.edu.uptc.controller;

import co.edu.uptc.model.Student;
import java.util.ArrayList;

public class StudentController {
    Student student;
    private static StudentController _instance;

    public StudentController() {
        student = new Student();
    }

    public static StudentController getInstance()   {
        if (_instance==null) {
            _instance=new StudentController(); //Singleton
        }
        return _instance;
    }

    public void saveStudent(String firstName, String lastName, String email, String id) {
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setId(id);
        student.setCourses(new ArrayList<>());
    }

    public void addStudent(String firstName, String lastName, String email, String id)  {
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setId(id);
    }
    public void editStudent(String firstName, String lastName, String email, String id) {
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setId(id);
    }

    public void deleteStudent() {
        student = null;
    }

    public Student getStudent() {
        return student;
    }
}
