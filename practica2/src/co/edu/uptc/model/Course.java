package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private String code;
    private int credits;
    private List<Student> students;

    public Course(String name, String code, int credits) {
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.students=new ArrayList<>();
    }

    public Course() {

        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", code: " + code +
                ", credits: " + credits;
    }
}
